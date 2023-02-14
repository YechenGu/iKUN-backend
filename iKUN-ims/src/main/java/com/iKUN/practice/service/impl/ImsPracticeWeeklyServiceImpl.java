package com.iKUN.practice.service.impl;

import com.iKUN.common.utils.DateUtils;
import com.iKUN.common.utils.StringUtils;
import com.iKUN.commons.ImsConstants;
import com.iKUN.practice.domain.ImsPractice;
import com.iKUN.practice.domain.ImsPracticeWeekly;
import com.iKUN.practice.mapper.ImsPracticeMapper;
import com.iKUN.practice.mapper.ImsPracticeWeeklyMapper;
import com.iKUN.practice.service.IImsPracticeWeeklyService;
import com.iKUN.task.domain.ImsTaskChild;
import com.iKUN.task.service.IImsTaskChildService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 实习考核信息Service业务层处理
 * 
 * @author iKUN
 * @date 2022-11-26
 */
@Service
public class ImsPracticeWeeklyServiceImpl implements IImsPracticeWeeklyService 
{
    private Logger log = LoggerFactory.getLogger(getClass());
    @Resource
    private ImsPracticeWeeklyMapper imsPracticeWeeklyMapper;

    @Resource
    private ImsPracticeMapper imsPracticeMapper;

    @Resource
    private IImsTaskChildService taskChildService;


    /**
     * 查询实习考核信息
     * 
     * @param weeklyId 实习考核信息ID
     * @return 实习考核信息
     */
    @Override
    public ImsPracticeWeekly selectImsPracticeWeeklyById(Long weeklyId)
    {
        return imsPracticeWeeklyMapper.selectImsPracticeWeeklyById(weeklyId);
    }

    /**
     * 查询实习考核信息列表
     * 
     * @param imsPracticeWeekly 实习考核信息
     * @return 实习考核信息
     */
    @Override
    public List<ImsPracticeWeekly> selectImsPracticeWeeklyList(ImsPracticeWeekly imsPracticeWeekly)
    {
        return imsPracticeWeeklyMapper.selectImsPracticeWeeklyList(imsPracticeWeekly);
    }

    /**
     * 新增实习考核信息
     * 
     * @param imsPracticeWeekly 实习考核信息
     * @return 结果
     */
    @Override
    public int insertImsPracticeWeekly(ImsPracticeWeekly imsPracticeWeekly)
    {
        try{
            imsPracticeWeekly.setCreateTime(DateUtils.getNowDate());
            imsPracticeWeekly.setUpdateTime(DateUtils.getNowDate());
            imsPracticeWeekly.setDelFlag(ImsConstants.dEL_NO);
            imsPracticeWeekly.setStatus(ImsConstants.STATUS_NO);
            //如果是实习总结的话,实习总结周次为99
            if(ImsConstants.ASSESSMENT_TYPE_1.equals(imsPracticeWeekly.getAssessmenType())){
                imsPracticeWeekly.setWeek(ImsConstants.ASSESSMENT_TYPE_1_SUMMARY);
            }
            int flag = imsPracticeWeeklyMapper.insertImsPracticeWeekly(imsPracticeWeekly);
            //插入子任务
            insertTaskChild(imsPracticeWeekly);
            return flag;
        }catch (Exception e){
            // return imsPracticeWeeklyMapper.deleteImsPracticeWeeklyById(imsPracticeWeekly.getWeeklyId());
            e.printStackTrace();
            return 1;
        }
    }

    /**
     * 修改实习考核信息
     * 
     * @param imsPracticeWeekly 实习考核信息
     * @return 结果
     */
    @Override
    public int updateImsPracticeWeekly(ImsPracticeWeekly imsPracticeWeekly)
    {
        imsPracticeWeekly.setUpdateTime(DateUtils.getNowDate());
        //插入子任务
        insertTaskChild(imsPracticeWeekly);
        return imsPracticeWeeklyMapper.updateImsPracticeWeekly(imsPracticeWeekly);
    }

