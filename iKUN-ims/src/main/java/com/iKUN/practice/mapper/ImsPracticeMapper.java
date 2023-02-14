package com.iKUN.practice.mapper;

import com.iKUN.practice.domain.ImsPractice;
import com.iKUN.practice.domain.vo.ImsInternInstructorVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 实习信息Mapper接口
 * 
 * @author iKUN
 * @date 2022-11-20
 */
public interface ImsPracticeMapper 
{
    /**
     * 查询实习信息
     * 
     * @param practiceId 实习信息ID
     * @return 实习信息
     */
    public ImsPractice selectImsPracticeById(Long practiceId);

    /**
     * 查询实习信息
     *
     * @param taskId 任务ID
     * @return 实习信息
     */
    public ImsPractice selectImsPracticeByTaskId(Long taskId);

    /**
     * 统计任务下实习人数
     * @param taskId 任务ID
     * @return number
     */
    public Long selectPracticeNumberByTaskId(Long taskId);

    /**
     * 查询实习信息列表
     * 
     * @param imsPractice 实习信息
     * @return 实习信息集合
     */
    public List<ImsPractice> selectImsPracticeList(ImsPractice imsPractice);

    /**
     * 查询个人的实习信息列表
     *
     * @param userId 用户ID
     * @param practiceStatus 实习状态 0-未实习 1-实习中 2-实习结束
     * @return 实习信息集合
     */
    public List<ImsPractice> selectImsPracticePersonalList(@Param("userId") Long userId,@Param("practiceStatus") String practiceStatus);

    /**
     * 查询实习指导老师列表
     * @param imsInstructorVo
     * @return
     */
    public List<ImsInternInstructorVo> selectInternInstructorList(ImsInternInstructorVo imsInstructorVo);

    /**
     * 查询实习指导老师列表
     * @param imsInstructorVo
     * @return
     */
    public List<ImsInternInstructorVo> exportInternInstructorList(ImsInternInstructorVo imsInstructorVo);

    /**
     * 新增实习信息
     * 
     * @param imsPractice 实习信息
     * @return 结果
     */
    public int insertImsPractice(ImsPractice imsPractice);

    /**
     * 修改实习信息
     * 
     * @param imsPractice 实习信息
     * @return 结果
     */
    public int updateImsPractice(ImsPractice imsPractice);

    /**
     * 删除实习信息
     * 
     * @param practiceId 实习信息ID
     * @return 结果
     */
    public int deleteImsPracticeById(Long practiceId);

    /**
     * 批量删除实习信息
     * 
     * @param practiceIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteImsPracticeByIds(Long[] practiceIds);



}
