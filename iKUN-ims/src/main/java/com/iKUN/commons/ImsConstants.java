package com.iKUN.commons;

public class ImsConstants {

    /** 数字转换成中文汉字数组 */
    public static final String[] UNITS = { "", "十", "百", };
    public static final String[] NUMS = { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九", };

    /** 院系类型 -学校 */
    public static final String DEPT_TYPE_SCHOOL = "0";
    /** 院系类型 -学院 */
    public static final String DEPT_TYPE_COLLAGE = "1";
    /** 院系类型 -专业 */
    public static final String DEPT_TYPE_PROFESSION = "2";
    /** 院系类型 -班级 */
    public static final String DEPT_TYPE_CLASS = "3";

    /** 删除状态-- 未删除 */
    public static final String dEL_NO = "0";
    /** 删除状态-- 已删除 */
    public static final String dEL_YES= "2";

    /** 审核状态-- 未审核通过 */
    public static final String STATUS_NOT_PASS= "2";
    /** 审核状态-- 审核通过 */
    public static final String STATUS_YES= "1";
    /** 审核状态-- 审核中 */
    public static final String STATUS_NO= "0";
    /** 周记提交状态 0-未提交 */
    public static final String PUBLISHED_0 = "0";
    /** 周记提交状态 1-已提交 */
    public static final String PUBLISHED_1 = "1";

    /** 招聘状态-- 招聘中 */
    public static final String RECRUIT_STATUS_NO= "0";
    /** 招聘状态-- 招聘结束 */
    public static final String RECRUIT_STATUS_YES= "1";

    /** 实习状态-- 未实习 */
    public static final String PRACTICE_STATUS_0= "0";
    /** 实习状态-- 实习中 */
    public static final String PRACTICE_STATUS_1= "1";
    /** 实习状态-- 实习结束 */
    public static final String PRACTICE_STATUS_2= "2";

    /** 实习类型-- 统一实习 */
    public static final String PRACTICE_TYPE_0= "0";
    /** 实习类型-- 自主实习 */
    public static final String PRACTICE_TYPE_1= "1";

    /** 实习考核类型-- 实习周记 */
    public static final String ASSESSMENT_TYPE_0= "0";
    /** 实习考核类型-- 实习总结 */
    public static final String ASSESSMENT_TYPE_1= "1";
    /** 实习考核类型-- 实习总结周次 */
    public static final String ASSESSMENT_TYPE_1_SUMMARY= "99";
    /** 周记是否提交 未提交 */
    public static final String WEEK_PUBLISHED_0 = "0";
    /** 周记是否提交 已提交 */
    public static final String WEEK_PUBLISHED_1 = "1";
    /** 选择-- 未选中 */
    public static final String IS_SELECT_NO= "0";
    /** 选择-- 选中 */
    public static final String IS_SELECT_YES= "1";

    /** 任务进度 -- 进行中*/
    public static final String TASK_PROCESS_01 = "01";
    /** 任务进度 -- 已完成*/
    public static final String TASK_PROCESS_02 = "02";

    /**任务类型 实习任务*/
    public static final String TASK_PROCESS_TYPE_1 = "I";
    /**任务类型 论文任务*/
    public static final String TASK_PROCESS_TYPE_2 = "P";

    /** 子任务类型 实习任务-实习申请 */
    public static final String CHILD_PROCESS_TYPE_I00 = "I00";
    /** 子任务类型 实习任务-实习周记 */
    public static final String CHILD_PROCESS_TYPE_I01 = "I01";
    /** 子任务类型 实习任务-实习总结 */
    public static final String CHILD_PROCESS_TYPE_I02 = "I02";
    /** 子任务类型 实习任务-实习鉴定表 */
    public static final String CHILD_PROCESS_TYPE_I03 = "I03";

    /** 论文题目 */
    public static final String CHILD_PROCESS_TYPE_P00 = "P00";

    /**是否为审核节点 是 */
    public static final String IS_CHECK_NODE_YES = "Y";
    /**是否为审核节点 是 */
    public static final String IS_CHECK_NODE_NO = "N";

    /** 节点类型-起始节点 */
    public static final String NODE_TYPE_START = "S";
    /** 节点类型-结束节点 */
    public static final String NODE_TYPE_END = "E";

    /** 流程是否结束-是 */
    public static final String PROCESS_END_Y = "Y";
    /** 流程是否结束-否 */
    public static final String PROCESS_END_N = "N";

    /** 流程阶段-待处理 */
    public static final String TASK_STAGE_Y00 = "Y00";
    /** 流程阶段-待指导老师审核 */
    public static final String TASK_STAGE_Y01 = "Y01";
    /** 流程阶段-待学院审核 */
    public static final String TASK_STAGE_Y02 = "Y02";
    /** 流程阶段-待学校审核 */
    public static final String TASK_STAGE_Y03 = "Y03";
    /** 流程阶段-审核完成 */
    public static final String TASK_STAGE_Y04 = "Y04";

    public static final String TRUE = "T";

    public static final String FALSE = "F";

    /** 论文状态 未提交 */
    public static final String TOPIC_STATUS_0 = "0";
    /** 论文状态 已提交课题，等待导师审批 */
    public static final String TOPIC_STATUS_1 = "1";
    /** 论文状态 未通过导师审批，等待修改 */
    public static final String TOPIC_STATUS_2 = "2";
    /** 论文状态 导师审批通过，等待学院审批 */
    public static final String TOPIC_STATUS_3 = "3";
    /** 论文状态 未通过学院审批，等待修改 */
    public static final String TOPIC_STATUS_4 = "4";
    /** 论文状态 学院已审批此课题，等待提交开题报告 */
    public static final String TOPIC_STATUS_5 = "5";
    /** 论文状态 开题报告已提交，等待提交中期检查 */
    public static final String TOPIC_STATUS_6 = "6";
    /** 论文状态 中期检查已提交，等待提交论文 */
    public static final String TOPIC_STATUS_7 = "7";
    /** 论文状态 论文已提交 */
    public static final String TOPIC_STATUS_8 = "8";
    /** 论文状态 已结束 */
    public static final String TOPIC_STATUS_9 = "9";

}
