package com.iKUN.practice.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.iKUN.common.annotation.Excel;
import com.iKUN.common.core.domain.BaseEntity;

/**
 * 实习考核信息对象 ims_practice_weekly
 * 
 * @author iKUN
 * @date 2022-11-26
 */
public class ImsPracticeWeekly extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 实习周记ID */
    private Long weeklyId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 用户账号 */
    @Excel(name = "登录名称")
    private String userName;

    /** 用户昵称 */
    @Excel(name = "用户名称")
    private String nickName;

    /** 部门名称 */
    private String deptName;

    /** 实习ID */
    @Excel(name = "实习ID")
    private Long practiceId;

    /** 实习单位 */
    @Excel(name = "实习单位")
    private String companyName;

    /** 考核类型 0-实习周记 1-实习总结 */
    @Excel(name = "考核类型 0-实习周记 1-实习总结")
    private String assessmenType;

    /** 标题 */
    @Excel(name = "标题")
    private String weeklyTitle;

    /** 内容 */
    @Excel(name = "内容")
    private String weeklyContent;

    /** 评论 */
    @Excel(name = "评论")
    private String commentabled;

    /** 发布 */
    @Excel(name = "发布")
    private String published;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date beginTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 周次 */
    @Excel(name = "周次")
    private String week;

    /** 删除状态 */
    private String delFlag;

    /** 审核状态 */
    @Excel(name = "审核状态")
    private String status;

    /** 创建班级 */
    @Excel(name = "创建班级")
    private String createDept;

    public void setWeeklyId(Long weeklyId) 
    {
        this.weeklyId = weeklyId;
    }

    public Long getWeeklyId() 
    {
        return weeklyId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setPracticeId(Long practiceId)
    {
        this.practiceId = practiceId;
    }

    public Long getPracticeId() 
    {
        return practiceId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setAssessmenType(String assessmenType)
    {
        this.assessmenType = assessmenType;
    }

    public String getAssessmenType() 
    {
        return assessmenType;
    }
    public void setWeeklyTitle(String weeklyTitle) 
    {
        this.weeklyTitle = weeklyTitle;
    }

    public String getWeeklyTitle() 
    {
        return weeklyTitle;
    }
    public void setWeeklyContent(String weeklyContent) 
    {
        this.weeklyContent = weeklyContent;
    }

    public String getWeeklyContent() 
    {
        return weeklyContent;
    }
    public void setCommentabled(String commentabled) 
    {
        this.commentabled = commentabled;
    }

    public String getCommentabled() 
    {
        return commentabled;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public void setBeginTime(Date beginTime)
    {
        this.beginTime = beginTime;
    }

    public Date getBeginTime()
    {
        return beginTime;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime()
    {
        return endTime;
    }
    public void setWeek(String week) 
    {
        this.week = week;
    }

    public String getWeek() 
    {
        return week;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setCreateDept(String createDept) 
    {
        this.createDept = createDept;
    }

    public String getCreateDept() 
    {
        return createDept;
    }

    @Override
    public String toString() {
        return "ImsPracticeWeekly{" +
                "weeklyId=" + weeklyId +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", deptName='" + deptName + '\'' +
                ", practiceId=" + practiceId +
                ", companyName='" + companyName + '\'' +
                ", assessmenType='" + assessmenType + '\'' +
                ", weeklyTitle='" + weeklyTitle + '\'' +
                ", weeklyContent='" + weeklyContent + '\'' +
                ", commentabled='" + commentabled + '\'' +
                ", published='" + published + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", week='" + week + '\'' +
                ", delFlag='" + delFlag + '\'' +
                ", status='" + status + '\'' +
                ", createDept='" + createDept + '\'' +
                '}';
    }
}
