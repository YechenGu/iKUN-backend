package com.iKUN.task.domain.vo.thesisVo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

/**
 * @Author iKUN
 * @Date 2023/1/15 14:52
 * @Description 论文题目Vo
 * @Version 1.0
 */
public class ImsThesisTopicChildVo {

    /** 学生ID */
    private Long userId;

    /** 学生姓名 */
    private String stuNickName;

    /** 子任务ID */
    private Long childId;

    /** 业务ID */
    private String businessId;

    /** 下一操作人 */
    private Long nextUser;

    /** 导师姓名 */
    private String nickName;

    /** 子任务类型 */
    private String childProcessType;

    /** 子任务状态 */
    private String childTaskStatus;

    /** 子任务进度 */
    private String childTaskProcess;

    /** 学年 */
    private String academicYear;

    private String topicStatus;

    /** 课题 */
    private String topicTitle;

    /** 题目来源 0-导师拟定 1-科研项目 2-学生自行拟定 */
    private String topicSource;

    /** 课题类型 */
    private String subjectType;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    /** 业务名 */
    private String businessName = "论文题目审核";

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getStuNickName() {
        return stuNickName;
    }

    public void setStuNickName(String stuNickName) {
        this.stuNickName = stuNickName;
    }

    public Long getChildId() {
        return childId;
    }

    public void setChildId(Long childId) {
        this.childId = childId;
    }

    public Long getNextUser() {
        return nextUser;
    }

    public void setNextUser(Long nextUser) {
        this.nextUser = nextUser;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getChildProcessType() {
        return childProcessType;
    }

    public void setChildProcessType(String childProcessType) {
        this.childProcessType = childProcessType;
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

    public String getTopicStatus() {
        return topicStatus;
    }

    public void setTopicStatus(String topicStatus) {
        this.topicStatus = topicStatus;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public String getTopicSource() {
        return topicSource;
    }

    public void setTopicSource(String topicSource) {
        this.topicSource = topicSource;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("userId", userId)
                .append("stuNickName", stuNickName)
                .append("childId", childId)
                .append("businessId", businessId)
                .append("nextUser", nextUser)
                .append("nickName", nickName)
                .append("childProcessType", childProcessType)
                .append("childTaskStatus", childTaskStatus)
                .append("childTaskProcess", childTaskProcess)
                .append("academicYear", academicYear)
                .append("topicStatus", topicStatus)
                .append("topicTitle", topicTitle)
                .append("topicSource", topicSource)
                .append("subjectType", subjectType)
                .append("createTime", createTime)
                .append("businessName", businessName)
                .toString();
    }
}
