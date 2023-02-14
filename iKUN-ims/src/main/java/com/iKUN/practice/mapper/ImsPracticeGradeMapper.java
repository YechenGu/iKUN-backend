package com.iKUN.practice.mapper;

import com.iKUN.practice.domain.ImsPracticeGrade;

import java.util.List;

/**
 * 实习成绩信息Mapper接口
 * 
 * @author iKUN
 * @date 2022-12-20
 */
public interface ImsPracticeGradeMapper 
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
     * 删除实习成绩信息
     * 
     * @param gradeId 实习成绩信息ID
     * @return 结果
     */
    public int deleteImsPracticeGradeById(Long gradeId);

    /**
     * 批量删除实习成绩信息
     * 
     * @param gradeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteImsPracticeGradeByIds(Long[] gradeIds);
}
