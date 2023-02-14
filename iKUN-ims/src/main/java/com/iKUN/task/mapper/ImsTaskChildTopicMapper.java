package com.iKUN.task.mapper;

import com.iKUN.task.domain.ImsTaskChildTopic;
import com.iKUN.task.domain.vo.thesisVo.ImsThesisTopicChildVo;

import java.util.List;

/**
 * 子任务信息Mapper接口
 * 
 * @author iKUN
 * @date 2022-12-25
 */
public interface ImsTaskChildTopicMapper
{
    /**
     * 查询子任务信息
     * 
     * @param childId 子任务信息ID
     * @return 子任务信息
     */
    public ImsTaskChildTopic selectImsTaskChildTopicById(Long childId);

    /**
     * 论文题目待办
     * @param imsThesisTopicChildVo
     * @return
     */
    public List<ImsThesisTopicChildVo> selectThesisTopicList(ImsThesisTopicChildVo imsThesisTopicChildVo);

    /**
     * 查询子任务信息
     * @return ImsTaskChildTopic
     */
    public ImsTaskChildTopic selectImsTaskChildTopicByIds(ImsTaskChildTopic ImsTaskChildTopic);

    /**
     * 查询子任务信息列表
     * 
     * @param ImsTaskChildTopic 子任务信息
     * @return 子任务信息集合
     */
    public List<ImsTaskChildTopic> selectImsTaskChildTopicList(ImsTaskChildTopic ImsTaskChildTopic);

    /**
     * 新增子任务信息
     * 
     * @param ImsTaskChildTopic 子任务信息
     * @return 结果
     */
    public int insertImsTaskChildTopic(ImsTaskChildTopic ImsTaskChildTopic);

    /**
     * 修改子任务信息
     * 
     * @param ImsTaskChildTopic 子任务信息
     * @return 结果
     */
    public int updateImsTaskChildTopic(ImsTaskChildTopic ImsTaskChildTopic);

    /**
     * 删除子任务信息
     * 
     * @param childId 子任务信息ID
     * @return 结果
     */
    public int deleteImsTaskChildTopicById(Long childId);

    /**
     * 批量删除子任务信息
     * 
     * @param childIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteImsTaskChildTopicByIds(Long[] childIds);
}