    /**
     * 批量删除实习考核信息
     * 
     * @param weeklyIds 需要删除的实习考核信息ID
     * @return 结果
     */
    @Override
    public int deleteImsPracticeWeeklyByIds(Long[] weeklyIds)
    {
        return imsPracticeWeeklyMapper.deleteImsPracticeWeeklyByIds(weeklyIds);
    }

    /**
     * 删除实习考核信息信息
     * 
     * @param weeklyId 实习考核信息ID
     * @return 结果
     */
    @Override
    public int deleteImsPracticeWeeklyById(Long weeklyId)
    {
        return imsPracticeWeeklyMapper.deleteImsPracticeWeeklyById(weeklyId);
    }

    /**
     * 插入子任务
     * @param imsPracticeWeekly
     */
    public void insertTaskChild(ImsPracticeWeekly imsPracticeWeekly){
        String child = "";              //初始化子任务类型
        //如果是实习总结的话,实习总结周次为99
        if(ImsConstants.ASSESSMENT_TYPE_1.equals(imsPracticeWeekly.getAssessmenType())){
            child = ImsConstants.CHILD_PROCESS_TYPE_I02;
        }
        if(ImsConstants.ASSESSMENT_TYPE_0.equals(imsPracticeWeekly.getAssessmenType())){
            child = ImsConstants.CHILD_PROCESS_TYPE_I01;
        }
        String stage;
        if (ImsConstants.WEEK_PUBLISHED_1.equals(imsPracticeWeekly.getPublished())){
            stage = ImsConstants.TASK_STAGE_Y01;
        }else {
            stage = ImsConstants.TASK_STAGE_Y00;
        }
        //插入子任务
        if (StringUtils.isNotNull(imsPracticeWeekly.getPracticeId())){
            ImsPractice practice = imsPracticeMapper.selectImsPracticeById(imsPracticeWeekly.getPracticeId());
            ImsTaskChild imsTaskChild = new ImsTaskChild();
            imsTaskChild.setTaskId(practice.getTaskId());
            imsTaskChild.setUserId(imsPracticeWeekly.getUserId());
            log.info("用户Id:{}",imsPracticeWeekly.getUserId());
            imsTaskChild.setProcessType(ImsConstants.TASK_PROCESS_TYPE_1);
            imsTaskChild.setChildProcessType(child);
            imsTaskChild.setChildTaskStatus(stage);
            log.info("流程阶段是:{}",stage);
            imsTaskChild.setBusinessId(imsPracticeWeekly.getWeeklyId());
            imsTaskChild.setCreateBy(imsPracticeWeekly.getCreateBy());
            imsTaskChild.setCreateDept(imsPracticeWeekly.getCreateDept());
            taskChildService.insertImsTaskChild(imsTaskChild);
        }
    }

    /**
     * 数字转换成中文汉字
     * @param value 要转换的数
     * @return 返回数字转后的汉字字符串
     */
    public String numToChinese(int value) {
        String result = ""; //转译结果
        for (int i = String.valueOf(value).length() - 1; i >= 0; i--) {//String.valueOf(value) 转换成String型得到其长度 并排除个位,因为个位不需要单位
            int r = (int) (value / Math.pow(10, i));//value / Math.pow(10, i) 截位匹配单位
            result += ImsConstants.NUMS[r % 10] + ImsConstants.UNITS[i];
        }
        result = result.replaceAll("零[十, 百, 千]", "零");//匹配字符串中的 "零[十, 百, 千]" 替换为 "零"
        result = result.replaceAll("零+", "零");//匹配字符串中的1或多个 "零" 替换为 "零"
        if (result.startsWith("一十")) { //判断是否以 "一十" 开头 如果是截取第一个字符
            result = result.substring(1);
        }
        if (result.endsWith("零")) { //判断是否以 "零" 结尾 如果是截取除 "零" 外的字符
            result = result.substring(0, result.length() - 1);
        }
        result = "第"+result+"周";
        return result;
    }
}

