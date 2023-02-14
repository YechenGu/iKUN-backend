package com.iKUN.enterprise.service.impl;

import com.iKUN.common.utils.DateUtils;
import com.iKUN.commons.ImsConstants;
import com.iKUN.enterprise.domain.ImsEnterpriseInfo;
import com.iKUN.enterprise.mapper.ImsEnterpriseInfoMapper;
import com.iKUN.enterprise.mapper.ImsEnterprisePostMapper;
import com.iKUN.enterprise.service.IImsEnterpriseInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 企业信息Service业务层处理
 * 
 * @author iKUN
 * @date 2022-11-17
 */
@Service
public class ImsEnterpriseInfoServiceImpl implements IImsEnterpriseInfoService 
{

    @Resource
    private ImsEnterpriseInfoMapper imsEnterpriseInfoMapper;

    @Resource
    private ImsEnterprisePostMapper imsEnterprisePostMapper;

    /**
     * 查询企业信息
     * 
     * @param companyId 企业信息ID
     * @return 企业信息
     */
    @Override
    public ImsEnterpriseInfo selectImsEnterpriseInfoById(Long companyId)
    {
        return imsEnterpriseInfoMapper.selectImsEnterpriseInfoById(companyId);
    }

    /**
     * 通过企业名查询企业信息
     * @param companyName 企业名
     * @return
     */
    @Override
    public ImsEnterpriseInfo selectImsEnterpriseInfoByCompanyName(String companyName) {
        return imsEnterpriseInfoMapper.selectImsEnterpriseInfoByCompanyName(companyName);
    }

    /**
     * 查询企业信息列表
     * 
     * @param imsEnterpriseInfo 企业信息
     * @return 企业信息
     */
    @Override
    public List<ImsEnterpriseInfo> selectImsEnterpriseInfoList(ImsEnterpriseInfo imsEnterpriseInfo)
    {
        return imsEnterpriseInfoMapper.selectImsEnterpriseInfoList(imsEnterpriseInfo);
    }

    /**
     * 查询企业ID和企业名信息列表
     * @param imsEnterpriseInfo 企业信息
     * @return
     */
    @Override
    public List<ImsEnterpriseInfo> selectImsEnterpriseCompanyInfoList(ImsEnterpriseInfo imsEnterpriseInfo) {
        return imsEnterpriseInfoMapper.selectImsEnterpriseCompanyInfoList(imsEnterpriseInfo);
    }

    /**
     * 新增企业信息
     * 
     * @param imsEnterpriseInfo 企业信息
     * @return 结果
     */
    @Override
    public int insertImsEnterpriseInfo(ImsEnterpriseInfo imsEnterpriseInfo)
    {
        imsEnterpriseInfo.setCreateTime(DateUtils.getNowDate());
        imsEnterpriseInfo.setUpdateTime(DateUtils.getNowDate());
        imsEnterpriseInfo.setDelFlag(ImsConstants.dEL_NO);
        imsEnterpriseInfo.setStatus(ImsConstants.STATUS_NO);
        imsEnterpriseInfo.setRecruitStatus(ImsConstants.RECRUIT_STATUS_NO);
        return imsEnterpriseInfoMapper.insertImsEnterpriseInfo(imsEnterpriseInfo);
    }

    /**
     * 修改企业信息
     * 
     * @param imsEnterpriseInfo 企业信息
     * @return 结果
     */
    @Override
    public int updateImsEnterpriseInfo(ImsEnterpriseInfo imsEnterpriseInfo)
    {
        imsEnterpriseInfo.setUpdateTime(DateUtils.getNowDate());
        return imsEnterpriseInfoMapper.updateImsEnterpriseInfo(imsEnterpriseInfo);
    }

    /**
     * 批量删除企业信息
     * 
     * @param companyIds 需要删除的企业信息ID
     * @return 结果
     */
    @Override
    public int deleteImsEnterpriseInfoByIds(Long[] companyIds)
    {
        return imsEnterpriseInfoMapper.deleteImsEnterpriseInfoByIds(companyIds);
    }

    /**
     * 删除企业信息信息
     * 
     * @param companyId 企业信息ID
     * @return 结果
     */
    @Override
    public int deleteImsEnterpriseInfoById(Long companyId)
    {
        return imsEnterpriseInfoMapper.deleteImsEnterpriseInfoById(companyId);
    }
}
