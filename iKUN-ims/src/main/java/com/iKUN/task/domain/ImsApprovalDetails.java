package com.iKUN.task.domain;

import com.iKUN.common.annotation.Excel;
import com.iKUN.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 审批明细信息对象 ims_approval_details
 * 
 * @author iKUN
 * @date 2023-01-11
 */
public class ImsApprovalDetails extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 审批ID */
    private Long approvalId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 角色ID */
    @Excel(name = "角色ID")
    private Long roleId;

    /** 院系ID */
    @Excel(name = "院系ID")
    private Long deptId;

    /** 子任务ID */
    @Excel(name = "子任务ID")
    private Long childId;

    /** 流程配置ID */
    @Excel(name = "流程配置ID")
    private String taskProcessType;

    /** 任务状态 */
    @Excel(name = "任务状态")
    private String taskStatus;

    /** 审批状态 */
    @Excel(name = "审批状态")
    private String approvalStatus;

    /** 审批结论 */
    @Excel(name = "审批结论")
    private String approvalConclusion;

    /** 审批意见 */
    @Excel(name = "审批意见")
    private String approvalOpinions;

    /** 创建院系 */
    @Excel(name = "创建院系")
    private String createDept;

    /** 更新院系 */
    @Excel(name = "更新院系")
    private String updateDept;

    public void setApprovalId(Long approvalId)
    {
        this.approvalId = approvalId;
    }

    public Long getApprovalId()
    {
        return approvalId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setRoleId(Long roleId) 
    {
        this.roleId = roleId;
    }

    public Long getRoleId() 
    {
        return roleId;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setChildId(Long childId) 
    {
        this.childId = childId;
    }

    public Long getChildId() 
    {
        return childId;
    }

    public String getTaskProcessType() {
        return taskProcessType;
    }

    public void setTaskProcessType(String taskProcessType) {
        this.taskProcessType = taskProcessType;
    }

    public void setTaskStatus(String taskStatus)
    {
        this.taskStatus = taskStatus;
    }

    public String getTaskStatus() 
    {
        return taskStatus;
    }
    public void setApprovalStatus(String approvalStatus) 
    {
        this.approvalStatus = approvalStatus;
    }

    public String getApprovalStatus() 
    {
        return approvalStatus;
    }
    public void setApprovalConclusion(String approvalConclusion) 
    {
        this.approvalConclusion = approvalConclusion;
    }

    public String getApprovalConclusion() 
    {
        return approvalConclusion;
    }
    public void setApprovalOpinions(String approvalOpinions) 
    {
        this.approvalOpinions = approvalOpinions;
    }

    public String getApprovalOpinions() 
    {
        return approvalOpinions;
    }
    public void setCreateDept(String createDept) 
    {
        this.createDept = createDept;
    }

    public String getCreateDept() 
    {
        return createDept;
    }
    public void setUpdateDept(String updateDept) 
    {
        this.updateDept = updateDept;
    }

    public String getUpdateDept() 
    {
        return updateDept;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("approvalId", getApprovalId())
            .append("userId", getUserId())
            .append("roleId", getRoleId())
            .append("deptId", getDeptId())
            .append("childId", getChildId())
            .append("taskProcessType", getTaskProcessType())
            .append("taskStatus", getTaskStatus())
            .append("approvalStatus", getApprovalStatus())
            .append("approvalConclusion", getApprovalConclusion())
            .append("approvalOpinions", getApprovalOpinions())
            .append("createDept", getCreateDept())
            .append("createTime", getCreateTime())
            .append("updateDept", getUpdateDept())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
