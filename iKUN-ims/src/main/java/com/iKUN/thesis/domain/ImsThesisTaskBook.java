package com.iKUN.thesis.domain;

import com.iKUN.common.annotation.Excel;
import com.iKUN.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 任务书信息对象 ims_thesis_task_book
 * 
 * @author iKUN
 * @date 2022-12-18
 */
public class ImsThesisTaskBook extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 任务书ID */
    private Long taskBookId;

    /** 课题ID */
    @Excel(name = "课题ID")
    private String topicId;

    /** 研究内容 */
    @Excel(name = "研究内容")
    private String researchContent;

    /** 预期进展 */
    @Excel(name = "预期进展")
    private String process;

    /** 参考文献 */
    @Excel(name = "参考文献")
    private String reference;

    /** 学院意见 */
    @Excel(name = "学院意见")
    private String deptOpinion;

    /** 删除状态 */
    private String delFlag;

    /** 创建院系 */
    @Excel(name = "创建院系")
    private String createDept;

    public void setTaskBookId(Long taskBookId) 
    {
        this.taskBookId = taskBookId;
    }

    public Long getTaskBookId() 
    {
        return taskBookId;
    }
    public void setTopicId(String topicId) 
    {
        this.topicId = topicId;
    }

    public String getTopicId() 
    {
        return topicId;
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
            .append("taskBookId", getTaskBookId())
            .append("topicId", getTopicId())
            .append("researchContent", getResearchContent())
            .append("process", getProcess())
            .append("reference", getReference())
            .append("deptOpinion", getDeptOpinion())
            .append("delFlag", getDelFlag())
            .append("createDept", getCreateDept())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
