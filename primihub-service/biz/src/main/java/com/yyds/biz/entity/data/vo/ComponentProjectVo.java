package com.yyds.biz.entity.data.vo;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ComponentProjectVo {
    private Long projectId;
    private String projectName;
    private List<ComponentResourceVo> resources;
}
