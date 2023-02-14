package com.iKUN.analysis.mapper;

import com.iKUN.analysis.domain.ImsPracticeStatisticsVo;
import com.iKUN.analysis.domain.ImsPracticeWareStatisticsVo;
import com.iKUN.analysis.domain.ImsPracticeWeeklyStatisticsVo;

import java.util.List;

/**
 * @Author iKUN
 * @Date 2023/1/22 17:22
 * @Description 实习统计分析mapper
 * @Version 1.0
 */
public interface ImsPracticeAnalysisMapper {

    /**
     * 实习人数统计相关分析
     *
     * @param vo
     * @return
     */
    public List<ImsPracticeStatisticsVo> selectPracticeStatisticsList(ImsPracticeStatisticsVo vo);

    /**
     * 实习周记统计相关分析
     * @param vo
     * @return
     */
    public List<ImsPracticeWeeklyStatisticsVo> selectPracticeWeeklyStatisticsList(ImsPracticeWeeklyStatisticsVo vo);

    /**
     * 实习工资统计分析
     * @param vo
     * @return
     */
    public List<ImsPracticeWareStatisticsVo> selectPracticeWareStatisticsList(ImsPracticeWareStatisticsVo vo);
}
