package com.iKUN.thesis.service.impl;

import com.iKUN.common.utils.DateUtils;
import com.iKUN.common.utils.SecurityUtils;
import com.iKUN.common.utils.StringUtils;
import com.iKUN.commons.ImsConstants;
import com.iKUN.thesis.domain.ImsThesisReport;
import com.iKUN.thesis.domain.ImsThesisTopic;
import com.iKUN.thesis.mapper.ImsThesisReportMapper;
import com.iKUN.thesis.mapper.ImsThesisTopicMapper;
import com.iKUN.thesis.service.IImsThesisReportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 开题报告信息Service业务层处理
 * 
 * @author iKUN
 * @date 2022-12-18
 */
@Service
public class ImsThesisReportServiceImpl implements IImsThesisReportService 
{
    @Resource
    private ImsThesisReportMapper imsThesisReportMapper;
    @Resource
    private ImsThesisTopicMapper thesisTopicMapper;

    /**
     * 查询开题报告信息
     * 
     * @param reportId 开题报告信息ID
     * @return 开题报告信息
     */
    @Override
    public ImsThesisReport selectImsThesisReportById(Long reportId)
    {
        return imsThesisReportMapper.selectImsThesisReportById(reportId);
    }

    /**
     * 查询开题报告信息列表
     * 
     * @param imsThesisReport 开题报告信息
     * @return 开题报告信息
     */
    @Override
    public List<ImsThesisReport> selectImsThesisReportList(ImsThesisReport imsThesisReport)
    {
        return imsThesisReportMapper.selectImsThesisReportList(imsThesisReport);
    }

    /**
     * 新增开题报告信息
     * 
     * @param imsThesisReport 开题报告信息
     * @return 结果
     */
    @Override
    public int insertImsThesisReport(ImsThesisReport imsThesisReport)
    {
        imsThesisReport.setCreateTime(DateUtils.getNowDate());
        imsThesisReport.setSubTime(DateUtils.getNowDate());
        imsThesisReport.setCreateBy(SecurityUtils.getUsername());
        if (StringUtils.isNotEmpty(imsThesisReport.getTopicId())){
            ImsThesisTopic thesisTopic = thesisTopicMapper.selectImsThesisTopicById(imsThesisReport.getTopicId());
            thesisTopic.setTopicStatus(ImsConstants.TOPIC_STATUS_6);
        }
        return imsThesisReportMapper.insertImsThesisReport(imsThesisReport);
    }

    /**
     * 修改开题报告信息
     * 
     * @param imsThesisReport 开题报告信息
     * @return 结果
     */
    @Override
    public int updateImsThesisReport(ImsThesisReport imsThesisReport)
    {
        imsThesisReport.setUpdateTime(DateUtils.getNowDate());
        return imsThesisReportMapper.updateImsThesisReport(imsThesisReport);
    }

    /**
     * 批量删除开题报告信息
     * 
     * @param reportIds 需要删除的开题报告信息ID
     * @return 结果
     */
    @Override
    public int deleteImsThesisReportByIds(Long[] reportIds)
    {
        return imsThesisReportMapper.deleteImsThesisReportByIds(reportIds);
    }

    /**
     * 删除开题报告信息信息
     * 
     * @param reportId 开题报告信息ID
     * @return 结果
     */
    @Override
    public int deleteImsThesisReportById(Long reportId)
    {
        return imsThesisReportMapper.deleteImsThesisReportById(reportId);
    }
}
