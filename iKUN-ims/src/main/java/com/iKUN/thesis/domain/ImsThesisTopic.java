package com.iKUN.thesis.domain;

import com.iKUN.common.annotation.Excel;
import com.iKUN.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 课题信息对象 ims_thesis_topic
 * 
 * @author iKUN
 * @date 2022-12-18
 */
public class ImsThesisTopic extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 课题编号 */
    private String topicId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 任务ID */
    private Long taskId;

    /** 学生用户姓名 */
    private String stuNickName;

    /** 导师ID */
    @Excel(name = "导师ID")
    private Long teacherId;

    /** 导师姓名 */
    private String nickName;

    /** 院系ID */
    @Excel(name = "院系ID")
    private Long deptId;

    /** 课题 */
    @Excel(name = "课题")
    private String topicTitle;

    /** 题目来源 0-导师拟定 1-科研项目 2-学生自行拟定 */
    @Excel(name = "题目来源 ")
    private String topicSource;

    /** 题目类型 */
    @Excel(name = "题目类型")
    private String topicType;

    /** 课题描述 */
    @Excel(name = "课题描述")
    private String topicDesc;

    /** 课题状态
    0-未选中
    1-学生已提交课题，等待导师审批
    2-未通过导师审批，等待学生修改
    3-导师审批通过，等待学院审批
    4-未通过学院审批，等待学生修改
    5-学院已审批此课题，等待学生提交开题报告
     6-开题报告已提交，等待学生提交中期检查
     7-中期检查已提交，等待学生提交论文
    8-论文已提交
    9-结束 */
    @Excel(name = "课题状态 ")
    private String topicStatus;

    /** 学科门类
    0-工学
    1-哲学
    2-经济学
     3-法学
4-教育学 5-文学 
6-历史学 
7-理学 
8-农学
9-医学 
10-军事学 
11-管理学
12-艺术学 */
    @Excel(name = "学科门类 ")
    private String subjectCategory;

    /** 课题类型
0-工程设计
1-理论研究
2-实验研究
3-软件工程
4-文献型综述
5-其他类型 */
    @Excel(name = "课题类型 ")
    private String subjectType;

    /** 删除状态 */
    private String delFlag;

    /** 创建院系 */
    @Excel(name = "创建院系")
    private String createDept;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public void setTopicId(String topicId)
    {
        this.topicId = topicId;
    }

    public String getTopicId() 
    {
        return topicId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setTeacherId(Long teacherId) 
    {
        this.teacherId = teacherId;
    }

    public Long getTeacherId() 
    {
        return teacherId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public void setTopicTitle(String topicTitle)
    {
        this.topicTitle = topicTitle;
    }

    public String getTopicTitle() 
    {
        return topicTitle;
    }
    public void setTopicSource(String topicSource) 
    {
        this.topicSource = topicSource;
    }

    public String getTopicSource() 
    {
        return topicSource;
    }
    public void setTopicType(String topicType) 
    {
        this.topicType = topicType;
    }

    public String getTopicType() 
    {
        return topicType;
    }
    public void setTopicDesc(String topicDesc) 
    {
        this.topicDesc = topicDesc;
    }

    public String getTopicDesc() 
    {
        return topicDesc;
    }
    public void setTopicStatus(String topicStatus) 
    {
        this.topicStatus = topicStatus;
    }

    public String getTopicStatus() 
    {
        return topicStatus;
    }

    public void setSubjectCategory(String subjectCategory) 
    {
        this.subjectCategory = subjectCategory;
    }

    public String getSubjectCategory() 
    {
        return subjectCategory;
    }
    public void setSubjectType(String subjectType) 
    {
        this.subjectType = subjectType;
    }

    public String getSubjectType() 
    {
        return subjectType;
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

    public String getStuNickName() {
        return stuNickName;
    }

    public void setStuNickName(String stuNickName) {
        this.stuNickName = stuNickName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("topicId", topicId)
                .append("userId", userId)
                .append("taskId", taskId)
                .append("stuNickName", stuNickName)
                .append("teacherId", teacherId)
                .append("nickName", nickName)
                .append("deptId", deptId)
                .append("topicTitle", topicTitle)
                .append("topicSource", topicSource)
                .append("topicType", topicType)
                .append("topicDesc", topicDesc)
                .append("topicStatus", topicStatus)
                .append("subjectCategory", subjectCategory)
                .append("subjectType", subjectType)
                .append("delFlag", delFlag)
                .append("createDept", createDept)
                .toString();
    }
}
