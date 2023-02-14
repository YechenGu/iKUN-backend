package com.iKUN.analysis.service;

import java.util.List;
import java.util.Map;

/**
 * @Author iKUN
 * @Date 2023/1/2 10:22
 * @Description 实习统计分析公用service
 * @Version 1.0
 */
public interface ImsPracticeCommonService {

    /**
     * 计算未实习、未提交等
     * @param deptId 院系ID
     * @param alreadyCount 已经完成
     * @param endCount 已经结束
     * @return
     */
    public Long calculationNo(Long deptId, Long alreadyCount, Long endCount);

    /**
     * 统计分析构造plate
     * @param list1 数据1
     * @param list2 数据2
     * @param list3 数据3
     * @param title 数据标题
     * @return list
     */
    public List<Map<String,Object>> calculationPlate(List<Long> list1,List<Long> list2,List<Long> list3,List<Object> title);
}
