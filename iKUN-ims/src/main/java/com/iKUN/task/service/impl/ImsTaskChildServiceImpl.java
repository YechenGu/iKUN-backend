package com.iKUN.task.service.impl;

import com.iKUN.common.exception.CustomException;
import com.iKUN.common.utils.DateUtils;
import com.iKUN.common.utils.StringUtils;
import com.iKUN.commons.ImsConstants;
import com.iKUN.practice.domain.ImsPractice;
import com.iKUN.practice.domain.ImsPracticeWeekly;
import com.iKUN.practice.mapper.ImsPracticeMapper;
import com.iKUN.practice.mapper.ImsPracticeWeeklyMapper;
import com.iKUN.task.domain.ImsTaskChild;
import com.iKUN.task.domain.ImsTaskConfig;
import com.iKUN.task.domain.ImsTaskDept;
import com.iKUN.task.domain.vo.practiceVo.ImsChildPracticeVo;
import com.iKUN.task.domain.vo.practiceVo.ImsPracticeApplicationVo;
import com.iKUN.task.mapper.ImsTaskChildMapper;
import com.iKUN.task.mapper.ImsTaskConfigMapper;
import com.iKUN.task.mapper.ImsTaskDeptMapper;
import com.iKUN.task.service.IImsTaskChildService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 子任务信息Service业务层处理
 * 
 * @author iKUN
 * @date 2022-12-25
 */
@Service
public class ImsTaskChildServiceImpl implements IImsTaskChildService 
{
    private Logger log = LoggerFactory.getLogger(getClass());
    @Resource
    private ImsTaskChildMapper imsTaskChildMapper;
    @Resource
    private ImsTaskConfigMapper taskConfigMapper;
    @Resource
    private ImsPracticeMapper practiceMapper;
    @Resource
    private ImsTaskDeptMapper taskDeptMapper;
    @Resource
    private ImsPracticeWeeklyMapper practiceWeeklyMapper;

    /**
     * 查询子任务信息
     * 
     * @param childId 子任务信息ID
     * @return 子任务信息
     */
    @Override
    public ImsTaskChild selectImsTaskChildById(Long childId)
    {
        return imsTaskChildMapper.selectImsTaskChildById(childId);
    }

    /**
     * 查询子任务信息
     * @return
     */
    @Override
    public ImsTaskChild selectImsTaskChildByIds(ImsTaskChild imsTaskChild) {
        return imsTaskChildMapper.selectImsTaskChildByIds(imsTaskChild);
    }

    /**
     * 查询子任务信息列表
     * 
     * @param imsTaskChild 子任务信息
     * @return 子任务信息
     */
    @Override
    public List<ImsTaskChild> selectImsTaskChildList(ImsTaskChild imsTaskChild)
    {
        return imsTaskChildMapper.selectImsTaskChildList(imsTaskChild);
    }

    /**
     * 查询实习周记、总结子任务信息列表
     * @param imsChildPracticeVo 子任务信息
     * @return
     */
    @Override
    public List<ImsChildPracticeVo> selectChildPracticeList(ImsChildPracticeVo imsChildPracticeVo) {
        List<ImsChildPracticeVo> voList = imsTaskChildMapper.selectChildPracticeList(imsChildPracticeVo);
        List<ImsChildPracticeVo> resultList = new ArrayList<>();
        for (ImsChildPracticeVo vo : voList) {
            String businessName = ImsConstants.ASSESSMENT_TYPE_0.equals(vo.getAssessmenType()) ? "实习周记" : "实习总结";
            vo.setBusinessName(businessName);
            resultList.add(vo);
        }
        return resultList;
    }

    /**
     * 查询实习申请待办列表
     * @param vo
     * @return
     */
    @Override
    public List<ImsPracticeApplicationVo> selectPracticeApplicationList(ImsPracticeApplicationVo vo) {
        return imsTaskChildMapper.selectPracticeApplicationList(vo);
    }

