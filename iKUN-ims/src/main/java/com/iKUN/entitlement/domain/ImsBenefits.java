package com.iKUN.entitlement.domain;

import com.iKUN.common.annotation.Excel;
import com.iKUN.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 工资待遇信息对象 ims_benefits
 * 
 * @author iKUN
 * @date 2022-12-05
 */
public class ImsBenefits extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 工资待遇ID */
    private Long benefitsId;

    /** 实习ID */
    @Excel(name = "实习ID")
    private Long practiceId;

    /** 实习单位 */
    @Excel(name = "实习单位")
    private String companyName;

    /** 福利管理 */
    @Excel(name = "福利管理")
    private String welfare;

    /** 工资 */
    @Excel(name = "工资")
    private Integer postWage;

    /** 待遇 */
    @Excel(name = "待遇")
    private String postTreatment;

    /** 删除状态 */
    private String delFlag;

    /** 创建院系 */
    @Excel(name = "创建院系")
    private String createDept;

    public void setBenefitsId(Long benefitsId) 
    {
        this.benefitsId = benefitsId;
    }

    public Long getBenefitsId() 
    {
        return benefitsId;
    }
    public void setPracticeId(Long practiceId) 
    {
        this.practiceId = practiceId;
    }

    public Long getPracticeId() 
    {
        return practiceId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setWelfare(String welfare)
    {
        this.welfare = welfare;
    }

    public String getWelfare()
    {
        return welfare;
    }
    public void setPostWage(Integer postWage)
    {
        this.postWage = postWage;
    }

    public Integer getPostWage()
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
            .append("benefitsId", getBenefitsId())
            .append("practiceId", getPracticeId())
            .append("companyName", getCompanyName())
            .append("welfare", getWelfare())
            .append("postWage", getPostWage())
            .append("postTreatment", getPostTreatment())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .append("createDept", getCreateDept())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
