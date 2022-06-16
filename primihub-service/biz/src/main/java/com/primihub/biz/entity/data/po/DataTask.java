package com.primihub.biz.entity.data.po;

import lombok.Getter;
import lombok.Setter;

import java.sql.Blob;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author a
 * @since 2022-06-07
 */
@Getter
@Setter
public class DataTask {


    /**
     * 任务id
     */
    private Long taskId;

    /**
     * 任务id展示名
     */
    private String taskIdName;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 任务状态(0未开始 1成功 2运行中 3失败 4取消)
     */
    private Integer taskState;

    /**
     * 任务类型 1、模型 2、PSI 3、PIR
     */
    private Integer taskType;

    /**
     * 文件返回路径
     */
    private String taskResultPath;

    /**
     * 文件返回内容
     */
    private Blob taskResultContent;

    /**
     * 任务开始时间
     */
    private Long taskStartTime;

    /**
     * 任务结束时间
     */
    private Long taskEndTime;

    /**
     * 任务创建人
     */
    private Long taskUserId;

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