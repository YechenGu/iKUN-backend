package com.iKUN.dashboard.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * @Author iKUN
 * @Date 2023/1/25 17:12
 * @Description TODO
 * @Version 1.0
 */
public class ImsDashBoardTaskVo {

    /** 用户ID */
    private Long userId;

    /** 任务ID */
    private Long taskId;

    /** 任务名称 */
    private String taskName;

    /** 流程类型 0-实习任务 1-论文任务 */
    private String processType;

    /** 学年 */
    private String academicYear;

    /** 学期 */
    private String semester;

    /** 截止日期 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /** 任务进度 01-进行中 02-已完成 */
    private String taskProgress;

    /** 删除状态 */
    private String delFlag;

    /** 创建院者 */
    private String createBy;

    private String schedule;

    private Date CreateTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getProcessType() {
        return processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getTaskProgress() {
        return taskProgress;
    }

    public void setTaskProgress(String taskProgress) {
        this.taskProgress = taskProgress;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public Date getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Date createTime) {
        CreateTime = createTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("userId", userId)
                .append("taskId", taskId)
                .append("taskName", taskName)
                .append("processType", processType)
                .append("academicYear", academicYear)
                .append("semester", semester)
                .append("endTime", endTime)
                .append("taskProgress", taskProgress)
                .append("delFlag", delFlag)
                .append("createBy", createBy)
                .append("schedule", schedule)
                .append("CreateTime", CreateTime)
                .toString();
    }
}
