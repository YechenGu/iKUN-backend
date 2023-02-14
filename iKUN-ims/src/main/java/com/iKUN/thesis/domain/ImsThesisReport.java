package com.iKUN.thesis.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.iKUN.common.annotation.Excel;
import com.iKUN.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 开题报告信息对象 ims_thesis_report
 * 
 * @author iKUN
 * @date 2022-12-18
 */
public class ImsThesisReport extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 开题报告ID */
    private Long reportId;

    /** 课题编号 */
    @Excel(name = "课题编号")
    private String topicId;

    /** 课题简介 */
    @Excel(name = "课题简介")
    private String topicTitle;

    /** 课题描述 */
    @Excel(name = "课题描述")
    private String overview;

    /** 课题目标、意义 */
    @Excel(name = "课题目标、意义")
    private String goal;

    /** 研究方法 */
    @Excel(name = "研究方法")
    private String method;

    /** 创新之处 */
    @Excel(name = "创新之处")
    private String innovation;

    /** 研究内容 */
    @Excel(name = "研究内容")
    private String researchContent;

    /** 预期进展 */
    @Excel(name = "预期进展")
    private String process;

    /** 参考文献 */
    @Excel(name = "参考文献")
    private String reference;

    /** 所需条件 */
    @Excel(name = "所需条件")
    private String requirement;

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

    public void setReportId(Long reportId) 
    {
        this.reportId = reportId;
    }

    public Long getReportId() 
    {
        return reportId;
    }
    public void setTopicId(String topicId) 
    {
        this.topicId = topicId;
    }

    public String getTopicId() 
    {
        return topicId;
    }
    public void setTopicTitle(String topicTitle) 
    {
        this.topicTitle = topicTitle;
    }

    public String getTopicTitle() 
    {
        return topicTitle;
    }
    public void setOverview(String overview) 
    {
        this.overview = overview;
    }

    public String getOverview() 
    {
        return overview;
    }
    public void setGoal(String goal) 
    {
        this.goal = goal;
    }

    public String getGoal() 
    {
        return goal;
    }
    public void setMethod(String method) 
    {
        this.method = method;
    }

    public String getMethod() 
    {
        return method;
    }
    public void setInnovation(String innovation) 
    {
        this.innovation = innovation;
    }

    public String getInnovation() 
    {
        return innovation;
    }
    public void setResearchContent(String researchContent) 
    {
        this.researchContent = researchContent;
    }

    public String getResearchContent() 
    {
        return researchContent;
    }
    public void setProcess(String process) 
    {
        this.process = process;
    }

    public String getProcess() 
    {
        return process;
    }
    public void setReference(String reference)
    {
        this.reference = reference;
    }

    public String getReference()
    {
        return reference;
    }
    public void setRequirement(String requirement) 
    {
        this.requirement = requirement;
    }

    public String getRequirement() 
    {
        return requirement;
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
            .append("reportId", getReportId())
            .append("topicId", getTopicId())
            .append("topicTitle", getTopicTitle())
            .append("overview", getOverview())
            .append("goal", getGoal())
            .append("method", getMethod())
            .append("innovation", getInnovation())
            .append("researchContent", getResearchContent())
            .append("process", getProcess())
            .append("reference", getReference())
            .append("requirement", getRequirement())
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
