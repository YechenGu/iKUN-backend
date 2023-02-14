package com.iKUN.entitlement.domain;

import com.iKUN.common.annotation.Excel;
import com.iKUN.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 实习协议信息对象 ims_internship_agreement
 * 
 * @author iKUN
 * @date 2022-12-08
 */
public class ImsInternshipAgreement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 实习协议ID */
    private Long iaId;

    /** 实习ID */
    @Excel(name = "实习ID")
    private Long practiceId;

    /** 实习单位 */
    @Excel(name = "实习单位")
    private String companyName;

    /** 用户ID */
    private Long userId;

    private String schoolInstructor;

    /** 实习期限 */
    @Excel(name = "实习期限")
    private String theTerm;

    /** 协议类型 */
    @Excel(name = "协议类型")
    private String iaType;

    /** 文件ID */
    @Excel(name = "文件ID")
    private String fileId;

    /** 文件名 */
    @Excel(name = "文件名")
    private String fileName;

    /** 删除状态 */
    private String delFlag;

    /** 创建院系 */
    @Excel(name = "创建院系")
    private String createDept;

    public void setIaId(Long iaId) 
    {
        this.iaId = iaId;
    }

    public Long getIaId() 
    {
        return iaId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setPracticeId(Long practiceId)
    {
        this.practiceId = practiceId;
    }

    public Long getPracticeId() 
    {
        return practiceId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSchoolInstructor() {
        return schoolInstructor;
    }

    public void setSchoolInstructor(String schoolInstructor) {
        this.schoolInstructor = schoolInstructor;
    }

    public void setTheTerm(String theTerm)
    {
        this.theTerm = theTerm;
    }

    public String getTheTerm() 
    {
        return theTerm;
    }
    public void setIaType(String iaType) 
    {
        this.iaType = iaType;
    }

    public String getIaType() 
    {
        return iaType;
    }
    public void setFileId(String fileId) 
    {
        this.fileId = fileId;
    }

    public String getFileId() 
    {
        return fileId;
    }
    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("iaId", iaId)
                .append("practiceId", practiceId)
                .append("companyName", companyName)
                .append("userId", userId)
                .append("schoolInstructor", schoolInstructor)
                .append("theTerm", theTerm)
                .append("iaType", iaType)
                .append("fileId", fileId)
                .append("fileName", fileName)
                .append("delFlag", delFlag)
                .append("createDept", createDept)
                .toString();
    }
}
