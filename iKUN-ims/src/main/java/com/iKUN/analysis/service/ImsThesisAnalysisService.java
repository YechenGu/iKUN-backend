package com.iKUN.analysis.service;

import java.util.List;
import java.util.Map;

/**
 * @Author iKUN
 * @Date 2023/1/24 22:55
 * @Description 论文分析
 * @Version 1.0
 */
public interface ImsThesisAnalysisService {

    /**
     * 论文统计分析
     * @param deptId 院系ID
     * @param academicYear 年份
     * @param deptType 院系类型
     * @return
     */
    public Map<Object, List<?>> calculationThesis(Long deptId, String academicYear, String deptType, String topicStatus);
}
