package com.iKUN.analysis.mapper;

import com.iKUN.analysis.domain.ImsThesisStatisticsVo;

import java.util.List;

/**
 * @author iKUN
 */
public interface ImsThesisAnalysisMapper {

    /**
     * 论文统计分析
     * @param vo
     * @return
     */
    public List<ImsThesisStatisticsVo> selectThesisStatisticsList(ImsThesisStatisticsVo vo);
}
