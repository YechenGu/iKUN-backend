package com.iKUN.enterprise.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.iKUN.common.annotation.Excel;
import com.iKUN.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 企业信息对象 ims_enterprise_info
 * 
 * @author iKUN
 * @date 2022-11-17
 */
public class ImsEnterpriseInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 公司ID */
    private Long companyId;

    /** 公司名 */
    @Excel(name = "公司名")
    private String companyName;

    /** 公司介绍 */
    @Excel(name = "公司介绍")
    private String companyProfile;

    /** 公司位置 */
    @Excel(name = "公司位置")
    private String companyLocation;

    /** 法人代表 */
    @Excel(name = "法人代表")
    private String legalRepresentative;

    /** 成立时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "成立时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date established;

    /** 公司性质 */
    @Excel(name = "公司性质")
    private String companyType;

    /** 公司行业 */
    @Excel(name = "公司行业")
    private String companyIndustry;

    /** 公司负责人 */
    @Excel(name = "公司负责人")
    private String companyPrincipal;

    /** 负责人电话 */
    @Excel(name = "负责人电话")
    private String principalPhone;

    /** 负责人email */
    @Excel(name = "负责人email")
    private String principalEmail;

    /** 负责人QQ */
    @Excel(name = "负责人QQ")
    private String principalQq;

    /** 招聘网址 */
    @Excel(name = "招聘网址")
    private String recruitmentWebsite;

    /** 招聘状态 */
    @Excel(name = "招聘状态")
    private String recruitStatus;

    /** 删除状态 */
    private String delFlag;

    /** 审核状态 */
    @Excel(name = "审核状态")
    private String status;

    /** 创建院系 */
    @Excel(name = "创建院系")
    private String createDept;

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

    public void setCompanyProfile(String companyProfile)
    {
        this.companyProfile = companyProfile;
    }

    public String getCompanyProfile() 
    {
        return companyProfile;
    }
    public void setCompanyLocation(String companyLocation) 
    {
        this.companyLocation = companyLocation;
    }

    public String getCompanyLocation() 
    {
        return companyLocation;
    }
    public void setLegalRepresentative(String legalRepresentative) 
    {
        this.legalRepresentative = legalRepresentative;
    }

    public String getLegalRepresentative() 
    {
        return legalRepresentative;
    }
    public void setEstablished(Date established) 
    {
        this.established = established;
    }

    public Date getEstablished() 
    {
        return established;
    }
    public void setCompanyType(String companyType) 
    {
        this.companyType = companyType;
    }

    public String getCompanyType() 
    {
        return companyType;
    }
    public void setCompanyIndustry(String companyIndustry) 
    {
        this.companyIndustry = companyIndustry;
    }

    public String getCompanyIndustry() 
    {
        return companyIndustry;
    }
    public void setCompanyPrincipal(String companyPrincipal) 
    {
        this.companyPrincipal = companyPrincipal;
    }

    public String getCompanyPrincipal() 
    {
        return companyPrincipal;
    }
    public void setPrincipalPhone(String principalPhone) 
    {
        this.principalPhone = principalPhone;
    }

    public String getPrincipalPhone() 
    {
        return principalPhone;
    }
    public void setPrincipalEmail(String principalEmail) 
    {
        this.principalEmail = principalEmail;
    }

    public String getPrincipalEmail() 
    {
        return principalEmail;
    }
    public void setPrincipalQq(String principalQq) 
    {
        this.principalQq = principalQq;
    }

    public String getPrincipalQq() 
    {
        return principalQq;
    }

    public String getRecruitmentWebsite() {
        return recruitmentWebsite;
    }

    public void setRecruitmentWebsite(String recruitmentWebsite) {
        this.recruitmentWebsite = recruitmentWebsite;
    }

    public void setRecruitStatus(String recruitStatus)
    {
        this.recruitStatus = recruitStatus;
    }

    public String getRecruitStatus() 
    {
        return recruitStatus;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
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
            .append("companyId", getCompanyId())
            .append("companyName", getCompanyName())
            .append("companyProfile", getCompanyProfile())
            .append("companyLocation", getCompanyLocation())
            .append("legalRepresentative", getLegalRepresentative())
            .append("established", getEstablished())
            .append("companyType", getCompanyType())
            .append("companyIndustry", getCompanyIndustry())
            .append("companyPrincipal", getCompanyPrincipal())
            .append("principalPhone", getPrincipalPhone())
            .append("principalEmail", getPrincipalEmail())
            .append("principalQq", getPrincipalQq())
             .append("recruitmentWebsite", getRecruitmentWebsite())
            .append("recruitStatus", getRecruitStatus())
            .append("delFlag", getDelFlag())
            .append("status", getStatus())
            .append("createDept", getCreateDept())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
