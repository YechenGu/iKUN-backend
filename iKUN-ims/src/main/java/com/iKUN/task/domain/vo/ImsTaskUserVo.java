package com.iKUN.task.domain.vo;

/**
 * @Author iKUN
 * @Date 2023/1/14 13:21
 * @Description 用户与任务关联Vo
 * @Version 1.0
 */
public class ImsTaskUserVo {

    /** 任务ID */
    private Long taskId;

    /** 用户ID */
    private Long userId;

    /** 学年 */
    private String academicYear;

    /** 学期 */
    private String semester;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "ImsTaskUserVo{" +
                "taskId=" + taskId +
                ", userId=" + userId +
                ", academicYear='" + academicYear + '\'' +
                ", semester='" + semester + '\'' +
                '}';
    }
}
