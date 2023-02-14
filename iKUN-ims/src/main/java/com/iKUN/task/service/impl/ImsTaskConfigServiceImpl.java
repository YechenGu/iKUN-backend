package com.iKUN.task.service.impl;

import com.iKUN.task.domain.ImsTaskConfig;
import com.iKUN.task.mapper.ImsTaskConfigMapper;
import com.iKUN.task.service.IImsTaskConfigService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 流程配置信息Service业务层处理
 * 
 * @author iKUN
 * @date 2022-12-25
 */
@Service
public class ImsTaskConfigServiceImpl implements IImsTaskConfigService 
{
    @Resource
    private ImsTaskConfigMapper imsTaskConfigMapper;

    /**
     * 查询流程配置信息
     * 
     * @param processId 流程配置信息ID
     * @return 流程配置信息
     */
    @Override
    public ImsTaskConfig selectImsTaskConfigById(String processId)
    {
        return imsTaskConfigMapper.selectImsTaskConfigById(processId);
    }

    /**
     * 查询流程配置信息列表
     * 
     * @param imsTaskConfig 流程配置信息
     * @return 流程配置信息
     */
    @Override
    public List<ImsTaskConfig> selectImsTaskConfigList(ImsTaskConfig imsTaskConfig)
    {
        return imsTaskConfigMapper.selectImsTaskConfigList(imsTaskConfig);
    }

    /**
     * 新增流程配置信息
     * 
     * @param imsTaskConfig 流程配置信息
     * @return 结果
     */
    @Override
    public int insertImsTaskConfig(ImsTaskConfig imsTaskConfig)
    {
        return imsTaskConfigMapper.insertImsTaskConfig(imsTaskConfig);
    }

    /**
     * 修改流程配置信息
     * 
     * @param imsTaskConfig 流程配置信息
     * @return 结果
     */
    @Override
    public int updateImsTaskConfig(ImsTaskConfig imsTaskConfig)
    {
        return imsTaskConfigMapper.updateImsTaskConfig(imsTaskConfig);
    }

    /**
     * 批量删除流程配置信息
     * 
     * @param processIds 需要删除的流程配置信息ID
     * @return 结果
     */
    @Override
    public int deleteImsTaskConfigByIds(String[] processIds)
    {
        return imsTaskConfigMapper.deleteImsTaskConfigByIds(processIds);
    }

    /**
     * 删除流程配置信息信息
     * 
     * @param processId 流程配置信息ID
     * @return 结果
     */
    @Override
    public int deleteImsTaskConfigById(String processId)
    {
        return imsTaskConfigMapper.deleteImsTaskConfigById(processId);
    }
}
