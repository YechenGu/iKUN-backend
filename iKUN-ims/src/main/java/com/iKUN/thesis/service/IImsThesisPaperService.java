package com.iKUN.thesis.service;

import java.util.List;
import com.iKUN.thesis.domain.ImsThesisPaper;

/**
 * 论文信息Service接口
 * 
 * @author iKUN
 * @date 2022-12-18
 */
public interface IImsThesisPaperService 
{
    /**
     * 查询论文信息
     * 
     * @param paperId 论文信息ID
     * @return 论文信息
     */
    public ImsThesisPaper selectImsThesisPaperById(String paperId);

    /**
     * 查询论文信息列表
     * 
     * @param imsThesisPaper 论文信息
     * @return 论文信息集合
     */
    public List<ImsThesisPaper> selectImsThesisPaperList(ImsThesisPaper imsThesisPaper);

    /**
     * 新增论文信息
     * 
     * @param imsThesisPaper 论文信息
     * @return 结果
     */
    public int insertImsThesisPaper(ImsThesisPaper imsThesisPaper);

    /**
     * 修改论文信息
     * 
     * @param imsThesisPaper 论文信息
     * @return 结果
     */
    public int updateImsThesisPaper(ImsThesisPaper imsThesisPaper);

    /**
     * 批量删除论文信息
     * 
     * @param paperIds 需要删除的论文信息ID
     * @return 结果
     */
    public int deleteImsThesisPaperByIds(String[] paperIds);

    /**
     * 删除论文信息信息
     * 
     * @param paperId 论文信息ID
     * @return 结果
     */
    public int deleteImsThesisPaperById(String paperId);
}
