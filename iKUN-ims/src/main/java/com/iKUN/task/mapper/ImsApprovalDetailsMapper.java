package com.iKUN.task.mapper;

import com.iKUN.task.domain.ImsApprovalDetails;

import java.util.List;

/**
 * 审批明细信息Mapper接口
 * 
 * @author iKUN
 * @date 2023-01-11
 */
public interface ImsApprovalDetailsMapper 
{
    /**
     * 查询审批明细信息
     * 
     * @param approvalId 审批明细信息ID
     * @return 审批明细信息
     */
    public ImsApprovalDetails selectImsApprovalDetailsById(Long approvalId);

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
     * 删除审批明细信息
     * 
     * @param approvalId 审批明细信息ID
     * @return 结果
     */
    public int deleteImsApprovalDetailsById(Long approvalId);

    /**
     * 批量删除审批明细信息
     * 
     * @param approvalIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteImsApprovalDetailsByIds(Long[] approvalIds);
}
