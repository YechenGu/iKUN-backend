package com.iKUN.practice.domain;

import com.iKUN.common.annotation.Excel;
import com.iKUN.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 实习成绩信息对象 ims_practice_grade
 * 
 * @author iKUN
 * @date 2022-12-20
 */
public class ImsPracticeGrade extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 实习成绩ID */
    private Long gradeId;

    /** 实习ID */
    @Excel(name = "实习ID")
    private Long practiceId;

    /** 专业实习成绩 */
    @Excel(name = "专业实习成绩")
    private String piResult;

    private String nickName;

    private String companyName;

    /** 专业实习调查与研究报告成绩 */
    @Excel(name = "专业实习调查与研究报告成绩")
    private String srResult;

    /** 专业实习总成绩 */
    @Excel(name = "专业实习总成绩")
    private String totalScore;

    /** 教师意见 */
    @Excel(name = "教师意见")
    private String teaOpinion;

    /** 实习小组意见 */
    @Excel(name = "实习小组意见")
    private String groupOpinion;

    /** 学院意见 */
    @Excel(name = "学院意见")
    private String deptOpinion;

    /** 描述 */
    @Excel(name = "描述")
    private String gradeDesc;

    /** 审核状态 */
    @Excel(name = "审核状态")
    private String status;

    /** 删除状态 */
    private String delFlag;

    /** 创建院系 */
    @Excel(name = "创建院系")
    private String createDept;

    public void setGradeId(Long gradeId) 
    {
        this.gradeId = gradeId;
    }

    public Long getGradeId() 
    {
        return gradeId;
    }
    public void setPracticeId(Long practiceId) 
    {
        this.practiceId = practiceId;
    }

    public Long getPracticeId() 
    {
        return practiceId;
    }
    public void setPiResult(String piResult) 
    {
        this.piResult = piResult;
    }

    public String getPiResult() 
    {
        return piResult;
    }
    public void setSrResult(String srResult) 
    {
        this.srResult = srResult;
    }

    public String getSrResult() 
    {
        return srResult;
    }
    public void setTotalScore(String totalScore) 
    {
        this.totalScore = totalScore;
    }

    public String getTotalScore() 
    {
        return totalScore;
    }
    public void setTeaOpinion(String teaOpinion) 
    {
        this.teaOpinion = teaOpinion;
    }

    public String getTeaOpinion() 
    {
        return teaOpinion;
    }
    public void setGroupOpinion(String groupOpinion) 
    {
        this.groupOpinion = groupOpinion;
    }

    public String getGroupOpinion() 
    {
        return groupOpinion;
    }
    public void setDeptOpinion(String deptOpinion) 
    {
        this.deptOpinion = deptOpinion;
    }

    public String getDeptOpinion() 
    {
        return deptOpinion;
    }
    public void setGradeDesc(String gradeDesc) 
    {
        this.gradeDesc = gradeDesc;
    }

    public String getGradeDesc() 
    {
        return gradeDesc;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setCreateDept(String createDept) 
    {
        this.createDept = createDept;
    }

    public String getCreateDept() 
    {
        return createDept;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("gradeId", gradeId)
                .append("practiceId", practiceId)
                .append("piResult", piResult)
                .append("nickName", nickName)
                .append("companyName", companyName)
                .append("srResult", srResult)
                .append("totalScore", totalScore)
                .append("teaOpinion", teaOpinion)
                .append("groupOpinion", groupOpinion)
                .append("deptOpinion", deptOpinion)
                .append("gradeDesc", gradeDesc)
                .append("status", status)
                .append("delFlag", delFlag)
                .append("createDept", createDept)
                .toString();
    }
}
