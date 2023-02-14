package com.iKUN.entitlement.service;

import com.iKUN.entitlement.domain.ImsInternshipAgreement;

import java.util.List;

/**
 * 实习协议信息Service接口
 * 
 * @author iKUN
 * @date 2022-12-08
 */
public interface IImsInternshipAgreementService 
{
    /**
     * 查询实习协议信息
     * 
     * @param iaId 实习协议信息ID
     * @return 实习协议信息
     */
    public ImsInternshipAgreement selectImsInternshipAgreementById(Long iaId);

    /**
     * 查询实习协议信息列表
     * 
     * @param imsInternshipAgreement 实习协议信息
     * @return 实习协议信息集合
     */
    public List<ImsInternshipAgreement> selectImsInternshipAgreementList(ImsInternshipAgreement imsInternshipAgreement);

    /**
     * 新增实习协议信息
     * 
     * @param imsInternshipAgreement 实习协议信息
     * @return 结果
     */
    public int insertImsInternshipAgreement(ImsInternshipAgreement imsInternshipAgreement);

    /**
     * 修改实习协议信息
     * 
     * @param imsInternshipAgreement 实习协议信息
     * @return 结果
     */
    public int updateImsInternshipAgreement(ImsInternshipAgreement imsInternshipAgreement);

    /**
     * 批量删除实习协议信息
     * 
     * @param iaIds 需要删除的实习协议信息ID
     * @return 结果
     */
    public int deleteImsInternshipAgreementByIds(Long[] iaIds);

    /**
     * 删除实习协议信息信息
     * 
     * @param iaId 实习协议信息ID
     * @return 结果
     */
    public int deleteImsInternshipAgreementById(Long iaId);
}
