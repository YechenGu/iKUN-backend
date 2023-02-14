package com.iKUN.practice.mapper;

import com.iKUN.practice.domain.ImsPracticeWeekly;

import java.util.List;

/**
 * 实习考核信息Mapper接口
 * 
 * @author iKUN
 * @date 2022-11-26
 */
public interface ImsPracticeWeeklyMapper 
{
    /**
     * 查询实习考核信息
     * 
     * @param weeklyId 实习考核信息ID
     * @return 实习考核信息
     */
    public ImsPracticeWeekly selectImsPracticeWeeklyById(Long weeklyId);

    /**
     * 统计最大的周记数
     * @param userId
     * @return
     */
    public int selectMaxWeek(Long userId);

    /**
     * 查询实习考核信息列表
     * 
     * @param imsPracticeWeekly 实习考核信息
     * @return 实习考核信息集合
     */
    public List<ImsPracticeWeekly> selectImsPracticeWeeklyList(ImsPracticeWeekly imsPracticeWeekly);

    /**
     * 新增实习考核信息
     * 
     * @param imsPracticeWeekly 实习考核信息
     * @return 结果
     */
    public int insertImsPracticeWeekly(ImsPracticeWeekly imsPracticeWeekly);

    /**
     * 修改实习考核信息
     * 
     * @param imsPracticeWeekly 实习考核信息
     * @return 结果
     */
    public int updateImsPracticeWeekly(ImsPracticeWeekly imsPracticeWeekly);

    /**
     * 删除实习考核信息
     * 
     * @param weeklyId 实习考核信息ID
     * @return 结果
     */
    public int deleteImsPracticeWeeklyById(Long weeklyId);

    /**
     * 批量删除实习考核信息
     * 
     * @param weeklyIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteImsPracticeWeeklyByIds(Long[] weeklyIds);
}
