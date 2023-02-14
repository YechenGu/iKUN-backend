package com.iKUN.thesis.service;

import com.iKUN.thesis.domain.ImsThesisTopic;

import java.util.List;

/**
 * 课题信息Service接口
 * 
 * @author iKUN
 * @date 2022-12-18
 */
public interface IImsThesisTopicService 
{
    /**
     * 查询课题信息
     * 
     * @param topicId 课题信息ID
     * @return 课题信息
     */
    public ImsThesisTopic selectImsThesisTopicById(String topicId);

    /**
     * 根据用户查询课题信息
     *
     * @param userId 用户ID
     * @return 课题信息
     */
    public ImsThesisTopic selectImsThesisTopicByUserId(Long userId);

    /**
     * 查询课题信息列表
     * 
     * @param imsThesisTopic 课题信息
     * @return 课题信息集合
     */
    public List<ImsThesisTopic> selectImsThesisTopicList(ImsThesisTopic imsThesisTopic);

    /**
     * 新增课题信息
     * 
     * @param imsThesisTopic 课题信息
     * @return 结果
     */
    public int insertImsThesisTopic(ImsThesisTopic imsThesisTopic);

    /**
     * 修改课题信息
     * 
     * @param imsThesisTopic 课题信息
     * @return 结果
     */
    public int updateImsThesisTopic(ImsThesisTopic imsThesisTopic);

    /**
     * 批量删除课题信息
     * 
     * @param topicIds 需要删除的课题信息ID
     * @return 结果
     */
    public int deleteImsThesisTopicByIds(String[] topicIds);

    /**
     * 删除课题信息信息
     * 
     * @param topicId 课题信息ID
     * @return 结果
     */
    public int deleteImsThesisTopicById(String topicId);
}
