package com.iKUN.dashboard.service.impl;

import com.iKUN.analysis.domain.ImsPracticeWeeklyStatisticsVo;
import com.iKUN.analysis.domain.ImsThesisStatisticsVo;
import com.iKUN.analysis.mapper.ImsThesisAnalysisMapper;
import com.iKUN.analysis.service.ImsPracticeWeeklyAnalysisService;
import com.iKUN.common.core.domain.entity.SysUser;
import com.iKUN.common.utils.DateUtils;
import com.iKUN.common.utils.SecurityUtils;
import com.iKUN.common.utils.StringUtils;
import com.iKUN.commons.ImsConstants;
import com.iKUN.dashboard.domain.ImsDashBoardNoticeVo;
import com.iKUN.dashboard.domain.ImsDashBoardTaskVo;
import com.iKUN.dashboard.mapper.ImsDashBoardMapper;
import com.iKUN.dashboard.service.ImsDashBoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author iKUN
 * @Date 2023/1/22 17:22
 * @Description 首页Service
 * @Version 1.0
 */
@Service
public class ImsDashBoardServiceImpl implements ImsDashBoardService {

    private Logger log = LoggerFactory.getLogger(getClass());
    @Resource
    private ImsDashBoardMapper dashBoardMapper;
    @Resource
    private ImsPracticeWeeklyAnalysisService practiceWeeklyAnalysisService;
    @Resource
    private ImsThesisAnalysisMapper thesisAnalysisMapper;

    private static final Long ROLE_STUDENT = 100L;

    /**
     * 首页- plate数据
     * @param vo
     * @return
     */
    @Override
    public List<List<?>> selectPracticeWeeklyStatisticsListInDashBoard(ImsPracticeWeeklyStatisticsVo vo) {
        List<List<?>> resultList = new ArrayList<>();
        //获取登录用户的角色
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long roleId = user.getRoleId();
        Long userId = user.getUserId();
        Long deptId = user.getDeptId();
        List<List<?>> tempList = new ArrayList<>();
        if (ROLE_STUDENT.equals(roleId)){
            ImsPracticeWeeklyStatisticsVo imsPracticeWeeklyStatisticsVo = new ImsPracticeWeeklyStatisticsVo();
            imsPracticeWeeklyStatisticsVo.setUserId(userId);
            List<ImsPracticeWeeklyStatisticsVo> list = dashBoardMapper.selectPracticeWeeklyStatisticsListInDashBoard(imsPracticeWeeklyStatisticsVo);
            list = list.parallelStream().filter(o -> ImsConstants.ASSESSMENT_TYPE_0.equals(o.getAssessmenType())).collect(Collectors.toList());
            List<Map<String, Object>> maps = structurePlateGroup(list);
            tempList.add(maps);
            List<ImsPracticeWeeklyStatisticsVo> collect = list.parallelStream().filter(o -> ImsConstants.ASSESSMENT_TYPE_1.equals(o.getAssessmenType())).collect(Collectors.toList());
            List<Map<String, Object>> maps1 = structurePlateGroup(collect);
            tempList.add(maps1);
        }else {
            Map<Object, List<?>> map = practiceWeeklyAnalysisService.calculationPracticeWeekly(deptId, null, ImsConstants.DEPT_TYPE_CLASS, null);
            Map<Object, List<?>> map1 = practiceWeeklyAnalysisService.calculationPracticeWeekly(deptId, null, ImsConstants.DEPT_TYPE_CLASS, ImsConstants.ASSESSMENT_TYPE_1_SUMMARY);
            List<Map<String, Object>> list = (List<Map<String, Object>>)map.get("internWeeklyPlate");
            List<Map<String, Object>> list1 = (List<Map<String, Object>>)map1.get("internWeeklyPlate");
            list.addAll(list1);
            tempList.add(list);
        }
        resultList.add(tempList);
        return resultList;
    }

