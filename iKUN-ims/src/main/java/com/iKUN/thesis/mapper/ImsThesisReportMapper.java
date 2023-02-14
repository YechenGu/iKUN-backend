package com.iKUN.thesis.mapper;

import java.util.List;
import com.iKUN.thesis.domain.ImsThesisReport;

/**
 * 开题报告信息Mapper接口
 * 
 * @author iKUN
 * @date 2022-12-18
 */
public interface ImsThesisReportMapper 
{
    /**
     * 查询开题报告信息
     * 
     * @param reportId 开题报告信息ID
     * @return 开题报告信息
     */
    public ImsThesisReport selectImsThesisReportById(Long reportId);

    /**
     * 查询开题报告信息列表
     * 
     * @param imsThesisReport 开题报告信息
     * @return 开题报告信息集合
     */
    public List<ImsThesisReport> selectImsThesisReportList(ImsThesisReport imsThesisReport);

    /**
     * 新增开题报告信息
     * 
     * @param imsThesisReport 开题报告信息
     * @return 结果
     */
    public int insertImsThesisReport(ImsThesisReport imsThesisReport);

    /**
     * 修改开题报告信息
     * 
     * @param imsThesisReport 开题报告信息
     * @return 结果
     */
    public int updateImsThesisReport(ImsThesisReport imsThesisReport);

    /**
     * 删除开题报告信息
     * 
     * @param reportId 开题报告信息ID
     * @return 结果
     */
    public int deleteImsThesisReportById(Long reportId);

    /**
     * 批量删除开题报告信息
     * 
     * @param reportIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteImsThesisReportByIds(Long[] reportIds);
}
