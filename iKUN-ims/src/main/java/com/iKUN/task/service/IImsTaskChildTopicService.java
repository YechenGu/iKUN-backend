package com.iKUN.task.service;

import com.iKUN.task.domain.ImsTaskChildTopic;
import com.iKUN.task.domain.vo.thesisVo.ImsThesisTopicChildVo;

import java.util.List;

/**
 * 子任务信息Service接口
 * 
 * @author iKUN
 * @date 2022-12-25
 */
public interface IImsTaskChildTopicService
{
    /**
     * 查询子任务信息
     * 
     * @param childId 子任务信息ID
     * @return 子任务信息
     */
    public ImsTaskChildTopic selectImsTaskChildTopicById(Long childId);

    /**
     * 查询子任务信息

     * @return imsTaskChildTopic
     */
    public ImsTaskChildTopic selectImsTaskChildTopicByIds(ImsTaskChildTopic imsTaskChildTopic);

    /**
     * 论文题目待办
     * @param imsThesisTopicChildVo
     * @return
     */
    public List<ImsThesisTopicChildVo> selectThesisTopicList(ImsThesisTopicChildVo imsThesisTopicChildVo);

    /**
     * 查询子任务信息列表
     * 
     * @param imsTaskChildTopic 子任务信息
     * @return 子任务信息集合
     */
    public List<ImsTaskChildTopic> selectImsTaskChildTopicList(ImsTaskChildTopic imsTaskChildTopic);

    /**
     * 新增子任务信息
     * 
     * @param imsTaskChildTopic 子任务信息
     * @return 结果
     */
    public void insertImsTaskChildTopic(ImsTaskChildTopic imsTaskChildTopic);

    /**
     * 修改子任务信息
     * 
     * @param imsTaskChildTopic 子任务信息
     * @return 结果
     */
    public int updateImsTaskChildTopic(ImsTaskChildTopic imsTaskChildTopic);

    /**
     * 批量删除子任务信息
     * 
     * @param childIds 需要删除的子任务信息ID
     * @return 结果
     */
    public int deleteImsTaskChildTopicByIds(Long[] childIds);

    /**
     * 删除子任务信息信息
     * 
     * @param childId 子任务信息ID
     * @return 结果
     */
    public int deleteImsTaskChildTopicById(Long childId);
}
