package com.iKUN.thesis.service.impl;

import com.iKUN.common.utils.DateUtils;
import com.iKUN.thesis.domain.ImsThesisTaskBook;
import com.iKUN.thesis.mapper.ImsThesisTaskBookMapper;
import com.iKUN.thesis.service.IImsThesisTaskBookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 任务书信息Service业务层处理
 * 
 * @author iKUN
 * @date 2022-12-18
 */
@Service
public class ImsThesisTaskBookServiceImpl implements IImsThesisTaskBookService 
{
    @Resource
    private ImsThesisTaskBookMapper imsThesisTaskBookMapper;

    /**
     * 查询任务书信息
     * 
     * @param taskBookId 任务书信息ID
     * @return 任务书信息
     */
    @Override
    public ImsThesisTaskBook selectImsThesisTaskBookById(Long taskBookId)
    {
        return imsThesisTaskBookMapper.selectImsThesisTaskBookById(taskBookId);
    }

    /**
     * 查询任务书信息列表
     * 
     * @param imsThesisTaskBook 任务书信息
     * @return 任务书信息
     */
    @Override
    public List<ImsThesisTaskBook> selectImsThesisTaskBookList(ImsThesisTaskBook imsThesisTaskBook)
    {
        return imsThesisTaskBookMapper.selectImsThesisTaskBookList(imsThesisTaskBook);
    }

    /**
     * 新增任务书信息
     * 
     * @param imsThesisTaskBook 任务书信息
     * @return 结果
     */
    @Override
    public int insertImsThesisTaskBook(ImsThesisTaskBook imsThesisTaskBook)
    {
        imsThesisTaskBook.setCreateTime(DateUtils.getNowDate());
        return imsThesisTaskBookMapper.insertImsThesisTaskBook(imsThesisTaskBook);
    }

    /**
     * 修改任务书信息
     * 
     * @param imsThesisTaskBook 任务书信息
     * @return 结果
     */
    @Override
    public int updateImsThesisTaskBook(ImsThesisTaskBook imsThesisTaskBook)
    {
        imsThesisTaskBook.setUpdateTime(DateUtils.getNowDate());
        return imsThesisTaskBookMapper.updateImsThesisTaskBook(imsThesisTaskBook);
    }

    /**
     * 批量删除任务书信息
     * 
     * @param taskBookIds 需要删除的任务书信息ID
     * @return 结果
     */
    @Override
    public int deleteImsThesisTaskBookByIds(Long[] taskBookIds)
    {
        return imsThesisTaskBookMapper.deleteImsThesisTaskBookByIds(taskBookIds);
    }

    /**
     * 删除任务书信息信息
     * 
     * @param taskBookId 任务书信息ID
     * @return 结果
     */
    @Override
    public int deleteImsThesisTaskBookById(Long taskBookId)
    {
        return imsThesisTaskBookMapper.deleteImsThesisTaskBookById(taskBookId);
    }
}
