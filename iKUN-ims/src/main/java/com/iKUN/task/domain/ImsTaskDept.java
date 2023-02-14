package com.iKUN.task.domain;

import com.iKUN.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 任务与班级关联信息对象 ims_task_dept
 * 
 * @author iKUN
 * @date 2023-01-05
 */
public class ImsTaskDept extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 任务ID */
    private Long taskId;

    /** 班级ID */
    private Long deptId;

    /**老师ID */
    private Long teaId;

    /** 学生Id*/
    private Long userId;

    public ImsTaskDept() {

    }

    public ImsTaskDept(ImsTaskDept dept) {
        this.taskId = dept.taskId;
        this.deptId = dept.deptId;
        this.teaId = dept.teaId;
        this.userId = dept.userId;
    }

    public void setTaskId(Long taskId)
    {
        this.taskId = taskId;
    }

    public Long getTaskId() 
    {
        return taskId;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }

    public Long getTeaId() {
        return teaId;
    }

    public void setTeaId(Long teaId) {
        this.teaId = teaId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("taskId", getTaskId())
            .append("deptId", getDeptId())
            .append("teaId", getTeaId())
            .append("userId", getUserId())
            .toString();
    }
}
