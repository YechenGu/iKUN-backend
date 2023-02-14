package com.iKUN.task.service;

import java.util.List;
import com.iKUN.task.domain.ImsTaskConfig;

/**
 * 流程配置信息Service接口
 * 
 * @author iKUN
 * @date 2022-12-25
 */
public interface IImsTaskConfigService 
{
    /**
     * 查询流程配置信息
     * 
     * @param processId 流程配置信息ID
     * @return 流程配置信息
     */
    public ImsTaskConfig selectImsTaskConfigById(String processId);

    /**
     * 查询流程配置信息列表
     * 
     * @param imsTaskConfig 流程配置信息
     * @return 流程配置信息集合
     */
    public List<ImsTaskConfig> selectImsTaskConfigList(ImsTaskConfig imsTaskConfig);

    /**
     * 新增流程配置信息
     * 
     * @param imsTaskConfig 流程配置信息
     * @return 结果
     */
    public int insertImsTaskConfig(ImsTaskConfig imsTaskConfig);

    /**
     * 修改流程配置信息
     * 
     * @param imsTaskConfig 流程配置信息
     * @return 结果
     */
    public int updateImsTaskConfig(ImsTaskConfig imsTaskConfig);

    /**
     * 批量删除流程配置信息
     * 
     * @param processIds 需要删除的流程配置信息ID
     * @return 结果
     */
    public int deleteImsTaskConfigByIds(String[] processIds);

    /**
     * 删除流程配置信息信息
     * 
     * @param processId 流程配置信息ID
     * @return 结果
     */
    public int deleteImsTaskConfigById(String processId);
}
