package com.iKUN.analysis.service;

import java.util.List;
import java.util.Map;

/**
 * @Author iKUN
 * @Date 2023/1/22 17:22
 * @Description 实习统计相关分析
 * @Version 1.0
 */
public interface ImsPracticeAnalysisService {

    /**
     * 实习人数统计相关分析
     * @param deptId 院系ID
     * @param academicYear 年份
     * @param deptType 院系类型
     * @return
     */
    public Map<Object, List<?>> calculationPractice(Long deptId, String academicYear, String deptType);

}
