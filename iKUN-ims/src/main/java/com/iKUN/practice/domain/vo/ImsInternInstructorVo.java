package com.iKUN.practice.domain.vo;

import com.iKUN.common.annotation.Excel;

/**
 * @Author iKUN
 * @Date 2023/1/17 14:37
 * @Description 实习指导老师Vo
 * @Version 1.0
 */
public class ImsInternInstructorVo {

    /** 企业名 */
    @Excel(name = "实习单位",width = 20)
    private String companyName;

    /** 实习指导老师 */
    @Excel(name = "实习指导老师")
    private String internInstructor;

    /** 实习指导老师电话 */
    @Excel(name = "实习指导老师联系方式",width = 24)
    private String internPhone;

    /** 实习指导老师email */
    @Excel(name = "实习指导老师email",width = 24)
    private String internEmail;

    /** 专业 */
    @Excel(name = "专业",width = 20)
    private String professionName;


    private Long deptId;

    /** 班级 */
    @Excel(name = "班级")
    private String deptName;

    /** 用户ID */
    private Long userId;

    /** 用户名 */
    @Excel(name = "用户名称")
    private String nickName;

    /** 学生联系方式 */
    @Excel(name = "学生联系方式")
    private String phonenumber;


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getInternInstructor() {
        return internInstructor;
    }

    public void setInternInstructor(String internInstructor) {
        this.internInstructor = internInstructor;
    }

    public String getInternPhone() {
        return internPhone;
    }

    public void setInternPhone(String internPhone) {
        this.internPhone = internPhone;
    }

    public String getInternEmail() {
        return internEmail;
    }

    public void setInternEmail(String internEmail) {
        this.internEmail = internEmail;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public String toString() {
        return "ImsInternInstructorVo{" +
                "companyName='" + companyName + '\'' +
                ", internInstructor='" + internInstructor + '\'' +
                ", internPhone='" + internPhone + '\'' +
                ", internEmail='" + internEmail + '\'' +
                ", professionName='" + professionName + '\'' +
                ", deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", userId=" + userId +
                ", nickName='" + nickName + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                '}';
    }
}
