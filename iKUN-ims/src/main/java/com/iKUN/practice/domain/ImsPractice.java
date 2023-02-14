package com.iKUN.practice.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.iKUN.common.annotation.Excel;
import com.iKUN.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 实习信息对象 ims_practice
 * 
 * @author iKUN
 * @date 2022-11-20
 */
public class ImsPractice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 实习ID */
    private Long practiceId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 任务ID */
    private Long taskId;

    /** 用户名 */
    @Excel(name = "用户名")
    private String nickName;

    /** 企业ID */
    @Excel(name = "企业ID")
    private Long companyId;

    /** 企业名 */
    @Excel(name = "企业名")
    private String companyName;

    /** 家长姓名 */
    @Excel(name = "家长姓名")
    private String parentName;

    /** 家长联系方式 */
    @Excel(name = "家长联系方式")
    private String parentPhone;

    /** 实习类型 */
    @Excel(name = "实习类型")
    private String practiceType;

    /** 实习岗位 */
    @Excel(name = "实习岗位")
    private String practicePost;

    /** 学校指导老师 */
    @Excel(name = "学校指导老师")
    private String schoolInstructor;

    /** 实习指导老师 */
    @Excel(name = "实习指导老师")
    private String internInstructor;

    /** 实习指导老师电话 */
    @Excel(name = "实习指导老师电话")
    private String internPhone;

    /** 实习指导老师email */
    @Excel(name = "实习指导老师email")
    private String internEmail;

    /** 实习开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "实习开始时间")
    private Date beginTime;

    /** 实习结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "实习结束时间")
    private Date endTime;

    /** 实习描述 */
    @Excel(name = "实习描述")
    private String practiceDesc;

    /** 审核状态 */
    @Excel(name = "审核状态")
    private String status;

    /** 删除状态 */
    private String delFlag;

    /** 实习状态 */
    @Excel(name = "实习状态")
    private String practiceStatus;

    /** 创建院系 */
    @Excel(name = "创建院系")
    private String createDept;


    public void setPracticeId(Long practiceId) 
    {
        this.practiceId = practiceId;
    }

    public Long getPracticeId() 
    {
        return practiceId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCompanyId(Long companyId)
    {
        this.companyId = companyId;
    }

    public Long getCompanyId() 
    {
        return companyId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentPhone() {
        return parentPhone;
    }

    public void setParentPhone(String parentPhone) {
        this.parentPhone = parentPhone;
    }

    public String getPracticePost() {
        return practicePost;
    }

    public void setPracticePost(String practicePost) {
        this.practicePost = practicePost;
    }

    public void setSchoolInstructor(String schoolInstructor)
    {
        this.schoolInstructor = schoolInstructor;
    }

    public String getSchoolInstructor() 
    {
        return schoolInstructor;
    }
    public void setInternInstructor(String internInstructor) 
    {
        this.internInstructor = internInstructor;
    }

    public String getInternInstructor() 
    {
        return internInstructor;
    }
    public void setInternPhone(String internPhone) 
    {
        this.internPhone = internPhone;
    }

    public String getInternPhone() 
    {
        return internPhone;
    }
    public void setInternEmail(String internEmail) 
    {
        this.internEmail = internEmail;
    }

    public String getInternEmail() 
    {
        return internEmail;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setPracticeDesc(String practiceDesc)
    {
        this.practiceDesc = practiceDesc;
    }

    public String getPracticeDesc() 
    {
        return practiceDesc;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setPracticeStatus(String practiceStatus) 
    {
        this.practiceStatus = practiceStatus;
    }

    public String getPracticeStatus() 
    {
        return practiceStatus;
    }
    public void setCreateDept(String createDept) 
    {
        this.createDept = createDept;
    }

    public String getCreateDept() 
    {
        return createDept;
    }

    public String getPracticeType() {
        return practiceType;
    }

    public void setPracticeType(String practiceType) {
        this.practiceType = practiceType;
    }

    @Override
    public String toString() {
        return "ImsPractice{" +
                "practiceId=" + practiceId +
                ", userId=" + userId +
                ", taskId=" + taskId +
                ", nickName='" + nickName + '\'' +
                ", companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", parentName='" + parentName + '\'' +
                ", parentPhone='" + parentPhone + '\'' +
                ", practiceType='" + practiceType + '\'' +
                ", practicePost='" + practicePost + '\'' +
                ", schoolInstructor='" + schoolInstructor + '\'' +
                ", internInstructor='" + internInstructor + '\'' +
                ", internPhone='" + internPhone + '\'' +
                ", internEmail='" + internEmail + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", practiceDesc='" + practiceDesc + '\'' +
                ", status='" + status + '\'' +
                ", delFlag='" + delFlag + '\'' +
                ", practiceStatus='" + practiceStatus + '\'' +
                ", createDept='" + createDept + '\'' +
                '}';
    }
}
