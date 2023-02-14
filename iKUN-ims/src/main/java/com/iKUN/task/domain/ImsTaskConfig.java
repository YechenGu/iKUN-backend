package com.iKUN.task.domain;

import com.iKUN.common.annotation.Excel;
import com.iKUN.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 流程配置信息对象 ims_task_config
 * 
 * @author iKUN
 * @date 2022-12-25
 */
public class ImsTaskConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 任务配置ID */
    private String processId;

    /** 流程类型 0-实习任务 1-论文任务 */
    @Excel(name = "流程类型")
    private String processType;

    /** 流程序号 */
    @Excel(name = "流程序号")
    private Long processNum;

    /** 流程子流程 */
    @Excel(name = "流程子流程")
    private String processChildType;

    /** 阶段 y01-待指导老师审核 y02-待学院审核 */
    @Excel(name = "阶段")
    private String stage;

    /** 阶段名称 */
    @Excel(name = "阶段名称")
    private String stageMappering;

    /** 角色 */
    @Excel(name = "角色")
    private Long role;

    /** 节点类型 S-起始节点 E-结束节点 */
    @Excel(name = "节点类型")
    private String nodeType;

    /** 是否审核节点 Y-是  N-否 */
    @Excel(name = "是否审核节点")
    private String isCheckNode;

    /** 审核结论 T-同意 F-拒绝 */
    @Excel(name = "审核结论 ")
    private String checkConclusion;

    /** 流程是否结束 Y-是  N-否 */
    @Excel(name = "流程是否结束")
    private String processEnd;

    /** 下一流程ID */
    @Excel(name = "下一流程ID")
    private String nextProcessId;

    /** 下一院系类型 */
    @Excel(name = "下一院系类型")
    private String nextInstitutionType;

    public void setProcessId(String processId) 
    {
        this.processId = processId;
    }

    public String getProcessId() 
    {
        return processId;
    }
    public void setProcessType(String processType) 
    {
        this.processType = processType;
    }

    public String getProcessType() 
    {
        return processType;
    }
    public void setProcessNum(Long processNum) 
    {
        this.processNum = processNum;
    }

    public Long getProcessNum() 
    {
        return processNum;
    }
    public void setProcessChildType(String processChildType)
    {
        this.processChildType = processChildType;
    }

    public String getProcessChildType()
    {
        return processChildType;
    }
    public void setStage(String stage) 
    {
        this.stage = stage;
    }

    public String getStage() 
    {
        return stage;
    }
    public void setStageMappering(String stageMappering) 
    {
        this.stageMappering = stageMappering;
    }

    public String getStageMappering() 
    {
        return stageMappering;
    }
    public void setRole(Long role) 
    {
        this.role = role;
    }

    public Long getRole() 
    {
        return role;
    }
    public void setNodeType(String nodeType) 
    {
        this.nodeType = nodeType;
    }

    public String getNodeType() 
    {
        return nodeType;
    }
    public void setIsCheckNode(String isCheckNode) 
    {
        this.isCheckNode = isCheckNode;
    }

    public String getIsCheckNode() 
    {
        return isCheckNode;
    }
    public void setCheckConclusion(String checkConclusion) 
    {
        this.checkConclusion = checkConclusion;
    }

    public String getCheckConclusion() 
    {
        return checkConclusion;
    }
    public void setProcessEnd(String processEnd) 
    {
        this.processEnd = processEnd;
    }

    public String getProcessEnd() 
    {
        return processEnd;
    }
    public void setNextProcessId(String nextProcessId) 
    {
        this.nextProcessId = nextProcessId;
    }

    public String getNextProcessId() 
    {
        return nextProcessId;
    }
    public void setNextInstitutionType(String nextInstitutionType) 
    {
        this.nextInstitutionType = nextInstitutionType;
    }

    public String getNextInstitutionType() 
    {
        return nextInstitutionType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("processId", getProcessId())
            .append("processType", getProcessType())
            .append("processNum", getProcessNum())
            .append("processChildType", getProcessChildType())
            .append("stage", getStage())
            .append("stageMappering", getStageMappering())
            .append("role", getRole())
            .append("nodeType", getNodeType())
            .append("isCheckNode", getIsCheckNode())
            .append("checkConclusion", getCheckConclusion())
            .append("processEnd", getProcessEnd())
            .append("nextProcessId", getNextProcessId())
            .append("nextInstitutionType", getNextInstitutionType())
            .toString();
    }
}
