package com.iKUN.task.domain.vo;

import java.util.List;

/**
 * @Author iKUN
 * @Date 2023/1/10 17:10
 * @Description 分配指导老师Vo
 * @Version 1.0
 */
public class ImsTaskLinkVo {

    private Long userId;

    private Long taskId;

    private List<Long> classIds;

    private List<Long> studentIds;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public List<Long> getClassIds() {
        return classIds;
    }

    public void setClassIds(List<Long> classIds) {
        this.classIds = classIds;
    }

    public List<Long> getStudentIds() {
        return studentIds;
    }

    public void setStudentIds(List<Long> studentIds) {
        this.studentIds = studentIds;
    }

    @Override
    public String toString() {
        return "ImsTaskLinkVo{" +
                "userId=" + userId +
                ", taskId=" + taskId +
                ", classIds=" + classIds +
                ", studentIds=" + studentIds +
                '}';
    }
}
