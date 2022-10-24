package com.primihub.biz.constant;

import java.util.regex.Pattern;

public class DataConstant {
    public final static String FEDLEARNER_JOB_RUN = "http://fedlearner/job_api/run";
    public final static String MATCHES="[a-zA-Z]+";
    public final static String FIELD_NAME_AS="field_";
    // Template address
    public final static String FREEMARKER_PYTHON_EN_PAHT= "disxgb_en.ftl";
    public final static String FREEMARKER_PYTHON_HOMO_LR_PAHT= "homo_lr.ftl";
    public final static String FREEMARKER_PYTHON_HOMO_LR_INFER_PAHT= "homo_lr_infer.ftl";
    // python dataset host、guest
    public final static String PYTHON_LABEL_DATASET = "label_dataset";
    public final static String PYTHON_GUEST_DATASET = "guest_dataset";
    public final static String PYTHON_ARBITER_DATASET = "arbiter_dataset";
    public final static String PYTHON_CALCULATION_FIELD = "label_field";
    public final static String PYTHON_LABEL_PORT = "label_port";
    public final static String PYTHON_GUEST_PORT = "guest_port";

    // Set the timeout for 5 minutes
    public final static Integer UPDATE_MODEL_TIMEOUT = 300000;

    public final static Integer INSERT_DATA_TABLE_PAGESIZE = 1000;

    public final static Pattern RESOURCE_PATTERN_INTEGER = Pattern.compile("^-?\\d{1,9}$");
    public final static Pattern RESOURCE_PATTERN_LONG = Pattern.compile("^-?\\d{10,}$");
    public final static Pattern RESOURCE_PATTERN_DOUBLE = Pattern.compile("^-?\\d+\\.\\d+$");
    public final static Integer READ_DATA_ROW = 50;
    public final static Integer COPY_PAGE_NUM = 20;

    // ModelComponentService impl bean name suffix
    public final static String COMPONENT_BEAN_NAME_SUFFIX = "ComponentTaskServiceImpl";

    // Port number Range
    public final static Long[] GUEST_PORT_RANGE = new Long[]{20000L,30000L};
    public final static Long[] HOST_PORT_RANGE = new Long[]{40000L,50000L};

    // email
    public final static String TASK_EMAIL_SUBJECT ="[Primihub] Primihub Platform Task Notification!";

    public final static String TASK_EMAIL_TEXT= "" +
            "尊敬的【<username>】您在【<date>】使用【<user>】创建的任务已失败，请前往原语Primihub隐私计算平台查看详情\n" +
            "任务名称：【<taskname>】\n" +
            "任务ID：【<taskidname>】\n" +
            "【http://<prefix>.primihub.com/#/project/detail/<projectId>/task/<taskid>】";


}
