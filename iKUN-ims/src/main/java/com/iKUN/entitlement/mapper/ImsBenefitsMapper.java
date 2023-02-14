package com.iKUN.entitlement.mapper;

import com.iKUN.entitlement.domain.ImsBenefits;

import java.util.List;

/**
 * 工资待遇信息Mapper接口
 * 
 * @author iKUN
 * @date 2022-12-05
 */
public interface ImsBenefitsMapper 
{
    /**
     * 查询工资待遇信息
     * 
     * @param benefitsId 工资待遇信息ID
     * @return 工资待遇信息
     */
    public ImsBenefits selectImsBenefitsById(Long benefitsId);

    /**
     * 查询工资待遇信息列表
     * 
     * @param imsBenefits 工资待遇信息
     * @return 工资待遇信息集合
     */
    public List<ImsBenefits> selectImsBenefitsList(ImsBenefits imsBenefits);

    /**
     * 新增工资待遇信息
     * 
     * @param imsBenefits 工资待遇信息
     * @return 结果
     */
    public int insertImsBenefits(ImsBenefits imsBenefits);

    /**
     * 修改工资待遇信息
     * 
     * @param imsBenefits 工资待遇信息
     * @return 结果
     */
    public int updateImsBenefits(ImsBenefits imsBenefits);

    /**
     * 删除工资待遇信息
     * 
     * @param benefitsId 工资待遇信息ID
     * @return 结果
     */
    public int deleteImsBenefitsById(Long benefitsId);

    /**
     * 批量删除工资待遇信息
     * 
     * @param benefitsIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteImsBenefitsByIds(Long[] benefitsIds);
}
