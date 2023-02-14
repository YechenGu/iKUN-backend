package com.iKUN.entitlement.service.impl;

import com.iKUN.entitlement.domain.ImsBenefits;
import com.iKUN.entitlement.mapper.ImsBenefitsMapper;
import com.iKUN.entitlement.service.IImsBenefitsService;
import com.iKUN.common.utils.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 工资待遇信息Service业务层处理
 * 
 * @author iKUN
 * @date 2022-12-05
 */
@Service
public class ImsBenefitsServiceImpl implements IImsBenefitsService
{
    @Resource
    private ImsBenefitsMapper imsBenefitsMapper;

    /**
     * 查询工资待遇信息
     * 
     * @param benefitsId 工资待遇信息ID
     * @return 工资待遇信息
     */
    @Override
    public ImsBenefits selectImsBenefitsById(Long benefitsId)
    {
        return imsBenefitsMapper.selectImsBenefitsById(benefitsId);
    }

    /**
     * 查询工资待遇信息列表
     * 
     * @param imsBenefits 工资待遇信息
     * @return 工资待遇信息
     */
    @Override
    public List<ImsBenefits> selectImsBenefitsList(ImsBenefits imsBenefits)
    {
        return imsBenefitsMapper.selectImsBenefitsList(imsBenefits);
    }

    /**
     * 新增工资待遇信息
     * 
     * @param imsBenefits 工资待遇信息
     * @return 结果
     */
    @Override
    public int insertImsBenefits(ImsBenefits imsBenefits)
    {
        imsBenefits.setCreateTime(DateUtils.getNowDate());
        imsBenefits.setUpdateTime(DateUtils.getNowDate());
        return imsBenefitsMapper.insertImsBenefits(imsBenefits);
    }

    /**
     * 修改工资待遇信息
     * 
     * @param imsBenefits 工资待遇信息
     * @return 结果
     */
    @Override
    public int updateImsBenefits(ImsBenefits imsBenefits)
    {
        imsBenefits.setUpdateTime(DateUtils.getNowDate());
        return imsBenefitsMapper.updateImsBenefits(imsBenefits);
    }

    /**
     * 批量删除工资待遇信息
     * 
     * @param benefitsIds 需要删除的工资待遇信息ID
     * @return 结果
     */
    @Override
    public int deleteImsBenefitsByIds(Long[] benefitsIds)
    {
        return imsBenefitsMapper.deleteImsBenefitsByIds(benefitsIds);
    }

    /**
     * 删除工资待遇信息信息
     * 
     * @param benefitsId 工资待遇信息ID
     * @return 结果
     */
    @Override
    public int deleteImsBenefitsById(Long benefitsId)
    {
        return imsBenefitsMapper.deleteImsBenefitsById(benefitsId);
    }
}
