package com.iKUN.thesis.service.impl;

import com.iKUN.common.utils.DateUtils;
import com.iKUN.common.utils.StringUtils;
import com.iKUN.commons.ImsConstants;
import com.iKUN.thesis.domain.ImsThesisInspection;
import com.iKUN.thesis.domain.ImsThesisTopic;
import com.iKUN.thesis.mapper.ImsThesisInspectionMapper;
import com.iKUN.thesis.mapper.ImsThesisTopicMapper;
import com.iKUN.thesis.service.IImsThesisInspectionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 论文中期检查信息Service业务层处理
 * 
 * @author iKUN
 * @date 2022-12-18
 */
@Service
public class ImsThesisInspectionServiceImpl implements IImsThesisInspectionService 
{
    @Resource
    private ImsThesisInspectionMapper imsThesisInspectionMapper;
    @Resource
    private ImsThesisTopicMapper thesisTopicMapper;

    /**
     * 查询论文中期检查信息
     * 
     * @param inspectId 论文中期检查信息ID
     * @return 论文中期检查信息
     */
    @Override
    public ImsThesisInspection selectImsThesisInspectionById(Long inspectId)
    {
        return imsThesisInspectionMapper.selectImsThesisInspectionById(inspectId);
    }

    /**
     * 查询论文中期检查信息列表
     * 
     * @param imsThesisInspection 论文中期检查信息
     * @return 论文中期检查信息
     */
    @Override
    public List<ImsThesisInspection> selectImsThesisInspectionList(ImsThesisInspection imsThesisInspection)
    {
        return imsThesisInspectionMapper.selectImsThesisInspectionList(imsThesisInspection);
    }

    /**
     * 新增论文中期检查信息
     * 
     * @param imsThesisInspection 论文中期检查信息
     * @return 结果
     */
    @Override
    public int insertImsThesisInspection(ImsThesisInspection imsThesisInspection)
    {
        imsThesisInspection.setCreateTime(DateUtils.getNowDate());
        if (StringUtils.isNotEmpty(imsThesisInspection.getTopicId())){
            ImsThesisTopic thesisTopic = thesisTopicMapper.selectImsThesisTopicById(imsThesisInspection.getTopicId());
            thesisTopic.setTopicStatus(ImsConstants.TOPIC_STATUS_7);
        }
        return imsThesisInspectionMapper.insertImsThesisInspection(imsThesisInspection);
    }

    /**
     * 修改论文中期检查信息
     * 
     * @param imsThesisInspection 论文中期检查信息
     * @return 结果
     */
    @Override
    public int updateImsThesisInspection(ImsThesisInspection imsThesisInspection)
    {
        imsThesisInspection.setUpdateTime(DateUtils.getNowDate());
        return imsThesisInspectionMapper.updateImsThesisInspection(imsThesisInspection);
    }

    /**
     * 批量删除论文中期检查信息
     * 
     * @param inspectIds 需要删除的论文中期检查信息ID
     * @return 结果
     */
    @Override
    public int deleteImsThesisInspectionByIds(Long[] inspectIds)
    {
        return imsThesisInspectionMapper.deleteImsThesisInspectionByIds(inspectIds);
    }

    /**
     * 删除论文中期检查信息信息
     * 
     * @param inspectId 论文中期检查信息ID
     * @return 结果
     */
    @Override
    public int deleteImsThesisInspectionById(Long inspectId)
    {
        return imsThesisInspectionMapper.deleteImsThesisInspectionById(inspectId);
    }
}
