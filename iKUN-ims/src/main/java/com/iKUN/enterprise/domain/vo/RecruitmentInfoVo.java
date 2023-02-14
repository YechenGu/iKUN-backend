package com.iKUN.enterprise.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.iKUN.common.annotation.Excel;

import java.util.Date;

public class RecruitmentInfoVo {
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

    /** 岗位ID */
    private Long postId;

    /** 岗位名称 */
    @Excel(name = "岗位名称")
    private String postName;

    /** 任职要求 */
    @Excel(name = "任职要求")
    private String requirements;

    /** 经验 */
    @Excel(name = "经验")
    private String postExperience;

    /** 工作职责 */
    @Excel(name = "工作职责")
    private String responsibilities;

    /** 招聘网址 */
    @Excel(name = "招聘网址")
    private String recruitmentWebsite;

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

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyProfile() {
        return companyProfile;
    }

    public void setCompanyProfile(String companyProfile) {
        this.companyProfile = companyProfile;
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }

    public String getRecruitmentWebsite() {
        return recruitmentWebsite;
    }

    public void setRecruitmentWebsite(String recruitmentWebsite) {
        this.recruitmentWebsite = recruitmentWebsite;
    }

    public String getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(String legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public Date getEstablished() {
        return established;
    }

    public void setEstablished(Date established) {
        this.established = established;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getCompanyIndustry() {
        return companyIndustry;
    }

    public void setCompanyIndustry(String companyIndustry) {
        this.companyIndustry = companyIndustry;
    }

    public String getCompanyPrincipal() {
        return companyPrincipal;
    }

    public void setCompanyPrincipal(String companyPrincipal) {
        this.companyPrincipal = companyPrincipal;
    }

    public String getPrincipalPhone() {
        return principalPhone;
    }

    public void setPrincipalPhone(String principalPhone) {
        this.principalPhone = principalPhone;
    }

    public String getPrincipalEmail() {
        return principalEmail;
    }

    public void setPrincipalEmail(String principalEmail) {
        this.principalEmail = principalEmail;
    }

    public String getPrincipalQq() {
        return principalQq;
    }

    public void setPrincipalQq(String principalQq) {
        this.principalQq = principalQq;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public String getPostExperience() {
        return postExperience;
    }

    public void setPostExperience(String postExperience) {
        this.postExperience = postExperience;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPostWage() {
        return postWage;
    }

    public void setPostWage(String postWage) {
        this.postWage = postWage;
    }

    public String getPostTreatment() {
        return postTreatment;
    }

    public void setPostTreatment(String postTreatment) {
        this.postTreatment = postTreatment;
    }

    public Long getPostNumber() {
        return postNumber;
    }

    public void setPostNumber(Long postNumber) {
        this.postNumber = postNumber;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "RecruitmentInfoVo{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", companyProfile='" + companyProfile + '\'' +
                ", companyLocation='" + companyLocation + '\'' +
                ", legalRepresentative='" + legalRepresentative + '\'' +
                ", established=" + established +
                ", companyType='" + companyType + '\'' +
                ", companyIndustry='" + companyIndustry + '\'' +
                ", companyPrincipal='" + companyPrincipal + '\'' +
                ", principalPhone='" + principalPhone + '\'' +
                ", principalEmail='" + principalEmail + '\'' +
                ", principalQq='" + principalQq + '\'' +
                ", postId=" + postId +
                ", postName='" + postName + '\'' +
                ", requirements='" + requirements + '\'' +
                ", postExperience='" + postExperience + '\'' +
                ", responsibilities='" + responsibilities + '\'' +
                ", recruitmentWebsite='" + recruitmentWebsite + '\'' +
                ", education='" + education + '\'' +
                ", postWage='" + postWage + '\'' +
                ", postTreatment='" + postTreatment + '\'' +
                ", postNumber=" + postNumber +
                ", updateTime=" + updateTime +
                '}';
    }
}
