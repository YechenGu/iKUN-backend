package com.iKUN.system.mapper;

import com.iKUN.system.domain.SysUserNotice;

import java.util.List;

/**
 * 用户与公告关联信息Mapper接口
 * 
 * @author iKUN
 * @date 2022-12-31
 */
public interface SysUserNoticeMapper 
{
    /**
     * 查询用户与公告关联信息
     * 
     * @param userId 用户与公告关联信息ID
     * @return 用户与公告关联信息
     */
    public SysUserNotice selectSysUserNoticeById(Long userId);

    /**
     * 查询用户与公告关联信息列表
     * 
     * @param sysUserNotice 用户与公告关联信息
     * @return 用户与公告关联信息集合
     */
    public List<SysUserNotice> selectSysUserNoticeList(SysUserNotice sysUserNotice);

    /**
     * 新增用户与公告关联信息
     * 
     * @param sysUserNotice 用户与公告关联信息
     * @return 结果
     */
    public int insertSysUserNotice(SysUserNotice sysUserNotice);

    /**
     * 修改用户与公告关联信息
     * 
     * @param sysUserNotice 用户与公告关联信息
     * @return 结果
     */
    public int updateSysUserNotice(SysUserNotice sysUserNotice);

    /**
     * 删除用户与公告关联信息
     * 
     * @param userId 用户与公告关联信息ID
     * @return 结果
     */
    public int deleteSysUserNoticeById(Long userId);

    /**
     * 批量删除用户与公告关联信息
     * 
     * @param userIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysUserNoticeByIds(Long[] userIds);
}
