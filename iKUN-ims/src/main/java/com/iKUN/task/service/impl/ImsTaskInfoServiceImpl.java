package com.iKUN.task.service.impl;

import com.iKUN.common.core.domain.entity.SysUser;
import com.iKUN.common.utils.DateUtils;
import com.iKUN.common.utils.StringUtils;
import com.iKUN.commons.ImsConstants;
import com.iKUN.practice.mapper.ImsPracticeMapper;
import com.iKUN.system.mapper.SysUserMapper;
import com.iKUN.task.domain.ImsTaskInfo;
import com.iKUN.task.mapper.ImsTaskInfoMapper;
import com.iKUN.task.service.IImsTaskInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * 任务信息Service业务层处理
 * 
 * @author iKUN
 * @date 2022-12-25
 */
@Service
public class ImsTaskInfoServiceImpl implements IImsTaskInfoService 
{
    private Logger log = LoggerFactory.getLogger(getClass());
    @Resource
    private ImsTaskInfoMapper imsTaskInfoMapper;
    @Resource
    private SysUserMapper userMapper;
    @Resource
    private ImsPracticeMapper practiceMapper;

    /**
     * 查询任务信息
     * 
     * @param taskId 任务信息ID
     * @return 任务信息
     */
    @Override
    public ImsTaskInfo selectImsTaskInfoById(Long taskId)
    {
        return imsTaskInfoMapper.selectImsTaskInfoById(taskId);
    }

    /**
     * 查询任务信息列表
     * 
     * @param imsTaskInfo 任务信息
     * @return 任务信息
     */
    @Override
    public List<ImsTaskInfo> selectImsTaskInfoList(ImsTaskInfo imsTaskInfo)
    {
        List<ImsTaskInfo> infoList = imsTaskInfoMapper.selectImsTaskInfoList(imsTaskInfo);
        infoList.forEach(taskInfo ->{
            Long deptId = taskInfo.getDeptId();
            Long taskId = taskInfo.getTaskId();
            SysUser user = new SysUser();
            user.setDeptId(deptId);
            //院系总人数
            BigDecimal sumCount = BigDecimal.valueOf(userMapper.selectUserList(user).size());
            log.info("院系总人数为"+sumCount);
            BigDecimal count = BigDecimal.valueOf(0L);
            if (ImsConstants.TASK_PROCESS_TYPE_1.equals(taskInfo.getProcessType())){
                Long aLong = practiceMapper.selectPracticeNumberByTaskId(taskId);
                if (StringUtils.isNotNull(aLong)){
                    count = BigDecimal.valueOf(aLong);
                    log.info("已经实习人数为"+count);
                }
            }
            BigDecimal percentage;
            if (sumCount != count && !ImsConstants.TASK_PROCESS_02.equals(taskInfo.getTaskProgress())){
                percentage = count.divide(sumCount, 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_DOWN);
            }else {
                percentage = BigDecimal.valueOf(100);
            }
            log.info("进度为%"+percentage);
            taskInfo.setRemark(String.valueOf(percentage));
   /*         //现在时间
            Date nowDate = DateUtils.getNowDate();
            //结束时间
            Date endTime = taskInfo.getEndTime();
            //创建时间
            Date createTime = taskInfo.getCreateTime();
            //计算时间差
            BigDecimal totalTime = DateUtils.getDayDatePoor(endTime, createTime);
            log.info("总共相差"+totalTime+"天");
            BigDecimal nowTime = DateUtils.getDayDatePoor(endTime, nowDate);
            log.info("现在距离结束时间相差"+nowTime+"天");
            BigDecimal day = totalTime.subtract(nowTime);
            log.info("距离开始时间"+day+"天");
            BigDecimal percentage = null;
            //计算百分比，四舍五入
            if (nowTime.compareTo(new BigDecimal(0)) >= 0){
                 percentage = day.divide(totalTime, 2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_DOWN);
            }else {
                percentage = BigDecimal.valueOf(100);
            }
            log.info("进度为%"+percentage);
            taskInfo.setRemark(String.valueOf(percentage));*/
        });
        return infoList;
    }

    /**
     * 新增任务信息
     * 
     * @param imsTaskInfo 任务信息
     * @return 结果
     */
    @Override
    public void insertImsTaskInfo(ImsTaskInfo imsTaskInfo)
    {
        imsTaskInfo.setTaskProgress(ImsConstants.TASK_PROCESS_01);
        imsTaskInfo.setDelFlag(ImsConstants.dEL_NO);
        imsTaskInfo.setCreateTime(DateUtils.getNowDate());
        imsTaskInfo.setUpdateTime(DateUtils.getNowDate());
        if (ImsConstants.TASK_PROCESS_TYPE_2.equals(imsTaskInfo.getProcessType())){

        }
        imsTaskInfoMapper.insertImsTaskInfo(imsTaskInfo);
    }

    /**
     * 修改任务信息
     * 
     * @param imsTaskInfo 任务信息
     * @return 结果
     */
    @Override
    public int updateImsTaskInfo(ImsTaskInfo imsTaskInfo)
    {
        imsTaskInfo.setUpdateTime(DateUtils.getNowDate());
        return imsTaskInfoMapper.updateImsTaskInfo(imsTaskInfo);
    }

    /**
     * 批量删除任务信息
     * 
     * @param taskIds 需要删除的任务信息ID
     * @return 结果
     */
    @Override
    public int deleteImsTaskInfoByIds(Long[] taskIds)
    {
        return imsTaskInfoMapper.deleteImsTaskInfoByIds(taskIds);
    }

    /**
     * 删除任务信息信息
     * 
     * @param taskId 任务信息ID
     * @return 结果
     */
    @Override
    public int deleteImsTaskInfoById(Long taskId)
    {
        return imsTaskInfoMapper.deleteImsTaskInfoById(taskId);
    }
}
