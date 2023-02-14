package com.iKUN.analysis.service.impl;

import com.iKUN.analysis.domain.ImsPracticeStatisticsTableVo;
import com.iKUN.analysis.domain.ImsThesisStatisticsVo;
import com.iKUN.analysis.mapper.ImsThesisAnalysisMapper;
import com.iKUN.analysis.service.ImsPracticeCommonService;
import com.iKUN.analysis.service.ImsThesisAnalysisService;
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
 * @Date 2023/1/24 22:55
 * @Description 论文分析
 * @Version 1.0
 */
@Service
public class ImsThesisAnalysisServiceImpl implements ImsThesisAnalysisService {

    private Logger log = LoggerFactory.getLogger(getClass());
    @Resource
    private ImsThesisAnalysisMapper thesisAnalysisMapper;
    @Resource
    private SysDeptMapper deptMapper;
    @Resource
    private ImsPracticeCommonService practiceCommonService;

    /**
     * 论文统计分析
     * @param deptId 院系ID
     * @param academicYear 年份
     * @param deptType 院系类型
     * @return map
     */
    @Override
    public Map<Object, List<?>> calculationThesis(Long deptId, String academicYear, String deptType, String topicStatus) {
        //初始化结果List
        Map<Object, List<?>> resultMap = new HashMap<>();
        //已审批通过
        List<Long> submittedList = new ArrayList<>();
        //已提交,待审批
        List<Long> auditedList = new ArrayList<>();
        //未提交
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
                addCalculationInfo(dept, topicStatus, academicYear,submittedList,auditedList,unpaidList,dataTables);
            });
        }else {
            if (ImsConstants.DEPT_TYPE_CLASS.equals(deptType)){
                SysDept dept = deptMapper.selectDeptById(deptId);
                deptNameList.add(dept.getDeptName());
                addCalculationInfo(dept, topicStatus, academicYear,submittedList,auditedList,unpaidList,dataTables);
            }
        }
        List<Object> title = new ArrayList<>();
        title.add("已审批通过");
        title.add("已提交,待审批");
        title.add("未提交");
        List<Map<String, Object>> maps = practiceCommonService.calculationPlate(auditedList, submittedList,unpaidList, title);
        resultMap.put("dataTables",dataTables);
        resultMap.put("deptNameList",deptNameList);
        resultMap.put("auditedList",auditedList);
        resultMap.put("submittedList",submittedList);
        resultMap.put("unpaidList",unpaidList);
        resultMap.put("topicPlate",maps);
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
    public void addCalculationInfo(SysDept dept,String topicStatus, String academicYear, List<Long> submittedList, List<Long> auditedList, List<Long> unpaidList, List<ImsPracticeStatisticsTableVo> dataTables){
        ImsThesisStatisticsVo vo = new ImsThesisStatisticsVo();
        vo.setAcademicYear(academicYear);
        vo.setDeptId(dept.getDeptId());
        List<ImsThesisStatisticsVo> vos = thesisAnalysisMapper.selectThesisStatisticsList(vo);
        ImsPracticeStatisticsTableVo tableVo = new ImsPracticeStatisticsTableVo();
        //已审批通过
        long auditedCount = 0;
        //已提交,待审批
        long submittedCount = 0;
        //未提交
        Long unpaidCount = 0L;
        /** 论文状态 已提交课题，等待导师审批 */
        if (ImsConstants.TOPIC_STATUS_1.equals(topicStatus)){
            auditedCount = vos.parallelStream().filter(o -> ImsConstants.TOPIC_STATUS_5.equals(o.getTopicStatus()) && ImsConstants.dEL_NO.equals(o.getDelFlag())).count();
            submittedCount = vos.parallelStream().filter(o -> ImsConstants.TOPIC_STATUS_1.equals(o.getTopicStatus()) && ImsConstants.TOPIC_STATUS_3.equals(o.getTopicStatus()) && ImsConstants.TOPIC_STATUS_2.equals(o.getTopicStatus()) && ImsConstants.TOPIC_STATUS_4.equals(o.getTopicStatus()) && ImsConstants.dEL_NO.equals(o.getDelFlag())).count();
            //未提交
            unpaidCount = practiceCommonService.calculationNo(dept.getDeptId(), submittedCount, auditedCount);
        }
        /** 论文状态 学院已审批此课题，等待提交开题报告 */
        else if (ImsConstants.TOPIC_STATUS_5.equals(topicStatus)){
            auditedCount = vos.parallelStream().filter(o -> ImsConstants.TOPIC_STATUS_7.equals(o.getTopicStatus()) && ImsConstants.dEL_NO.equals(o.getDelFlag())).count();
            submittedCount = vos.parallelStream().filter(o -> ImsConstants.TOPIC_STATUS_6.equals(o.getTopicStatus()) && ImsConstants.dEL_NO.equals(o.getDelFlag())).count();
            unpaidCount = vos.parallelStream().filter(o -> ImsConstants.TOPIC_STATUS_5.equals(o.getTopicStatus()) && ImsConstants.dEL_NO.equals(o.getDelFlag())).count();
        }
        /** 论文状态 中期检查已提交，等待提交论文 */
        else if (ImsConstants.TOPIC_STATUS_7.equals(topicStatus)){
            auditedCount = vos.parallelStream().filter(o -> ImsConstants.TOPIC_STATUS_9.equals(o.getTopicStatus()) && ImsConstants.dEL_NO.equals(o.getDelFlag())).count();
            submittedCount = vos.parallelStream().filter(o -> ImsConstants.TOPIC_STATUS_8.equals(o.getTopicStatus()) && ImsConstants.dEL_NO.equals(o.getDelFlag())).count();
            unpaidCount = vos.parallelStream().filter(o -> ImsConstants.TOPIC_STATUS_7.equals(o.getTopicStatus()) && ImsConstants.dEL_NO.equals(o.getDelFlag())).count();
        }
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
