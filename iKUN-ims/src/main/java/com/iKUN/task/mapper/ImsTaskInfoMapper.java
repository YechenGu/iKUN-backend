package com.iKUN.task.mapper;

import com.iKUN.task.domain.ImsTaskInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 任务信息Mapper接口
 * 
 * @author iKUN
 * @date 2022-12-25
 */
public interface ImsTaskInfoMapper 
{
    /**
     * 查询任务信息
     * 
     * @param taskId 任务信息ID
     * @return 任务信息
     */
    public ImsTaskInfo selectImsTaskInfoById(Long taskId);

    /**
     * 查询论文任务信息
     * @param deptId 机构ID
     * @param academicYear 年份
     * @return
     */
    public ImsTaskInfo selectImsTaskInfoByTopicTask(@Param("deptId") Long deptId, @Param("academicYear") String academicYear,@Param("processType") String processType);

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
    public int insertImsTaskInfo(ImsTaskInfo imsTaskInfo);

    /**
     * 修改任务信息
     * 
     * @param imsTaskInfo 任务信息
     * @return 结果
     */
    public int updateImsTaskInfo(ImsTaskInfo imsTaskInfo);

    /**
     * 删除任务信息
     * 
     * @param taskId 任务信息ID
     * @return 结果
     */
    public int deleteImsTaskInfoById(Long taskId);

    /**
     * 批量删除任务信息
     * 
     * @param taskIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteImsTaskInfoByIds(Long[] taskIds);
}
