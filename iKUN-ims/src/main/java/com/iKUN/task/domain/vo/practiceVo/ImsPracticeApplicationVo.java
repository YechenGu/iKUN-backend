package com.iKUN.task.domain.vo.practiceVo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * @Author iKUN
 * @Date 2023/1/14 14:01
 * @Description 实习申请待办Vo
 * @Version 1.0
 */
public class ImsPracticeApplicationVo {

    /** 子任务ID */
    private Long childId;

    /** 用户ID */
    private Long userId;

    /** 下一操作人 */
    private Long nextUser;

    /** 子任务类型 */
    private String childProcessType;

    /** 子任务状态 */
    private String childTaskStatus;

    /** 子任务进度 */
    private String childTaskProcess;

    /** 学年 */
    private String academicYear;

    /** 学期 */
    private String semester;

    /** 用户账号 */
    private String nickName;

    /** 实习ID */
    private Long practiceId;

    /** 实习类型 */
    private String practiceType;

    /** 实习岗位 */
    private String practicePost;

    /** 实习单位 */
    private String companyName;

    /** 任务名 */
    private String taskName;

    /** 业务名 */
    private String businessName = "实习申请";

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    public Long getChildId() {
        return childId;
    }

    public void setChildId(Long childId) {
        this.childId = childId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getNextUser() {
        return nextUser;
    }

    public void setNextUser(Long nextUser) {
        this.nextUser = nextUser;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Long getPracticeId() {
        return practiceId;
    }

    public void setPracticeId(Long practiceId) {
        this.practiceId = practiceId;
    }

    public String getPracticeType() {
        return practiceType;
    }

    public void setPracticeType(String practiceType) {
        this.practiceType = practiceType;
    }

    public String getPracticePost() {
        return practicePost;
    }

    public void setPracticePost(String practicePost) {
        this.practicePost = practicePost;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
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
                .append("childId", childId)
                .append("userId", userId)
                .append("nextUser", nextUser)
                .append("childProcessType", childProcessType)
                .append("childTaskStatus", childTaskStatus)
                .append("childTaskProcess", childTaskProcess)
                .append("academicYear", academicYear)
                .append("semester", semester)
                .append("nickName", nickName)
                .append("practiceId", practiceId)
                .append("practiceType", practiceType)
                .append("practicePost", practicePost)
                .append("companyName", companyName)
                .append("taskName", taskName)
                .append("businessName", businessName)
                .append("createTime", createTime)
                .toString();
    }
}
