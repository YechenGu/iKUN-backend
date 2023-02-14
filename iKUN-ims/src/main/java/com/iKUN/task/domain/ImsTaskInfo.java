package com.iKUN.task.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.iKUN.common.annotation.Excel;
import com.iKUN.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 任务信息对象 ims_task_info
 * 
 * @author iKUN
 * @date 2022-12-25
 */
public class ImsTaskInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 任务ID */
    private Long taskId;

    /** 任务名称 */
    @Excel(name = "任务名称")
    private String taskName;

    /** 流程类型 0-实习任务 1-论文任务 */
    @Excel(name = "流程类型 ")
    private String processType;

    /** 院系ID */
    @Excel(name = "院系ID ")
    private Long deptId;

    /** 院系名称 */
    @Excel(name = "院系名称 ")
    private String deptName;

    /** 学年 */
    @Excel(name = "学年")
    private String academicYear;

    /** 学期 */
    @Excel(name = "学期")
    private String semester;

    /** 截止日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "截止日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 任务进度 01-进行中 02-已完成 */
    @Excel(name = "任务进度")
    private String taskProgress;

    /** 删除状态 */
    private String delFlag;

    /** 审核状态 */
    @Excel(name = "审核状态")
    private String status;

    /** 创建院系 */
    @Excel(name = "创建院系")
    private String createDept;

    public ImsTaskInfo(){

    }

    public ImsTaskInfo(ImsTaskInfo taskInfo) {
        this.taskName = taskInfo.taskName;
        this.processType = taskInfo.processType;
        this.deptId = taskInfo.deptId;
        this.deptName = taskInfo.deptName;
        this.academicYear = taskInfo.academicYear;
        this.semester = taskInfo.semester;
        this.endTime = taskInfo.endTime;
        this.taskProgress = taskInfo.taskProgress;
        this.delFlag = taskInfo.delFlag;
        this.status = taskInfo.status;
        this.createDept = taskInfo.createDept;
    }

    public void setTaskId(Long taskId)
    {
        this.taskId = taskId;
    }

    public Long getTaskId() 
    {
        return taskId;
    }
    public void setTaskName(String taskName) 
    {
        this.taskName = taskName;
    }

    public String getTaskName() 
    {
        return taskName;
    }
    public void setProcessType(String processType) 
    {
        this.processType = processType;
    }

    public String getProcessType() 
    {
        return processType;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setAcademicYear(String academicYear)
    {
        this.academicYear = academicYear;
    }

    public String getAcademicYear() 
    {
        return academicYear;
    }
    public void setSemester(String semester) 
    {
        this.semester = semester;
    }

    public String getSemester() 
    {
        return semester;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }
    public void setTaskProgress(String taskProgress) 
    {
        this.taskProgress = taskProgress;
    }

    public String getTaskProgress() 
    {
        return taskProgress;
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
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("taskId", getTaskId())
            .append("taskName", getTaskName())
            .append("processType", getProcessType())
            .append("deptId", getDeptId())
            .append("deptName", getDeptName())
            .append("academicYear", getAcademicYear())
            .append("semester", getSemester())
            .append("endTime", getEndTime())
            .append("taskProgress", getTaskProgress())
            .append("delFlag", getDelFlag())
            .append("status", getStatus())
            .append("createDept", getCreateDept())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
