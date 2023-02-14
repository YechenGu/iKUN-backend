package com.iKUN.analysis.service.impl;

import com.iKUN.analysis.domain.ImsPracticeStatisticsTableVo;
import com.iKUN.analysis.domain.ImsPracticeStatisticsVo;
import com.iKUN.analysis.mapper.ImsPracticeAnalysisMapper;
import com.iKUN.analysis.service.ImsPracticeAnalysisService;
import com.iKUN.analysis.service.ImsPracticeCommonService;
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
public class ImsPracticeAnalysisServiceImpl implements ImsPracticeAnalysisService {

    private Logger log = LoggerFactory.getLogger(getClass());
    @Resource
    private ImsPracticeAnalysisMapper analysisMapper;
    @Resource
    private SysDeptMapper deptMapper;
    @Resource
    private ImsPracticeCommonService practiceCommonService;

    /**
     * 实习人数统计分析
     * @return map
     */
    @Override
    public Map<Object, List<?>> calculationPractice(Long deptId, String academicYear, String deptType) {
        //初始化结果List
        Map<Object, List<?>> resultMap = new HashMap<>();
        //实习结束list
        List<Long> practiceList = new ArrayList<>();
        //实习中list
        List<Long> practicingList = new ArrayList<>();
        //未实习List
        List<Long> noPractice = new ArrayList<>();
        //实习人数Table数据列表
        List<ImsPracticeStatisticsTableVo> dataTables = new ArrayList<>();
        //院系列表
        List<String> deptNameList = new ArrayList<>();
        List<SysDept> depts = deptMapper.selectChildrenDeptById(deptId, deptType);
        if (null != depts && 0 < depts.size()) {
            //院系列表
            deptNameList = depts.stream().map(SysDept::getDeptName).collect(Collectors.toList());
            depts.forEach(dept -> {
                addCalculationInfo(dept,academicYear,practiceList,practicingList,noPractice,dataTables);
            });
        }else {
            if (ImsConstants.DEPT_TYPE_CLASS.equals(deptType)){
                SysDept dept = deptMapper.selectDeptById(deptId);
                deptNameList.add(dept.getDeptName());
                addCalculationInfo(dept,academicYear,practiceList,practicingList,noPractice,dataTables);
            }
        }
        List<Object> title = new ArrayList<>();
        title.add("实习结束人数");
        title.add("实习中人数");
        title.add("未实习人数");
        List<Map<String, Object>> maps = practiceCommonService.calculationPlate(practiceList, practicingList, noPractice, title);
        resultMap.put("dataTables",dataTables);
        resultMap.put("deptNameList",deptNameList);
        resultMap.put("endOfInternship",practiceList);
        resultMap.put("internship",practicingList);
        resultMap.put("noInternship",noPractice);
        resultMap.put("internshipPlate",maps);
        return resultMap;
    }

    /**
     *
     * @param dept 院系信息
     * @param academicYear 年份
     * @param practiceList 实习结束列表
     * @param practicingList 实习中列表
     * @param noPractice 未实习列表
     * @param dataTables 表格数据列表
     */
    public void addCalculationInfo(SysDept dept, String academicYear, List<Long> practiceList, List<Long> practicingList,List<Long> noPractice, List<ImsPracticeStatisticsTableVo> dataTables){
        ImsPracticeStatisticsVo vo = new ImsPracticeStatisticsVo();
        ImsPracticeStatisticsTableVo tableVo = new ImsPracticeStatisticsTableVo();
        vo.setDeptId(dept.getDeptId());
        vo.setAcademicYear(academicYear);
        List<ImsPracticeStatisticsVo> voList = analysisMapper.selectPracticeStatisticsList(vo);
        //实习中人数
        long practicing = voList.parallelStream().filter(o -> ImsConstants.PRACTICE_STATUS_1.equals(o.getPracticeStatus()) && ImsConstants.STATUS_YES.equals(o.getStatus())).count();
        //实习结束人数
        long practiceCount = voList.parallelStream().filter(o -> ImsConstants.PRACTICE_STATUS_2.equals(o.getPracticeStatus()) && ImsConstants.STATUS_YES.equals(o.getStatus())).count();
        //未实习人数
        Long noIntern = practiceCommonService.calculationNo(dept.getDeptId(), practicing, practiceCount);
        //数据列表数据
        tableVo.setDeptName(dept.getDeptName());
        tableVo.setColumnNum1(practicing);
        tableVo.setColumnNum2(practiceCount);
        tableVo.setColumnNum3(noIntern);
        dataTables.add(tableVo);
        practiceList.add(practiceCount);
        practicingList.add(practicing);
        noPractice.add(noIntern);
    }
}
