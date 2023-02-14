package com.iKUN.analysis.service.impl;

import com.iKUN.analysis.domain.ImsPracticeStatisticsTableVo;
import com.iKUN.analysis.domain.ImsPracticeWareStatisticsVo;
import com.iKUN.analysis.mapper.ImsPracticeAnalysisMapper;
import com.iKUN.analysis.service.ImsPracticeCommonService;
import com.iKUN.analysis.service.ImsPracticeWareAnalysisService;
import com.iKUN.common.core.domain.entity.SysDept;
import com.iKUN.commons.ImsConstants;
import com.iKUN.system.mapper.SysDeptMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author iKUN
 * @Date 2023/1/2 15:18
 * @Description 实习工资分析Impl
 * @Version 1.0
 */
@Service
public class ImsPracticeWareServiceImpl implements ImsPracticeWareAnalysisService {

    private Logger log = LoggerFactory.getLogger(getClass());
    @Resource
    private ImsPracticeAnalysisMapper analysisMapper;
    @Resource
    private SysDeptMapper deptMapper;
    @Resource
    private ImsPracticeCommonService practiceCommonService;

    /**
     * 实习工资Impl
     * @param deptId 院系ID
     * @param academicYear 年份
     * @param deptType 院系类型
     * @return
     */
    @Override
    public Map<Object, List<?>> calculationWarePractice(Long deptId, String academicYear, String deptType) {
        //初始化结果List
        Map<Object, List<?>> resultMap = new HashMap<>();
        //平均工资list
        List<Long> avgWareList = new ArrayList<>();
        //最低工资list
        List<Long> minWareList = new ArrayList<>();
        //最高工资list
        List<Long> maxWareList = new ArrayList<>();
        //实习人数Table数据列表
        List<ImsPracticeStatisticsTableVo> dataTables = new ArrayList<>();
        //院系列表
        List<String> deptNameList = new ArrayList<>();
        List<SysDept> depts = deptMapper.selectChildrenDeptById(deptId, deptType);
        if (null != depts && 0 < depts.size()) {
            //院系列表
            deptNameList = depts.stream().map(SysDept::getDeptName).collect(Collectors.toList());
            depts.forEach(dept -> {
                addCalculationInfo(dept,academicYear,maxWareList,avgWareList,minWareList,dataTables);
            });
        }else {
            if (ImsConstants.DEPT_TYPE_CLASS.equals(deptType)){
                SysDept dept = deptMapper.selectDeptById(deptId);
                deptNameList.add(dept.getDeptName());
                addCalculationInfo(dept,academicYear,maxWareList,avgWareList,minWareList,dataTables);
            }
        }
        List<Object> title = new ArrayList<>();
        title.add("最高工资");
        title.add("平均工资");
        title.add("最低工资");
        List<Map<String, Object>> maps = practiceCommonService.calculationPlate(maxWareList,avgWareList,minWareList, title);
        resultMap.put("dataTables",dataTables);
        resultMap.put("deptNameList",deptNameList);
        resultMap.put("maxWareList",maxWareList);
        resultMap.put("avgWareList",avgWareList);
        resultMap.put("minWareList",minWareList);
        resultMap.put("internWarePlate",maps);
        return resultMap;
    }

    /**
     *
     * @param dept 院系
     * @param academicYear 年份
     * @param maxWareList 最高工资列表
     * @param avgWareList 平均工资列表
     * @param minWareList 最低工资列表
     * @param dataTables 数据列表
     */
    public void addCalculationInfo(SysDept dept, String academicYear, List<Long> maxWareList, List<Long> avgWareList,List<Long> minWareList, List<ImsPracticeStatisticsTableVo> dataTables){
        ImsPracticeWareStatisticsVo vo = new ImsPracticeWareStatisticsVo();
        ImsPracticeStatisticsTableVo tableVo = new ImsPracticeStatisticsTableVo();
        vo.setDeptId(dept.getDeptId());
        vo.setAcademicYear(academicYear);
        List<ImsPracticeWareStatisticsVo> voList = analysisMapper.selectPracticeWareStatisticsList(vo);
        //统计数据
        IntSummaryStatistics summaryStatistics;
        //最高工资
        int max = 0;
        //平均工资
        long average = 0;
        //最低工资
        int min = 0;
        if(null != voList && 0 < voList.size()){
            //统计数据
            summaryStatistics = voList.stream().mapToInt(ImsPracticeWareStatisticsVo::getPostWage).summaryStatistics();
            //最高工资
            max = summaryStatistics.getMax();
            //平均工资
            average = Math.round(summaryStatistics.getAverage());
            //最低工资
            min = summaryStatistics.getMin();
        }
        //数据列表数据
        tableVo.setDeptName(dept.getDeptName());
        tableVo.setColumnNum1(max);
        tableVo.setColumnNum2(average);
        tableVo.setColumnNum3(min);
        dataTables.add(tableVo);
        maxWareList.add((long) max);
        avgWareList.add(average);
        minWareList.add((long) min);
    }
}
