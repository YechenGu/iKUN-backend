package com.iKUN.thesis.service;

import java.util.List;
import com.iKUN.thesis.domain.ImsThesisTaskBook;

/**
 * 任务书信息Service接口
 * 
 * @author iKUN
 * @date 2022-12-18
 */
public interface IImsThesisTaskBookService 
{
    /**
     * 查询任务书信息
     * 
     * @param taskBookId 任务书信息ID
     * @return 任务书信息
     */
    public ImsThesisTaskBook selectImsThesisTaskBookById(Long taskBookId);

    /**
     * 查询任务书信息列表
     * 
     * @param imsThesisTaskBook 任务书信息
     * @return 任务书信息集合
     */
    public List<ImsThesisTaskBook> selectImsThesisTaskBookList(ImsThesisTaskBook imsThesisTaskBook);

    /**
     * 新增任务书信息
     * 
     * @param imsThesisTaskBook 任务书信息
     * @return 结果
     */
    public int insertImsThesisTaskBook(ImsThesisTaskBook imsThesisTaskBook);

    /**
     * 修改任务书信息
     * 
     * @param imsThesisTaskBook 任务书信息
     * @return 结果
     */
    public int updateImsThesisTaskBook(ImsThesisTaskBook imsThesisTaskBook);

    /**
     * 批量删除任务书信息
     * 
     * @param taskBookIds 需要删除的任务书信息ID
     * @return 结果
     */
    public int deleteImsThesisTaskBookByIds(Long[] taskBookIds);

    /**
     * 删除任务书信息信息
     * 
     * @param taskBookId 任务书信息ID
     * @return 结果
     */
    public int deleteImsThesisTaskBookById(Long taskBookId);
}
