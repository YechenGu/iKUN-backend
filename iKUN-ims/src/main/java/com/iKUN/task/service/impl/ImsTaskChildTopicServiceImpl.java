package com.iKUN.task.service.impl;

import com.iKUN.common.exception.CustomException;
import com.iKUN.common.utils.DateUtils;
import com.iKUN.common.utils.StringUtils;
import com.iKUN.commons.ImsConstants;
import com.iKUN.task.domain.ImsTaskChildTopic;
import com.iKUN.task.domain.ImsTaskConfig;
import com.iKUN.task.domain.vo.thesisVo.ImsThesisTopicChildVo;
import com.iKUN.task.mapper.ImsTaskChildTopicMapper;
import com.iKUN.task.mapper.ImsTaskConfigMapper;
import com.iKUN.task.service.IImsTaskChildTopicService;
import com.iKUN.thesis.domain.ImsThesisTopic;
import com.iKUN.thesis.mapper.ImsThesisTopicMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 子任务信息Service业务层处理
 * 
 * @author iKUN
 * @date 2022-12-25
 */
@Service
public class ImsTaskChildTopicServiceImpl implements IImsTaskChildTopicService
{
    private Logger log = LoggerFactory.getLogger(getClass());
    @Resource
    private ImsTaskChildTopicMapper imsTaskChildTopicMapper;
    @Resource
    private ImsTaskConfigMapper taskConfigMapper;
    @Resource
    private ImsThesisTopicMapper thesisTopicMapper;


    /**
     * 查询子任务信息
     * 
     * @param childId 子任务信息ID
     * @return 子任务信息
     */
    @Override
    public ImsTaskChildTopic selectImsTaskChildTopicById(Long childId)
    {
        return imsTaskChildTopicMapper.selectImsTaskChildTopicById(childId);
    }

    /**
     * 查询子任务信息
     * @return
     */
    @Override
    public ImsTaskChildTopic selectImsTaskChildTopicByIds(ImsTaskChildTopic ImsTaskChildTopic) {
        return imsTaskChildTopicMapper.selectImsTaskChildTopicByIds(ImsTaskChildTopic);
    }

    /**
     * 论文题目待办
     * @param imsThesisTopicChildVo
     * @return
     */
    @Override
    public List<ImsThesisTopicChildVo> selectThesisTopicList(ImsThesisTopicChildVo imsThesisTopicChildVo) {
        List<ImsThesisTopicChildVo> list = imsTaskChildTopicMapper.selectThesisTopicList(imsThesisTopicChildVo);
        list.forEach(o ->{
            imsThesisTopicChildVo.setUserId(o.getUserId());
        });
        return imsTaskChildTopicMapper.selectThesisTopicList(imsThesisTopicChildVo);
    }

    /**
     * 查询子任务信息列表
     * 
     * @param ImsTaskChildTopic 子任务信息
     * @return 子任务信息
     */
    @Override
    public List<ImsTaskChildTopic> selectImsTaskChildTopicList(ImsTaskChildTopic ImsTaskChildTopic)
    {
        return imsTaskChildTopicMapper.selectImsTaskChildTopicList(ImsTaskChildTopic);
    }

