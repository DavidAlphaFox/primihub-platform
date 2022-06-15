package com.yyds.biz.entity.data.po;

import lombok.Data;

import java.util.Date;

/**
 * 资源表
 */
@Data
public class DataResource {
    /**
     * 资源id
     */
    private Long resourceId;
    /**
     * 资源名称
     */
    private String resourceName;
    /**
     * 资源描述
     */
    private String resourceDesc;
    /**
     * 资源分类 1.银行 2.电商 3.媒体 4.运营商 5.保险
     */
    private Integer resourceSortType;
    /**
     * 授权类型 1.公开 2.私有
     */
    private Integer resourceAuthType;
    /**
     * 资源来源 文件上传 数据库链接
     */
    private Integer resourceSource;
    /**
     * 资源数
     */
    private Integer resourceNum;
    /**
     * 文件id
     */
    private Long fileId;
    /**
     * 文件大小
     */
    private Integer fileSize;
    /**
     * 文件后缀
     */
    private String fileSuffix;
    /**
     * 文件行数
     */
    private Integer fileRows;
    /**
     * 文件列数
     */
    private Integer fileColumns;
    /**
     * 文件处理状态 0 未处理 1处理中 2处理完成 3失败
     */
    private Integer fileHandleStatus;
    /**
     * 表头
     */
    private String fileHandleField;
    /**
     * 数据库id
     */
    private Long dbId;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 机构id
     */
    private Long organId;
    /**
     * 资源标识路径
     */
    private String url;
    /**
     * 是否删除
     */
    private Integer isDel;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改时间
     */
    private Date updateDate;
}
