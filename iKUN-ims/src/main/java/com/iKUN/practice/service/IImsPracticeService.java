package com.iKUN.practice.service;

import com.iKUN.practice.domain.ImsPractice;
import com.iKUN.practice.domain.vo.ImsInternInstructorVo;

import java.util.List;

/**
 * 实习信息Service接口
 * 
 * @author iKUN
 * @date 2022-11-20
 */
public interface IImsPracticeService 
{
    /**
     * 查询实习信息
     * 
     * @param practiceId 实习信息ID
     * @return 实习信息
     */
    public ImsPractice selectImsPracticeById(Long practiceId);

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
     * @return 实习信息集合
     */
    public List<ImsPractice> selectImsPracticePersonalList(Long userId,String practiceStatus);

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
     * 批量删除实习信息
     * 
     * @param practiceIds 需要删除的实习信息ID
     * @return 结果
     */
    public int deleteImsPracticeByIds(Long[] practiceIds);

    /**
     * 删除实习信息信息
     * 
     * @param practiceId 实习信息ID
     * @return 结果
     */
    public int deleteImsPracticeById(Long practiceId);

}
