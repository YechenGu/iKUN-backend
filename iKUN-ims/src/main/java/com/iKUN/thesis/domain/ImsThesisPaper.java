package com.iKUN.thesis.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.iKUN.common.annotation.Excel;
import com.iKUN.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 论文信息对象 ims_thesis_paper
 * 
 * @author iKUN
 * @date 2022-12-18
 */
public class ImsThesisPaper extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 论文编号 */
    private String paperId;

    /** 课题ID */
    @Excel(name = "课题ID")
    private String topicId;

    /** 论文成绩 */
    @Excel(name = "论文成绩")
    private String paperGrade;

    /** 评审意见 */
    @Excel(name = "评审意见")
    private String reviewOpinion;

    /** 教师意见 */
    @Excel(name = "教师意见")
    private String teaOpinion;

    /** 学院意见 */
    @Excel(name = "学院意见")
    private String deptOpinion;

    /** 删除状态 */
    private String delFlag;

    /** 提交时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "提交时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date subTime;

    /** 创建院系 */
    @Excel(name = "创建院系")
    private String createDept;

    public void setPaperId(String paperId) 
    {
        this.paperId = paperId;
    }

    public String getPaperId() 
    {
        return paperId;
    }
    public void setTopicId(String topicId) 
    {
        this.topicId = topicId;
    }

    public String getTopicId() 
    {
        return topicId;
    }
    public void setPaperGrade(String paperGrade) 
    {
        this.paperGrade = paperGrade;
    }

    public String getPaperGrade() 
    {
        return paperGrade;
    }
    public void setReviewOpinion(String reviewOpinion) 
    {
        this.reviewOpinion = reviewOpinion;
    }

    public String getReviewOpinion() 
    {
        return reviewOpinion;
    }
    public void setTeaOpinion(String teaOpinion) 
    {
        this.teaOpinion = teaOpinion;
    }

    public String getTeaOpinion() 
    {
        return teaOpinion;
    }
    public void setDeptOpinion(String deptOpinion) 
    {
        this.deptOpinion = deptOpinion;
    }

    public String getDeptOpinion() 
    {
        return deptOpinion;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setSubTime(Date subTime) 
    {
        this.subTime = subTime;
    }

    public Date getSubTime() 
    {
        return subTime;
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
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("paperId", getPaperId())
            .append("topicId", getTopicId())
            .append("paperGrade", getPaperGrade())
            .append("reviewOpinion", getReviewOpinion())
            .append("teaOpinion", getTeaOpinion())
            .append("deptOpinion", getDeptOpinion())
            .append("delFlag", getDelFlag())
            .append("subTime", getSubTime())
            .append("createDept", getCreateDept())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
