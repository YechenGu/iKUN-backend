package com.iKUN.dashboard.service;

import com.iKUN.analysis.domain.ImsPracticeWeeklyStatisticsVo;
import com.iKUN.analysis.domain.ImsThesisStatisticsVo;
import com.iKUN.dashboard.domain.ImsDashBoardNoticeVo;
import com.iKUN.dashboard.domain.ImsDashBoardTaskVo;

import java.util.List;

/**
 * @Author iKUN
 * @Date 2023/1/22 17:22
 * @Description 首页Service
 * @Version 1.0
 */
public interface ImsDashBoardService {

    /**
     * 首页实习考核plate数据
     * @param vo
     * @return
     */
    public List<List<?>> selectPracticeWeeklyStatisticsListInDashBoard(ImsPracticeWeeklyStatisticsVo vo);

    /**
     * 首页论文plate数据
     * @param vo
     * @return
     */
    public List<List<?>> selectThesisStatisticsListInDashBoard(ImsThesisStatisticsVo vo);

    /**
     * 首页 我的任务
     * @param vo
     * @return
     */
    public List<ImsDashBoardTaskVo> selectTaskInfoByUserId(ImsDashBoardTaskVo vo);

    /**
     * 首页最新动态
     * @param userId
     * @return
     */
    public List<ImsDashBoardNoticeVo> selectNoticeInfoByUserId(Long userId);

}
