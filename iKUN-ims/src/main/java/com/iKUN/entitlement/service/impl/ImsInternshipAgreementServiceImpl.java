package com.iKUN.entitlement.service.impl;

import com.iKUN.common.core.domain.entity.SysUser;
import com.iKUN.common.utils.DateUtils;
import com.iKUN.common.utils.SecurityUtils;
import com.iKUN.common.utils.StringUtils;
import com.iKUN.entitlement.domain.ImsInternshipAgreement;
import com.iKUN.entitlement.mapper.ImsInternshipAgreementMapper;
import com.iKUN.entitlement.service.IImsInternshipAgreementService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 实习协议信息Service业务层处理
 * 
 * @author iKUN
 * @date 2022-12-08
 */
@Service
public class ImsInternshipAgreementServiceImpl implements IImsInternshipAgreementService 
{
    @Resource
    private ImsInternshipAgreementMapper imsInternshipAgreementMapper;

    /**
     * 查询实习协议信息
     * 
     * @param iaId 实习协议信息ID
     * @return 实习协议信息
     */
    @Override
    public ImsInternshipAgreement selectImsInternshipAgreementById(Long iaId)
    {
        return imsInternshipAgreementMapper.selectImsInternshipAgreementById(iaId);
    }

    /**
     * 查询实习协议信息列表
     * 
     * @param imsInternshipAgreement 实习协议信息
     * @return 实习协议信息
     */
    @Override
    public List<ImsInternshipAgreement> selectImsInternshipAgreementList(ImsInternshipAgreement imsInternshipAgreement)
    {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long roleId = user.getRoleId();
        if (StringUtils.isNotNull(roleId)){
            if (100 == roleId){
                imsInternshipAgreement.setUserId(user.getUserId());
            }else if (2 == roleId){
                imsInternshipAgreement.setSchoolInstructor(user.getNickName());
            }
        }
        return imsInternshipAgreementMapper.selectImsInternshipAgreementList(imsInternshipAgreement);
    }

    /**
     * 新增实习协议信息
     * 
     * @param imsInternshipAgreement 实习协议信息
     * @return 结果
     */
    @Override
    public int insertImsInternshipAgreement(ImsInternshipAgreement imsInternshipAgreement)
    {
        imsInternshipAgreement.setCreateTime(DateUtils.getNowDate());
        imsInternshipAgreement.setUpdateTime(DateUtils.getNowDate());
        return imsInternshipAgreementMapper.insertImsInternshipAgreement(imsInternshipAgreement);
    }

    /**
     * 修改实习协议信息
     * 
     * @param imsInternshipAgreement 实习协议信息
     * @return 结果
     */
    @Override
    public int updateImsInternshipAgreement(ImsInternshipAgreement imsInternshipAgreement)
    {
        imsInternshipAgreement.setUpdateTime(DateUtils.getNowDate());
        return imsInternshipAgreementMapper.updateImsInternshipAgreement(imsInternshipAgreement);
    }

    /**
     * 批量删除实习协议信息
     * 
     * @param iaIds 需要删除的实习协议信息ID
     * @return 结果
     */
    @Override
    public int deleteImsInternshipAgreementByIds(Long[] iaIds)
    {
        return imsInternshipAgreementMapper.deleteImsInternshipAgreementByIds(iaIds);
    }

    /**
     * 删除实习协议信息信息
     * 
     * @param iaId 实习协议信息ID
     * @return 结果
     */
    @Override
    public int deleteImsInternshipAgreementById(Long iaId)
    {
        return imsInternshipAgreementMapper.deleteImsInternshipAgreementById(iaId);
    }
}
