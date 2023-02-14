package com.iKUN.thesis.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.iKUN.common.annotation.Excel;
import com.iKUN.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 论文中期检查信息对象 ims_thesis_inspection
 * 
 * @author iKUN
 * @date 2022-12-18
 */
public class ImsThesisInspection extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 中期检查ID */
    private Long inspectId;

    /** 课题编号 */
    @Excel(name = "课题编号")
    private String topicId;

    /** 课题进展 */
    @Excel(name = "课题进展")
    private String process;

    /** 遇到的问题 */
    @Excel(name = "遇到的问题")
    private String problem;

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

    public void setInspectId(Long inspectId) 
    {
        this.inspectId = inspectId;
    }

    public Long getInspectId() 
    {
        return inspectId;
    }
    public void setTopicId(String topicId) 
    {
        this.topicId = topicId;
    }

    public String getTopicId() 
    {
        return topicId;
    }
    public void setProcess(String process) 
    {
        this.process = process;
    }

    public String getProcess() 
    {
        return process;
    }
    public void setProblem(String problem) 
    {
        this.problem = problem;
    }

    public String getProblem() 
    {
        return problem;
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
            .append("inspectId", getInspectId())
            .append("topicId", getTopicId())
            .append("process", getProcess())
            .append("problem", getProblem())
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