    /**
     * 新增子任务信息
     * 
     * @param imsTaskChild 子任务信息
     * @return 结果
     */
    @Override
    public void insertImsTaskChild(ImsTaskChild imsTaskChild)
    {
        imsTaskChild.setCreateTime(DateUtils.getNowDate());
        imsTaskChild.setUpdateTime(DateUtils.getNowDate());
        //流程配置表
        ImsTaskConfig config = new ImsTaskConfig();
        config.setProcessType(imsTaskChild.getProcessType());
        config.setStage(imsTaskChild.getChildTaskStatus());
        config.setProcessChildType(imsTaskChild.getChildProcessType());
        config.setIsCheckNode(ImsConstants.IS_CHECK_NODE_YES);
        ImsTaskConfig taskConfig = taskConfigMapper.selectImsTaskConfig(config);
        if (StringUtils.isNull(taskConfig)){
            log.error("未找到该流程信息");
            throw new CustomException("未找到该流程信息");
        }
        //获取角色类型
        imsTaskChild.setNextRoleUser(taskConfig.getRole());
        //子任务进度
        imsTaskChild.setChildTaskProcess(ImsConstants.TASK_PROCESS_01);
        //子任务类型
        //任务ID和用户ID不为空的情况下,获取分配指导老师的ID
        if(ImsConstants.TASK_STAGE_Y01.equals(imsTaskChild.getChildTaskStatus())){
            if (StringUtils.isNotNull(imsTaskChild.getTaskId()) && StringUtils.isNotNull(imsTaskChild.getUserId())){
                ImsTaskDept taskDept = taskDeptMapper.selectImsTaskDeptById(imsTaskChild.getTaskId(), imsTaskChild.getUserId());
                imsTaskChild.setNextUser(taskDept.getTeaId());
            }
        }else {
            imsTaskChild.setNextUser(imsTaskChild.getUserId());
        }
        //查询该任务是否存在
        if (StringUtils.isNotNull(imsTaskChild.getUserId()) && StringUtils.isNotNull(imsTaskChild.getTaskId()) && StringUtils.isNotNull(imsTaskChild.getBusinessId())){
            ImsTaskChild child = imsTaskChildMapper.selectImsTaskChildByIds(imsTaskChild);
            if (null != child && StringUtils.isNotNull(child.getChildId())){
                child.setNextRoleUser(imsTaskChild.getNextRoleUser());
                child.setNextUser(imsTaskChild.getNextUser());
                child.setChildTaskProcess(imsTaskChild.getChildTaskProcess());
                child.setProcessType(imsTaskChild.getProcessType());
                child.setChildTaskStatus(imsTaskChild.getChildTaskStatus());
                imsTaskChildMapper.updateImsTaskChild(child);
            }else {
                imsTaskChildMapper.insertImsTaskChild(imsTaskChild);
            }
        }
    }

    /**
     * 修改子任务信息
     * 
     * @param imsTaskChild 子任务信息
     * @return 结果
     */
    @Override
    public int updateImsTaskChild(ImsTaskChild imsTaskChild)
    {
        imsTaskChild.setUpdateTime(DateUtils.getNowDate());
        //实习周记审核
        if (StringUtils.isNull(imsTaskChild.getBusinessId()) || StringUtils.isNull(imsTaskChild.getProcessType()) || StringUtils.isNull(imsTaskChild.getChildProcessType())) {
            log.info("未找到该{}",imsTaskChild.getProcessType());
            throw new CustomException("任务类型不能为空！");
        }
        //实习周记、总结审核
        if (ImsConstants.TASK_PROCESS_TYPE_1.equals(imsTaskChild.getProcessType()) && ImsConstants.CHILD_PROCESS_TYPE_I01.equals(imsTaskChild.getChildProcessType())){
            ImsPracticeWeekly practiceWeekly = practiceWeeklyMapper.selectImsPracticeWeeklyById(imsTaskChild.getBusinessId());
            if (ImsConstants.TASK_STAGE_Y04.equals(imsTaskChild.getChildTaskStatus()) && ImsConstants.TASK_PROCESS_02.equals(imsTaskChild.getChildTaskProcess())){
                practiceWeekly.setStatus(ImsConstants.STATUS_YES);
            }else {
                practiceWeekly.setStatus(ImsConstants.STATUS_NOT_PASS);
                practiceWeekly.setPublished(ImsConstants.PUBLISHED_0);
            }
            practiceWeeklyMapper.updateImsPracticeWeekly(practiceWeekly);
        }
        //实习申请审核
        if (ImsConstants.TASK_PROCESS_TYPE_1.equals(imsTaskChild.getProcessType()) && ImsConstants.CHILD_PROCESS_TYPE_I00.equals(imsTaskChild.getChildProcessType())){
            ImsPractice practice = practiceMapper.selectImsPracticeById(imsTaskChild.getBusinessId());
            if (ImsConstants.TASK_STAGE_Y04.equals(imsTaskChild.getChildTaskStatus()) && ImsConstants.TASK_PROCESS_02.equals(imsTaskChild.getChildTaskProcess())){
                practice.setStatus(ImsConstants.STATUS_YES);
                practice.setPracticeStatus(ImsConstants.PRACTICE_STATUS_1);
            }else {
                practice.setStatus(ImsConstants.STATUS_NOT_PASS);
            }
            practiceMapper.updateImsPractice(practice);
        }
        //实习鉴定表审核
        return imsTaskChildMapper.updateImsTaskChild(imsTaskChild);
    }

    /**
     * 批量删除子任务信息
     * 
     * @param childIds 需要删除的子任务信息ID
     * @return 结果
     */
    @Override
    public int deleteImsTaskChildByIds(Long[] childIds)
    {
        return imsTaskChildMapper.deleteImsTaskChildByIds(childIds);
    }

    /**
     * 删除子任务信息信息
     * 
     * @param childId 子任务信息ID
     * @return 结果
     */
    @Override
    public int deleteImsTaskChildById(Long childId)
    {
        return imsTaskChildMapper.deleteImsTaskChildById(childId);
    }
}