    /**
     * 首页-论文plate数据
     * @param vo
     * @return
     */
    @Override
    public List<List<?>> selectThesisStatisticsListInDashBoard(ImsThesisStatisticsVo vo) {
        List<List<?>> result = new ArrayList<>();
        //获取登录的用户信息
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long roleId = user.getRoleId();
        Long userId = user.getUserId();
        Long deptId = user.getDeptId();
        List<Map<String, Object>> resultList = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();
        Map<String, Object> map3 = new HashMap<>();
        //如果角色是学生的话
        if (ROLE_STUDENT.equals(roleId)){
            vo.setUserId(userId);
            List<ImsThesisStatisticsVo> vos = thesisAnalysisMapper.selectThesisStatisticsList(vo);
            if (StringUtils.isNotNull(vos)){
                //获取查询的论文数据
                ImsThesisStatisticsVo thesisStatisticsVo = vos.get(0);
                String topicStatus = thesisStatisticsVo.getTopicStatus();
                if (Long.parseLong(topicStatus) >= Long.parseLong(ImsConstants.TOPIC_STATUS_1)){
                    map1.put("title","已提交课题");
                    map1.put("count",1);
                }else {
                    map1.put("title","已提交课题");
                    map1.put("count",0);
                }
                resultList.add(map1);
                if (Long.parseLong(topicStatus) > Long.parseLong(ImsConstants.TOPIC_STATUS_5)){
                    map2.put("title","已提交开题报告");
                    map2.put("count",1);
                }else {
                    map2.put("title","已提交开题报告");
                    map2.put("count",0);
                }
                resultList.add(map2);
                if (Long.parseLong(topicStatus) >= Long.parseLong(ImsConstants.TOPIC_STATUS_8)){
                    map3.put("title","已提交论文");
                    map3.put("count",1);
                }else {
                    map3.put("title","已提交论文");
                    map3.put("count",0);
                }
                resultList.add(map3);
            }
        }else {
            vo.setDeptId(deptId);
            List<ImsThesisStatisticsVo> vos = thesisAnalysisMapper.selectThesisStatisticsList(vo);
            if (StringUtils.isNotNull(vos)){
                //已提交课题人数
                long count = vos.parallelStream().filter(o -> Long.parseLong(ImsConstants.TOPIC_STATUS_1) <= Long.parseLong(o.getTopicStatus())).count();
                //已提交开题报告人数
                long count1 = vos.parallelStream().filter(o -> Long.parseLong(ImsConstants.TOPIC_STATUS_5) < Long.parseLong(o.getTopicStatus())).count();
                //已提交论文人数
                long count2 = vos.parallelStream().filter(o -> Long.parseLong(ImsConstants.TOPIC_STATUS_8) <= Long.parseLong(o.getTopicStatus())).count();
                map1.put("title","已提交课题");
                map1.put("count",count);
                map2.put("title","已提交开题报告");
                map2.put("count",count1);
                map3.put("title","已提交论文");
                map3.put("count",count2);
                resultList.add(map1);
                resultList.add(map2);
                resultList.add(map3);
            }
        }
        result.add(resultList);
        return result;
    }

    /**
     * 构造首页实习考核plate数据
     * @param list
     * @return
     */
    public List<Map<String, Object>> structurePlateGroup(List<ImsPracticeWeeklyStatisticsVo> list){
        List<Map<String, Object>> resultList = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();
        Map<String, Object> map3 = new HashMap<>();
        //已经审核的数据
        long count = list.parallelStream().filter(o -> ImsConstants.STATUS_YES.equals(o.getStatus())).count();
        //已经提交未审核的数据
        long count1 = list.parallelStream().filter(o -> ImsConstants.PUBLISHED_1.equals(o.getPublished()) && ImsConstants.STATUS_NO.equals(o.getStatus())).count();
        //未提交的数据
        long count2 = list.parallelStream().filter(o -> ImsConstants.STATUS_NO.equals(o.getStatus()) && ImsConstants.PUBLISHED_0.equals(o.getPublished())).count();
        map1.put("title","待提交");
        map1.put("count",count2);
        resultList.add(map1);
        map2.put("title","待审核");
        map2.put("count",count1);
        resultList.add(map2);
        map3.put("title","已审核");
        map3.put("count",count);
        resultList.add(map3);
        return resultList;
    }

    /**
     * 首页 -- 我的任务
     * @param vo
     * @return
     */
    @Override
    public List<ImsDashBoardTaskVo> selectTaskInfoByUserId(ImsDashBoardTaskVo vo) {
        List<ImsDashBoardTaskVo> voList = dashBoardMapper.selectTaskInfoByUserId(vo);
        voList.forEach( o -> {
                        //现在时间
            Date nowDate = DateUtils.getNowDate();
            //结束时间
            Date endTime = o.getEndTime();
            //创建时间
            Date createTime = o.getCreateTime();
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
            o.setSchedule(String.valueOf(percentage));
        });
        return voList;
    }

    /**
     *
     * @param userId
     * @return
     */
    @Override
    public List<ImsDashBoardNoticeVo> selectNoticeInfoByUserId(Long userId) {
        return dashBoardMapper.selectNoticeInfoByUserId(userId);
    }
}
