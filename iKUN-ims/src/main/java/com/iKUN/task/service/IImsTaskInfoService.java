package com.iKUN.task.service;

import com.iKUN.task.domain.ImsTaskInfo;

import java.util.List;

/**
 * 任务信息Service接口
 * 
 * @author iKUN
 * @date 2022-12-25
 */
public interface IImsTaskInfoService 
{
    /**
     * 查询任务信息
     * 
     * @param taskId 任务信息ID
     * @return 任务信息
     */
    public ImsTaskInfo selectImsTaskInfoById(Long taskId);

    /**
     * 查询任务信息列表
     * 
     * @param imsTaskInfo 任务信息
     * @return 任务信息集合
     */
    public List<ImsTaskInfo> selectImsTaskInfoList(ImsTaskInfo imsTaskInfo);

    /**
     * 新增任务信息
     * 
     * @param imsTaskInfo 任务信息
     * @return 结果
     */
    public void insertImsTaskInfo(ImsTaskInfo imsTaskInfo);

    /**
     * 修改任务信息
     * 
     * @param imsTaskInfo 任务信息
     * @return 结果
     */
    public int updateImsTaskInfo(ImsTaskInfo imsTaskInfo);

    /**
     * 批量删除任务信息
     * 
     * @param taskIds 需要删除的任务信息ID
     * @return 结果
     */
    public int deleteImsTaskInfoByIds(Long[] taskIds);

    /**
     * 删除任务信息信息
     * 
     * @param taskId 任务信息ID
     * @return 结果
     */
    public int deleteImsTaskInfoById(Long taskId);
}
