package com.iKUN.analysis.service.impl;

import com.iKUN.analysis.domain.ImsPracticeStatisticsTableVo;
import com.iKUN.analysis.domain.ImsPracticeWeeklyStatisticsVo;
import com.iKUN.analysis.mapper.ImsPracticeAnalysisMapper;
import com.iKUN.analysis.service.ImsPracticeCommonService;
import com.iKUN.analysis.service.ImsPracticeWeeklyAnalysisService;
import com.iKUN.common.core.domain.entity.SysDept;
import com.iKUN.commons.ImsConstants;
import com.iKUN.system.mapper.SysDeptMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author iKUN
 * @Date 2023/1/22 17:22
 * @Description 实习总体分析人数
 * @Version 1.0
 */
@Service
public class ImsPracticeWeeklyAnalysisServiceImpl implements ImsPracticeWeeklyAnalysisService {

    private Logger log = LoggerFactory.getLogger(getClass());
    @Resource
    private ImsPracticeAnalysisMapper analysisMapper;
    @Resource
    private SysDeptMapper deptMapper;
    @Resource
    private ImsPracticeCommonService practiceCommonService;

    /**
     * 实习周记相关统计分析
     * @param deptId 院系ID
     * @param academicYear 年份
     * @param deptType 院系类型
     * @return
     */
    @Override
    public Map<Object, List<?>> calculationPracticeWeekly(Long deptId, String academicYear, String deptType, String week) {
        //初始化结果List
        Map<Object, List<?>> resultMap = new HashMap<>();
        //已交周记list
        List<Long> submittedList = new ArrayList<>();
        //已交周记list
        List<Long> auditedList = new ArrayList<>();
        //未交List
        List<Long> unpaidList = new ArrayList<>();
        //周记统计Table数据列表
        List<ImsPracticeStatisticsTableVo> dataTables = new ArrayList<>();
        //周次列表
        List<String> deptNameList = new ArrayList<>();
        List<SysDept> depts = deptMapper.selectChildrenDeptById(deptId, deptType);
        if (null != depts && 0 < depts.size()) {
            //院系列表
            deptNameList = depts.stream().map(SysDept::getDeptName).collect(Collectors.toList());
            depts.forEach(dept -> {
               addCalculationInfo(dept,week,academicYear,submittedList,auditedList,unpaidList,dataTables);
            });
        }else {
            if (ImsConstants.DEPT_TYPE_CLASS.equals(deptType)){
                SysDept dept = deptMapper.selectDeptById(deptId);
                deptNameList.add(dept.getDeptName());
                addCalculationInfo(dept,week,academicYear,submittedList,auditedList,unpaidList,dataTables);
            }
        }
        List<Object> title = new ArrayList<>();
        title.add("已审批");
        title.add("已提交");
        title.add("未提交");
        List<Map<String, Object>> maps = practiceCommonService.calculationPlate(auditedList, submittedList,unpaidList, title);
        resultMap.put("dataTables",dataTables);
        resultMap.put("deptNameList",deptNameList);
        resultMap.put("auditedList",auditedList);
        resultMap.put("submittedList",submittedList);
        resultMap.put("unpaidList",unpaidList);
        resultMap.put("internWeeklyPlate",maps);
        return resultMap;
    }
    /**
     *
     * @param dept 院系信息
     * @param academicYear 年份
     * @param submittedList 实习结束列表
     * @param unpaidList 实习中列表
     * @param dataTables 表格数据列表
     */
    public void addCalculationInfo(SysDept dept,String week, String academicYear, List<Long> submittedList, List<Long> auditedList, List<Long> unpaidList, List<ImsPracticeStatisticsTableVo> dataTables){
        ImsPracticeWeeklyStatisticsVo vo = new ImsPracticeWeeklyStatisticsVo();
        vo.setAcademicYear(academicYear);
        vo.setDeptId(dept.getDeptId());
        vo.setWeek(week);
        if (ImsConstants.ASSESSMENT_TYPE_1_SUMMARY.equals(week)){
            vo.setAssessmenType(ImsConstants.ASSESSMENT_TYPE_1);
        }else {
            vo.setAssessmenType(ImsConstants.ASSESSMENT_TYPE_0);
        }
        List<ImsPracticeWeeklyStatisticsVo> voList = analysisMapper.selectPracticeWeeklyStatisticsList(vo);
        ImsPracticeStatisticsTableVo tableVo = new ImsPracticeStatisticsTableVo();
        //周记已交人数人数
        long submittedCount = voList.parallelStream().filter(o -> ImsConstants.PUBLISHED_1.equals(o.getPublished())).count();
        //已审核人数
        long auditedCount = voList.parallelStream().filter(o -> ImsConstants.PUBLISHED_1.equals(o.getPublished()) && ImsConstants.STATUS_YES.equals(o.getStatus())).count();
        //未实习人数
        Long unpaidCount = practiceCommonService.calculationNo(dept.getDeptId(), submittedCount, auditedCount);
        //数据列表数据
        tableVo.setDeptName(dept.getDeptName());
        tableVo.setColumnNum1(auditedCount);
        tableVo.setColumnNum2(submittedCount);
        tableVo.setColumnNum3(unpaidCount);
        dataTables.add(tableVo);
        unpaidList.add(unpaidCount);
        auditedList.add(auditedCount);
        submittedList.add(submittedCount);
    }
}
