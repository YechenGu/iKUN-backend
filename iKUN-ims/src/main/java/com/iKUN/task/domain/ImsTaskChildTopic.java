package com.iKUN.task.domain;

import com.iKUN.common.annotation.Excel;
import com.iKUN.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 子任务信息对象 ims_task_child
 * 
 * @author iKUN
 * @date 2022-12-25
 */
public class ImsTaskChildTopic extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 子任务ID */
    private Long childId;

    /** 任务ID */
    @Excel(name = "任务ID")
    private Long taskId;

    /** 用户ID */
    private Long userId;

    /** 业务ID */
    private String businessId;

    /** 流程类型 0-实习任务 1-论文任务 */
    @Excel(name = "流程类型")
    private String processType;

    /** 子流程类型 1-实习周记 2-实习总结 3-实习鉴定表 */
    @Excel(name = "子流程类型")
    private String childProcessType;

    /** 下一操作人 */
    @Excel(name = "下一操作人")
    private Long nextUser;

    /** 下一操作人角色 */
    @Excel(name = "下一操作人角色")
    private Long nextRoleUser;

    /** 下一操作院系 */
    @Excel(name = "下一操作院系")
    private String nextDept;

    /** 子任务状态 */
    @Excel(name = "子任务状态")
    private String childTaskStatus;

    /** 子任务进度 */
    @Excel(name = "子任务进度")
    private String childTaskProcess;

    /** 创建院系 */
    @Excel(name = "创建院系")
    private String createDept;

    /** 更新院系 */
    @Excel(name = "更新院系")
    private String updateDept;

    public void setChildId(Long childId) 
    {
        this.childId = childId;
    }

    public Long getChildId() 
    {
        return childId;
    }
    public void setTaskId(Long taskId) 
    {
        this.taskId = taskId;
    }

    public Long getTaskId() 
    {
        return taskId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public void setProcessType(String processType)
    {
        this.processType = processType;
    }

    public String getProcessType() 
    {
        return processType;
    }
    public void setChildProcessType(String childProcessType) 
    {
        this.childProcessType = childProcessType;
    }

    public String getChildProcessType() 
    {
        return childProcessType;
    }

    public Long getNextUser() {
        return nextUser;
    }

    public void setNextUser(Long nextUser) {
        this.nextUser = nextUser;
    }

    public void setNextRoleUser(Long nextRoleUser)
    {
        this.nextRoleUser = nextRoleUser;
    }

    public Long getNextRoleUser() 
    {
        return nextRoleUser;
    }
    public void setNextDept(String nextDept) 
    {
        this.nextDept = nextDept;
    }

    public String getNextDept() 
    {
        return nextDept;
    }
    public void setChildTaskStatus(String childTaskStatus) 
    {
        this.childTaskStatus = childTaskStatus;
    }

    public String getChildTaskStatus() 
    {
        return childTaskStatus;
    }
    public void setChildTaskProcess(String childTaskProcess) 
    {
        this.childTaskProcess = childTaskProcess;
    }

    public String getChildTaskProcess() 
    {
        return childTaskProcess;
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
            .append("childId", getChildId())
            .append("taskId", getTaskId())
            .append("userId", getUserId())
            .append("businessId", getBusinessId())
            .append("processType", getProcessType())
            .append("childProcessType", getChildProcessType())
            .append("nextUser", getNextUser())
            .append("nextRoleUser", getNextRoleUser())
            .append("nextDept", getNextDept())
            .append("childTaskStatus", getChildTaskStatus())
            .append("childTaskProcess", getChildTaskProcess())
            .append("createDept", getCreateDept())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateDept", getUpdateDept())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
