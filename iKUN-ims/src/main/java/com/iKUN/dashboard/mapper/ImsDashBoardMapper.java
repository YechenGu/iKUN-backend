package com.iKUN.dashboard.mapper;

import com.iKUN.analysis.domain.ImsPracticeWeeklyStatisticsVo;
import com.iKUN.dashboard.domain.ImsDashBoardNoticeVo;
import com.iKUN.dashboard.domain.ImsDashBoardTaskVo;

import java.util.List;

/**
 * @Author iKUN
 * @Date 2023/1/22 17:22
 * @Description 首页mapper
 * @Version 1.0
 */
public interface ImsDashBoardMapper {

    /**
     * 首页plate数据
     * @param vo
     * @return
     */
    public List<ImsPracticeWeeklyStatisticsVo> selectPracticeWeeklyStatisticsListInDashBoard(ImsPracticeWeeklyStatisticsVo vo);

    /**
     * 首页--我的任务
     * @param vo
     * @return
     */
    public List<ImsDashBoardTaskVo> selectTaskInfoByUserId(ImsDashBoardTaskVo vo);

    /**
     * 首页最新动态
     * @return
     */
    public List<ImsDashBoardNoticeVo> selectNoticeInfoByUserId(Long userId);

}
