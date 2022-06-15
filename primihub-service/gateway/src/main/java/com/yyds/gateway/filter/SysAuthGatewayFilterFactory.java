package com.yyds.gateway.filter;

import com.yyds.biz.entity.base.BaseParamEnum;
import com.yyds.biz.entity.base.BaseResultEnum;
import com.yyds.biz.entity.sys.vo.SysAuthNodeVO;
import com.yyds.biz.entity.sys.vo.SysUserListVO;
import com.yyds.biz.repository.primaryredis.sys.SysUserPrimaryRedisRepository;
import com.yyds.biz.service.sys.SysAuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Order(11)
@Component
public class SysAuthGatewayFilterFactory extends AbstractGatewayFilterFactory {

    @Autowired
    private SysUserPrimaryRedisRepository sysUserPrimaryRedisRepository;
    @Autowired
    private SysAuthService sysAuthService;

    @Override
    public GatewayFilter apply(Object config) {
        return (((exchange, chain) -> {
            String token=exchange.getAttribute(BaseParamEnum.TOKEN.getColumnName());
            if(token==null||token.equals(""))
                return chain.filter(exchange).then();

            SysUserListVO sysUserListVO=sysUserPrimaryRedisRepository.findUserLoginStatus(token);
            if(sysUserListVO==null)
                return GatewayFilterFactoryTool.writeFailureJsonToResponse(exchange, BaseResultEnum.TOKEN_INVALIDATION);
            sysUserPrimaryRedisRepository.expireUserLoginStatus(token,sysUserListVO.getUserId());

            String rawPath=exchange.getRequest().getURI().getRawPath();
            Map<String, SysAuthNodeVO> mapping=sysAuthService.getSysAuthUrlMapping();
            SysAuthNodeVO sysAuthNodeVO=mapping.get(rawPath);
            if(sysAuthNodeVO!=null){
                if(!sysUserListVO.getAuthIdList().contains(sysAuthNodeVO.getAuthId().toString()))
                    return GatewayFilterFactoryTool.writeFailureJsonToResponse(exchange, BaseResultEnum.NO_AUTH);
            }

            String userIdStr=sysUserListVO.getUserId().toString();
            String[] rOrganList=sysUserListVO.getROrganIdList().split(",");
            String organId=rOrganList.length>0&&rOrganList[0]!=null&&!rOrganList[0].equals("")?rOrganList[0]:"-1";
            ServerHttpRequest newRequest = exchange.getRequest().mutate()
                    .header("userId", userIdStr)
                    .header("organId", organId)
                    .header("token", token)
                    .header("organCode", "USER,ORGAN")
                    .build();
            return chain.filter(exchange.mutate().request(newRequest).build());
        }));
    }
}