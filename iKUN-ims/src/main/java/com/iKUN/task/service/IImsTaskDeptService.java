package com.iKUN.task.service;

import com.iKUN.task.domain.ImsTaskDept;
import com.iKUN.task.domain.vo.ImsTaskLinkVo;

import java.util.List;

/**
 * 任务与班级关联信息Service接口
 * 
 * @author iKUN
 * @date 2023-01-05
 */
public interface IImsTaskDeptService 
{
    /**
     * 查询任务与班级关联信息
     * 
     * @param taskId 任务与班级关联信息ID
     * @return 任务与班级关联信息
     */
    public ImsTaskDept selectImsTaskDeptById(Long taskId,Long userId);

    /**
     * 查询任务与班级关联信息列表
     * 
     * @param imsTaskDept 任务与班级关联信息
     * @return 任务与班级关联信息集合
     */
    public List<ImsTaskDept> selectImsTaskDeptList(ImsTaskDept imsTaskDept);

    /**
     * 新增任务与班级关联信息
     * 
     * @param imsTaskDept 任务与班级关联信息
     * @return 结果
     */
    public int insertImsTaskDept(ImsTaskDept imsTaskDept);

    /**
     * 新增任务与班级关联信息Vo
     * @param imsTaskLinkVo
     * @return
     */
    public void insertImsTaskLinkVo(ImsTaskLinkVo imsTaskLinkVo);

    /**
     * 修改任务与班级关联信息
     * 
     * @param imsTaskDept 任务与班级关联信息
     * @return 结果
     */
    public int updateImsTaskDept(ImsTaskDept imsTaskDept);

    /**
     * 批量删除任务与班级关联信息
     * 
     * @param taskIds 需要删除的任务与班级关联信息ID
     * @return 结果
     */
    public int deleteImsTaskDeptByIds(Long[] taskIds);

    /**
     * 删除任务与班级关联信息信息
     * 
     * @param taskId 任务与班级关联信息ID
     * @return 结果
     */
    public int deleteImsTaskDeptById(Long taskId);
}
