package com.iKUN.enterprise.domain;

import com.iKUN.common.annotation.Excel;
import com.iKUN.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 企业岗位信息对象 ims_enterprise_post
 * 
 * @author iKUN
 * @date 2022-11-17
 */
public class ImsEnterprisePost extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 岗位ID */
    private Long postId;

    /** 岗位名称 */
    @Excel(name = "岗位名称")
    private String postName;

    /** 公司ID */
    @Excel(name = "公司ID")
    private Long companyId;

    /** 公司名 */
    @Excel(name = "公司名")
    private String companyName;

    /** 任职要求 */
    @Excel(name = "任职要求")
    private String requirements;

    /** 经验 */
    @Excel(name = "经验")
    private String postExperience;

    /** 工作职责 */
    @Excel(name = "工作职责")
    private String responsibilities;

    /** 学历要求 */
    @Excel(name = "学历要求")
    private String education;

    /** 工资 */
    @Excel(name = "工资")
    private String postWage;

    /** 待遇 */
    @Excel(name = "待遇")
    private String postTreatment;

    /** 招聘人数 */
    @Excel(name = "招聘人数")
    private Long postNumber;

    /** 删除状态 */
    private String delFlag;

    /** 创建院系 */
    @Excel(name = "创建院系")
    private String createDept;

    public void setPostId(Long postId) 
    {
        this.postId = postId;
    }

    public Long getPostId() 
    {
        return postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public void setCompanyId(Long companyId)
    {
        this.companyId = companyId;
    }

    public Long getCompanyId() 
    {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setRequirements(String requirements)
    {
        this.requirements = requirements;
    }

    public String getRequirements() 
    {
        return requirements;
    }
    public void setPostExperience(String postExperience) 
    {
        this.postExperience = postExperience;
    }

    public String getPostExperience() 
    {
        return postExperience;
    }
    public void setResponsibilities(String responsibilities) 
    {
        this.responsibilities = responsibilities;
    }

    public String getResponsibilities() 
    {
        return responsibilities;
    }
    public void setEducation(String education) 
    {
        this.education = education;
    }

    public String getEducation() 
    {
        return education;
    }
    public void setPostWage(String postWage) 
    {
        this.postWage = postWage;
    }

    public String getPostWage() 
    {
        return postWage;
    }
    public void setPostTreatment(String postTreatment) 
    {
        this.postTreatment = postTreatment;
    }

    public String getPostTreatment() 
    {
        return postTreatment;
    }
    public void setPostNumber(Long postNumber) 
    {
        this.postNumber = postNumber;
    }

    public Long getPostNumber() 
    {
        return postNumber;
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
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("postId", getPostId())
             .append("postName", getPostName())
            .append("companyId", getCompanyId())
             .append("companyName", getCompanyName())
            .append("requirements", getRequirements())
            .append("postExperience", getPostExperience())
            .append("responsibilities", getResponsibilities())
            .append("education", getEducation())
            .append("postWage", getPostWage())
            .append("postTreatment", getPostTreatment())
            .append("postNumber", getPostNumber())
            .append("delFlag", getDelFlag())
            .append("createDept", getCreateDept())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
