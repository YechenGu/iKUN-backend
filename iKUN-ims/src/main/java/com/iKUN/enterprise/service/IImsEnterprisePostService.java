package com.iKUN.enterprise.service;

import java.util.List;
import com.iKUN.enterprise.domain.ImsEnterprisePost;
import com.iKUN.enterprise.domain.vo.RecruitmentInfoVo;

/**
 * 企业岗位信息Service接口
 * 
 * @author iKUN
 * @date 2022-11-17
 */
public interface IImsEnterprisePostService 
{
    /**
     * 查询企业岗位信息
     * 
     * @param postId 企业岗位信息ID
     * @return 企业岗位信息
     */
    public ImsEnterprisePost selectImsEnterprisePostById(Long postId);

    /**
     * 查询企业岗位信息列表
     * 
     * @param imsEnterprisePost 企业岗位信息
     * @return 企业岗位信息集合
     */
    public List<ImsEnterprisePost> selectImsEnterprisePostList(ImsEnterprisePost imsEnterprisePost);

    /**
     * 查询招聘信息列表
     *
     * @param recruitmentInfoVo 招聘信息Vo
     * @return 企业岗位信息集合
     */
    public List<RecruitmentInfoVo> selectEnterpriseWithPostList(RecruitmentInfoVo recruitmentInfoVo);

    /**
     * 查询招聘信息详情
     *
     * @param postId 岗位ID
     * @return 企业岗位信息集合
     */
    public RecruitmentInfoVo selectEnterpriseWithPostByPostId(Long postId);

    /**
     * 新增企业岗位信息
     * 
     * @param imsEnterprisePost 企业岗位信息
     * @return 结果
     */
    public int insertImsEnterprisePost(ImsEnterprisePost imsEnterprisePost);

    /**
     * 修改企业岗位信息
     * 
     * @param imsEnterprisePost 企业岗位信息
     * @return 结果
     */
    public int updateImsEnterprisePost(ImsEnterprisePost imsEnterprisePost);

    /**
     * 批量删除企业岗位信息
     * 
     * @param postIds 需要删除的企业岗位信息ID
     * @return 结果
     */
    public int deleteImsEnterprisePostByIds(Long[] postIds);

    /**
     * 删除企业岗位信息信息
     * 
     * @param postId 企业岗位信息ID
     * @return 结果
     */
    public int deleteImsEnterprisePostById(Long postId);
}
