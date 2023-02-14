package com.iKUN.analysis.domain;

/**
 * @Author iKUN
 * @Date 2023/1/22 15:26
 * @Description 实习人数相关统计分析Vo
 * @Version 1.0
 */
public class ImsPracticeStatisticsVo {

    /** 用户ID */
    private Long userId;

    /** 机构ID */
    private Long deptId;

    /** 任务ID */
    private Long taskId;

    /** 实习类型 */
    private String practiceType;

    /** 审核状态 */
    private String status;

    /** 实习状态 */
    private String practiceStatus;

    /** 年份 */
    private String academicYear;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getPracticeType() {
        return practiceType;
    }

    public void setPracticeType(String practiceType) {
        this.practiceType = practiceType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPracticeStatus() {
        return practiceStatus;
    }

    public void setPracticeStatus(String practiceStatus) {
        this.practiceStatus = practiceStatus;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    @Override
    public String toString() {
        return "ImsPracticeStatisticsVo{" +
                "userId=" + userId +
                ", deptId=" + deptId +
                ", taskId=" + taskId +
                ", practiceType='" + practiceType + '\'' +
                ", status='" + status + '\'' +
                ", practiceStatus='" + practiceStatus + '\'' +
                ", academicYear='" + academicYear + '\'' +
                '}';
    }
}
