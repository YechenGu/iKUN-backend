package com.iKUN.analysis.domain;

/**
 * @Author iKUN
 * @Date 2023/1/1 20:22
 * @Description 实习周记相关统计分析
 * @Version 1.0
 */
public class ImsPracticeWeeklyStatisticsVo {

    /** 用户ID */
    private Long userId;

    /** 机构ID */
    private Long deptId;

    /** 任务ID */
    private Long taskId;

    /** 年份 */
    private String academicYear;

    /** 审核状态 */
    private String status;

    /** 考核类型 */
    private String assessmenType;

    /** 周次 */
    private String week;

    /** 发布 */
    private String published;

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

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssessmenType() {
        return assessmenType;
    }

    public void setAssessmenType(String assessmenType) {
        this.assessmenType = assessmenType;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    @Override
    public String toString() {
        return "ImsPracticeWeeklyStatisticsVo{" +
                "userId=" + userId +
                ", deptId=" + deptId +
                ", taskId=" + taskId +
                ", academicYear='" + academicYear + '\'' +
                ", status='" + status + '\'' +
                ", assessmenType='" + assessmenType + '\'' +
                ", week='" + week + '\'' +
                ", published='" + published + '\'' +
                '}';
    }
}
