package com.iKUN.enterprise.mapper;

import com.iKUN.enterprise.domain.ImsEnterpriseInfo;

import java.util.List;

/**
 * 企业信息Mapper接口
 * 
 * @author iKUN
 * @date 2022-11-17
 */
public interface ImsEnterpriseInfoMapper 
{
    /**
     * 查询企业信息
     * 
     * @param companyId 企业信息ID
     * @return 企业信息
     */
    public ImsEnterpriseInfo selectImsEnterpriseInfoById(Long companyId);

    /**
     * 通过企业名查询企业信息
     * @param companyName 企业名
     * @return
     */
    public ImsEnterpriseInfo selectImsEnterpriseInfoByCompanyName(String companyName);

    /**
     * 查询企业信息列表
     * 
     * @param imsEnterpriseInfo 企业信息
     * @return 企业信息集合
     */
    public List<ImsEnterpriseInfo> selectImsEnterpriseInfoList(ImsEnterpriseInfo imsEnterpriseInfo);

    /**
     * 查询企业ID和企业名信息列表
     *
     * @param imsEnterpriseInfo 企业信息
     * @return 企业信息集合
     */
    public List<ImsEnterpriseInfo> selectImsEnterpriseCompanyInfoList(ImsEnterpriseInfo imsEnterpriseInfo);

    /**
     * 新增企业信息
     * 
     * @param imsEnterpriseInfo 企业信息
     * @return 结果
     */
    public int insertImsEnterpriseInfo(ImsEnterpriseInfo imsEnterpriseInfo);

    /**
     * 修改企业信息
     * 
     * @param imsEnterpriseInfo 企业信息
     * @return 结果
     */
    public int updateImsEnterpriseInfo(ImsEnterpriseInfo imsEnterpriseInfo);

    /**
     * 删除企业信息
     * 
     * @param companyId 企业信息ID
     * @return 结果
     */
    public int deleteImsEnterpriseInfoById(Long companyId);

    /**
     * 批量删除企业信息
     * 
     * @param companyIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteImsEnterpriseInfoByIds(Long[] companyIds);
}
