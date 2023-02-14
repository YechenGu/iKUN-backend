package com.iKUN.practice.service;

import com.iKUN.practice.domain.ImsPracticeGrade;

import java.util.List;

/**
 * 实习成绩信息Service接口
 * 
 * @author iKUN
 * @date 2022-12-20
 */
public interface IImsPracticeGradeService 
{
    /**
     * 查询实习成绩信息
     * 
     * @param gradeId 实习成绩信息ID
     * @return 实习成绩信息
     */
    public ImsPracticeGrade selectImsPracticeGradeById(Long gradeId);

    /**
     * 查询实习成绩信息列表
     * 
     * @param imsPracticeGrade 实习成绩信息
     * @return 实习成绩信息集合
     */
    public List<ImsPracticeGrade> selectImsPracticeGradeList(ImsPracticeGrade imsPracticeGrade);

    /**
     * 新增实习成绩信息
     * 
     * @param imsPracticeGrade 实习成绩信息
     * @return 结果
     */
    public int insertImsPracticeGrade(ImsPracticeGrade imsPracticeGrade);

    /**
     * 修改实习成绩信息
     * 
     * @param imsPracticeGrade 实习成绩信息
     * @return 结果
     */
    public int updateImsPracticeGrade(ImsPracticeGrade imsPracticeGrade);

    /**
     * 批量删除实习成绩信息
     * 
     * @param gradeIds 需要删除的实习成绩信息ID
     * @return 结果
     */
    public int deleteImsPracticeGradeByIds(Long[] gradeIds);

    /**
     * 删除实习成绩信息信息
     * 
     * @param gradeId 实习成绩信息ID
     * @return 结果
     */
    public int deleteImsPracticeGradeById(Long gradeId);
}
