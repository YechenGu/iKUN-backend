package com.iKUN.thesis.service.impl;

import com.iKUN.common.core.domain.entity.SysUser;
import com.iKUN.common.exception.CustomException;
import com.iKUN.common.utils.DateUtils;
import com.iKUN.common.utils.SecurityUtils;
import com.iKUN.common.utils.StringUtils;
import com.iKUN.common.utils.uuid.IdUtils;
import com.iKUN.commons.ImsConstants;
import com.iKUN.system.mapper.SysUserMapper;
import com.iKUN.task.domain.ImsTaskChildTopic;
import com.iKUN.task.domain.ImsTaskInfo;
import com.iKUN.task.mapper.ImsTaskInfoMapper;
import com.iKUN.task.service.IImsTaskChildTopicService;
import com.iKUN.thesis.domain.ImsThesisTopic;
import com.iKUN.thesis.mapper.ImsThesisTopicMapper;
import com.iKUN.thesis.service.IImsThesisTopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 课题信息Service业务层处理
 * 
 * @author iKUN
 * @date 2022-12-18
 */
@Service
public class ImsThesisTopicServiceImpl implements IImsThesisTopicService 
{
    private Logger log = LoggerFactory.getLogger(getClass());
    @Resource
    private ImsThesisTopicMapper imsThesisTopicMapper;
    @Resource
    private SysUserMapper userMapper;
    @Resource
    private IImsTaskChildTopicService topicService;
    @Resource
    private ImsTaskInfoMapper taskInfoMapper;

    /**
     * 查询课题信息
     * 
     * @param topicId 课题信息ID
     * @return 课题信息
     */
    @Override
    public ImsThesisTopic selectImsThesisTopicById(String topicId)
    {
        ImsThesisTopic topic = imsThesisTopicMapper.selectImsThesisTopicById(topicId);
        Long userId = topic.getUserId();
        SysUser user = userMapper.selectUserById(userId);
        topic.setStuNickName(user.getNickName());
        return topic;
    }

    /**
     * 根据用户Id查询课题信息
     * @param userId 用户ID
     * @return
     */
    @Override
    public ImsThesisTopic selectImsThesisTopicByUserId(Long userId) {
        return imsThesisTopicMapper.selectImsThesisTopicByUserId(userId);
    }

    /**
     * 查询课题信息列表
     * 
     * @param imsThesisTopic 课题信息
     * @return 课题信息
     */
    @Override
    public List<ImsThesisTopic> selectImsThesisTopicList(ImsThesisTopic imsThesisTopic)
    {
        List<ImsThesisTopic> topics = imsThesisTopicMapper.selectImsThesisTopicList(imsThesisTopic);
        if (null != topics && 0 < topics.size()){
            topics.forEach(o ->{
                SysUser sysUser = userMapper.selectUserById(o.getUserId());
                o.setStuNickName(sysUser.getNickName());
            });
        }
        return topics;
    }

    /**
     * 新增课题信息
     * 
     * @param imsThesisTopic 课题信息
     * @return 结果
     */
    @Override
    public int insertImsThesisTopic(ImsThesisTopic imsThesisTopic)
    {
        int i;
        Long userId = SecurityUtils.getLoginUser().getUser().getUserId();
        imsThesisTopic.setCreateTime(DateUtils.getNowDate());
        imsThesisTopic.setUpdateTime(DateUtils.getNowDate());
        imsThesisTopic.setTopicId(IdUtils.fastSimpleUUID());
        imsThesisTopic.setDelFlag(ImsConstants.dEL_NO);
        imsThesisTopic.setUserId(SecurityUtils.getLoginUser().getUser().getUserId());
        imsThesisTopic.setTopicStatus(ImsConstants.TOPIC_STATUS_1);
        //日期格式化
        String academicYear = DateUtils.parseDateToStr(DateUtils.YYYY, DateUtils.getNowDate());
        Long deptId = imsThesisTopic.getDeptId();
        //查询是否存在论文任务
        ImsTaskInfo taskInfo = taskInfoMapper.selectImsTaskInfoByTopicTask(deptId, academicYear,ImsConstants.TASK_PROCESS_TYPE_2);
        if (null != taskInfo && StringUtils.isNotNull(taskInfo.getTaskId())){
            imsThesisTopic.setTaskId(taskInfo.getTaskId());
            //查询是否存在论题
            ImsThesisTopic topic = imsThesisTopicMapper.selectImsThesisTopicByUserId(userId);
            if (null != topic && StringUtils.isNotEmpty(topic.getTopicId())){
                throw new CustomException("你已提交论文题目！");
            }
            i = imsThesisTopicMapper.insertImsThesisTopic(imsThesisTopic);
            //插入论文子任务
            insertTaskChild(imsThesisTopic);
        }else {
            throw new CustomException("未发布该学院的实习任务，请联系管理员！");
        }
        return i;
    }

    /**
     * 插入论文子任务
     * @param imsThesisTopic 论文信息
     */
    public void insertTaskChild(ImsThesisTopic imsThesisTopic){
        if (StringUtils.isNotEmpty(imsThesisTopic.getTopicId())){
            ImsThesisTopic topic = imsThesisTopicMapper.selectImsThesisTopicById(imsThesisTopic.getTopicId());
            ImsTaskChildTopic childTopic = new ImsTaskChildTopic();
            childTopic.setBusinessId(topic.getTopicId());
            childTopic.setTaskId(topic.getTaskId());
            childTopic.setUserId(imsThesisTopic.getUserId());
            log.info("用户Id:{}",imsThesisTopic.getUserId());
            childTopic.setNextUser(imsThesisTopic.getTeacherId());
            childTopic.setProcessType(ImsConstants.TASK_PROCESS_TYPE_2);
            //论文题目
            childTopic.setChildProcessType(ImsConstants.CHILD_PROCESS_TYPE_P00);
            //代指导老师审核
            childTopic.setChildTaskStatus(ImsConstants.TASK_STAGE_Y01);
            childTopic.setCreateBy(imsThesisTopic.getCreateBy());
            childTopic.setCreateDept(imsThesisTopic.getCreateDept());
            topicService.insertImsTaskChildTopic(childTopic);
        }
    }

    /**
     * 修改课题信息
     * 
     * @param imsThesisTopic 课题信息
     * @return 结果
     */
    @Override
    public int updateImsThesisTopic(ImsThesisTopic imsThesisTopic)
    {
        imsThesisTopic.setUpdateTime(DateUtils.getNowDate());
        return imsThesisTopicMapper.updateImsThesisTopic(imsThesisTopic);
    }

    /**
     * 批量删除课题信息
     * 
     * @param topicIds 需要删除的课题信息ID
     * @return 结果
     */
    @Override
    public int deleteImsThesisTopicByIds(String[] topicIds)
    {
        return imsThesisTopicMapper.deleteImsThesisTopicByIds(topicIds);
    }

    /**
     * 删除课题信息信息
     * 
     * @param topicId 课题信息ID
     * @return 结果
     */
    @Override
    public int deleteImsThesisTopicById(String topicId)
    {
        return imsThesisTopicMapper.deleteImsThesisTopicById(topicId);
    }
}
