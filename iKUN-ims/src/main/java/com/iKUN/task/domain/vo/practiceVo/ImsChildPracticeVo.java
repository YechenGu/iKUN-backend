package com.iKUN.task.domain.vo.practiceVo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * @Author iKUN
 * @Date 2023/1/12 11:31
 * @Description 实习周记、总结待办Vo
 * @Version 1.0
 */
public class ImsChildPracticeVo {

    /** 实习周记ID */
    private Long weeklyId;

    /** 子任务ID */
    private Long childId;

    /** 操作人 */
    private Long nextUser;

    /** 任务状态 */
    private String childTaskStatus;

    /** 子任务进度 */
    private String childTaskProcess;

    /** 用户ID */
    private Long userId;

    /** 用户账号 */
    private String nickName;

    /** 考核类型 0-实习周记 1-实习总结 */
    private String assessmenType;

    /** 标题 */
    private String weeklyTitle;

    /** 周次 */
    private String week;

    /** 学年 */
    private String academicYear;

    /** 子任务类型 */
    private String childProcessType;

    /** 学期 */
    private String semester;

    /** 业务名 */
    private String businessName;

    /** 任务名 */
    private String taskName;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    public Long getWeeklyId() {
        return weeklyId;
    }

    public void setWeeklyId(Long weeklyId) {
        this.weeklyId = weeklyId;
    }

    public Long getChildId() {
        return childId;
    }

    public void setChildId(Long childId) {
        this.childId = childId;
    }

    public String getChildTaskStatus() {
        return childTaskStatus;
    }

    public void setChildTaskStatus(String childTaskStatus) {
        this.childTaskStatus = childTaskStatus;
    }

    public String getChildTaskProcess() {
        return childTaskProcess;
    }

    public void setChildTaskProcess(String childTaskProcess) {
        this.childTaskProcess = childTaskProcess;
    }

    public String getAssessmenType() {
        return assessmenType;
    }

    public void setAssessmenType(String assessmenType) {
        this.assessmenType = assessmenType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Long getNextUser() {
        return nextUser;
    }

    public void setNextUser(Long nextUser) {
        this.nextUser = nextUser;
    }

    public String getAssessmentType() {
        return assessmenType;
    }

    public void setAssessmentType(String assessmentType) {
        this.assessmenType = assessmentType;
    }

    public String getWeeklyTitle() {
        return weeklyTitle;
    }

    public void setWeeklyTitle(String weeklyTitle) {
        this.weeklyTitle = weeklyTitle;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
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

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getChildProcessType() {
        return childProcessType;
    }

    public void setChildProcessType(String childProcessType) {
        this.childProcessType = childProcessType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("weeklyId", weeklyId)
                .append("childId", childId)
                .append("nextUser", nextUser)
                .append("childTaskStatus", childTaskStatus)
                .append("childTaskProcess", childTaskProcess)
                .append("userId", userId)
                .append("nickName", nickName)
                .append("assessmenType", assessmenType)
                .append("weeklyTitle", weeklyTitle)
                .append("week", week)
                .append("academicYear", academicYear)
                .append("childProcessType", childProcessType)
                .append("semester", semester)
                .append("businessName", businessName)
                .append("taskName", taskName)
                .append("createTime", createTime)
                .toString();
    }
}
