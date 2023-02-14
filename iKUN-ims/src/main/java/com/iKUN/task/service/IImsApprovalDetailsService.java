package com.iKUN.task.service;

import com.iKUN.task.domain.ImsApprovalDetails;

import java.util.List;

/**
 * 审批明细信息Service接口
 * 
 * @author iKUN
 * @date 2023-01-11
 */
public interface IImsApprovalDetailsService 
{
    /**
     * 查询审批明细信息
     * 
     * @param appravalId 审批明细信息ID
     * @return 审批明细信息
     */
    public ImsApprovalDetails selectImsApprovalDetailsById(Long appravalId);

    /**
     * 查询审批明细信息列表
     * 
     * @param imsApprovalDetails 审批明细信息
     * @return 审批明细信息集合
     */
    public List<ImsApprovalDetails> selectImsApprovalDetailsList(ImsApprovalDetails imsApprovalDetails);

    /**
     * 新增审批明细信息
     * 
     * @param imsApprovalDetails 审批明细信息
     * @return 结果
     */
    public int insertImsApprovalDetails(ImsApprovalDetails imsApprovalDetails);

    /**
     * 修改审批明细信息
     * 
     * @param imsApprovalDetails 审批明细信息
     * @return 结果
     */
    public int updateImsApprovalDetails(ImsApprovalDetails imsApprovalDetails);

    /**
     * 批量删除审批明细信息
     * 
     * @param appravalIds 需要删除的审批明细信息ID
     * @return 结果
     */
    public int deleteImsApprovalDetailsByIds(Long[] appravalIds);

    /**
     * 删除审批明细信息信息
     * 
     * @param appravalId 审批明细信息ID
     * @return 结果
     */
    public int deleteImsApprovalDetailsById(Long appravalId);
}