    /**
     * 新增子任务信息
     * 
     * @param ImsTaskChildTopic 子任务信息
     * @return 结果
     */
    @Override
    public void insertImsTaskChildTopic(ImsTaskChildTopic ImsTaskChildTopic)
    {
        ImsTaskChildTopic.setCreateTime(DateUtils.getNowDate());
        ImsTaskChildTopic.setUpdateTime(DateUtils.getNowDate());
        //流程配置表
        ImsTaskConfig config = new ImsTaskConfig();
        config.setProcessType(ImsTaskChildTopic.getProcessType());
        config.setStage(ImsTaskChildTopic.getChildTaskStatus());
        config.setProcessChildType(ImsTaskChildTopic.getChildProcessType());
        config.setIsCheckNode(ImsConstants.IS_CHECK_NODE_YES);
        ImsTaskConfig taskConfig = taskConfigMapper.selectImsTaskConfig(config);
        if (StringUtils.isNull(taskConfig)){
            log.error("未找到该流程信息");
            throw new CustomException("未找到该流程信息");
        }
        //获取角色类型
        ImsTaskChildTopic.setNextRoleUser(taskConfig.getRole());
        //子任务进度
        ImsTaskChildTopic.setChildTaskProcess(ImsConstants.TASK_PROCESS_01);
        //查询该任务是否存在
        if (StringUtils.isNotNull(ImsTaskChildTopic.getUserId()) && StringUtils.isNotNull(ImsTaskChildTopic.getTaskId()) && StringUtils.isNotEmpty(ImsTaskChildTopic.getBusinessId())){
            ImsTaskChildTopic child = imsTaskChildTopicMapper.selectImsTaskChildTopicByIds(ImsTaskChildTopic);
            if (null != child && StringUtils.isNotNull(child.getChildId())){
                child.setNextRoleUser(ImsTaskChildTopic.getNextRoleUser());
                child.setNextUser(ImsTaskChildTopic.getNextUser());
                child.setChildTaskProcess(ImsTaskChildTopic.getChildTaskProcess());
                child.setProcessType(ImsTaskChildTopic.getProcessType());
                child.setChildTaskStatus(ImsTaskChildTopic.getChildTaskStatus());
                imsTaskChildTopicMapper.updateImsTaskChildTopic(child);
            }else {
                imsTaskChildTopicMapper.insertImsTaskChildTopic(ImsTaskChildTopic);
            }
        }
    }

    /**
     * 修改子任务信息
     * 
     * @param childTopic 子任务信息
     * @return 结果
     */
    @Override
    public int updateImsTaskChildTopic(ImsTaskChildTopic childTopic)
    {
        childTopic.setUpdateTime(DateUtils.getNowDate());
        if (StringUtils.isNull(childTopic.getBusinessId()) || StringUtils.isNull(childTopic.getProcessType()) || StringUtils.isNull(childTopic.getChildProcessType())) {
            log.info("未找到该{}",childTopic.getProcessType());
            throw new CustomException("任务类型不能为空！");
        }
        if (ImsConstants.TASK_PROCESS_TYPE_2.equals(childTopic.getProcessType())){
            ImsThesisTopic topic = thesisTopicMapper.selectImsThesisTopicById(childTopic.getBusinessId());
            //指导老师审核通过
            if (ImsConstants.TASK_STAGE_Y02.equals(childTopic.getChildTaskStatus()) && ImsConstants.TASK_PROCESS_01.equals(childTopic.getChildTaskProcess())){
                //修改状态
                topic.setTopicStatus(ImsConstants.TOPIC_STATUS_3);
            }
            //指导老师审核不通过
            else if (ImsConstants.TASK_STAGE_Y00.equals(childTopic.getChildTaskStatus()) && ImsConstants.TASK_PROCESS_01.equals(childTopic.getChildTaskProcess())){
                //修改状态
                topic.setTopicStatus(ImsConstants.TOPIC_STATUS_2);
            }
            //学院审核不通过
            else if (ImsConstants.TASK_STAGE_Y01.equals(childTopic.getChildTaskStatus()) && ImsConstants.TASK_PROCESS_01.equals(childTopic.getChildTaskProcess())){
                //修改状态
                topic.setTopicStatus(ImsConstants.TOPIC_STATUS_4);
            }
            //学院审核通过
            else if (ImsConstants.TASK_STAGE_Y04.equals(childTopic.getChildTaskStatus()) && ImsConstants.TASK_PROCESS_02.equals(childTopic.getChildTaskProcess())){
                topic.setTopicStatus(ImsConstants.TOPIC_STATUS_5);
            }
            thesisTopicMapper.updateImsThesisTopic(topic);
        }
        return imsTaskChildTopicMapper.updateImsTaskChildTopic(childTopic);
    }

    /**
     * 批量删除子任务信息
     * 
     * @param childIds 需要删除的子任务信息ID
     * @return 结果
     */
    @Override
    public int deleteImsTaskChildTopicByIds(Long[] childIds)
    {
        return imsTaskChildTopicMapper.deleteImsTaskChildTopicByIds(childIds);
    }

    /**
     * 删除子任务信息信息
     * 
     * @param childId 子任务信息ID
     * @return 结果
     */
    @Override
    public int deleteImsTaskChildTopicById(Long childId)
    {
        return imsTaskChildTopicMapper.deleteImsTaskChildTopicById(childId);
    }
}
