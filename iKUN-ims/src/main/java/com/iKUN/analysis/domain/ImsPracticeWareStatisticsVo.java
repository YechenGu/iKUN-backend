package com.iKUN.analysis.domain;

/**
 * @Author iKUN
 * @Date 2023/1/2 15:12
 * @Description 实习工资统计分析
 * @Version 1.0
 */
public class ImsPracticeWareStatisticsVo {
    /** 用户ID */
    private Long userId;

    /** 机构ID */
    private Long deptId;

    /** 任务ID */
    private Long taskId;

    /** 年份 */
    private String academicYear;

    /** 工资 */
    private Integer postWage;

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

    public Integer getPostWage() {
        return postWage;
    }

    public void setPostWage(Integer postWage) {
        this.postWage = postWage;
    }

    @Override
    public String toString() {
        return "ImsPracticeWareStatisticsVo{" +
                "userId=" + userId +
                ", deptId=" + deptId +
                ", taskId=" + taskId +
                ", academicYear='" + academicYear + '\'' +
                ", postWage='" + postWage + '\'' +
                '}';
    }
}
