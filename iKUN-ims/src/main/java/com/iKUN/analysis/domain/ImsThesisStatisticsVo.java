package com.iKUN.analysis.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @Author iKUN
 * @Date 2023/1/24 21:57
 * @Description 论文分析Vo
 * @Version 1.0
 */
public class ImsThesisStatisticsVo {
    /** 用户ID */
    private Long userId;

    /** 机构ID */
    private Long deptId;

    /** 任务ID */
    private Long taskId;

    /** 实习类型 */
    private String topicId;

    /** 论文状态 */
    private String topicStatus;

    /** 实习状态 */
    private String delFlag;

    /** 年份 */
    private String academicYear;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getTopicStatus() {
        return topicStatus;
    }

    public void setTopicStatus(String topicStatus) {
        this.topicStatus = topicStatus;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("userId", userId)
                .append("deptId", deptId)
                .append("taskId", taskId)
                .append("topicId", topicId)
                .append("topicStatus", topicStatus)
                .append("delFlag", delFlag)
                .append("academicYear", academicYear)
                .toString();
    }
}
