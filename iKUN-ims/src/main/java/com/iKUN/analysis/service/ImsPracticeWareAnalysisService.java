package com.iKUN.analysis.service;

import java.util.List;
import java.util.Map;

public interface ImsPracticeWareAnalysisService {

    /**
     * 实习工资统计相关分析
     * @param deptId 院系ID
     * @param academicYear 年份
     * @param deptType 院系类型
     * @return
     */
    public Map<Object, List<?>> calculationWarePractice(Long deptId, String academicYear, String deptType);
}
