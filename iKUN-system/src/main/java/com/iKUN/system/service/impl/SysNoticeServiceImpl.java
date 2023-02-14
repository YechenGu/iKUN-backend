package com.iKUN.system.service.impl;

import com.iKUN.common.constant.UserConstants;
import com.iKUN.common.core.domain.entity.SysUser;
import com.iKUN.common.utils.DateUtils;
import com.iKUN.system.domain.SysNotice;
import com.iKUN.system.domain.SysUserNotice;
import com.iKUN.system.mapper.SysNoticeMapper;
import com.iKUN.system.mapper.SysUserMapper;
import com.iKUN.system.mapper.SysUserNoticeMapper;
import com.iKUN.system.service.ISysNoticeService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 公告 服务层实现
 * 
 * @author iKUN
 */
@Service
public class SysNoticeServiceImpl implements ISysNoticeService
{
    @Resource
    private SysNoticeMapper noticeMapper;
    @Resource
    private SysUserNoticeMapper userNoticeMapper;
    @Resource
    private SysUserMapper userMapper;

    /**
     * 查询公告信息
     * 
     * @param noticeId 公告ID
     * @return 公告信息
     */
    @Override
    public SysNotice selectNoticeById(Long noticeId)
    {
        return noticeMapper.selectNoticeById(noticeId);
    }

    /**
     * 查询公告列表
     * 
     * @param notice 公告信息
     * @return 公告集合
     */
    @Override
    public List<SysNotice> selectNoticeList(SysNotice notice)
    {
        return noticeMapper.selectNoticeList(notice);
    }

    /**
     *  查询用户与公告列表
     * @param notice 公告信息
     * @return
     */
    @Override
    public List<SysNotice> selectNoticeIsReadList(SysNotice notice) {
        return noticeMapper.selectNoticeIsReadList(notice);
    }

    /**
     * 新增公告
     * 
     * @param notice 公告信息
     * @return 结果
     */
    @Override
    public void insertNotice(SysNotice notice)
    {
        notice.setCreateTime(DateUtils.getNowDate());
        notice.setUpdateTime(DateUtils.getNowDate());
        noticeMapper.insertNotice(notice);
        asyncInsert(notice);
    }

    /**
     * 异步执行
     * @param notice
     */
    @Async
    public void asyncInsert(SysNotice notice){
        SysUser sysUser = new SysUser();
        sysUser.setDeptId(notice.getDeptId());
        List<SysUser> userList = userMapper.selectUserList(sysUser);
        userList.forEach(user ->{
            SysUserNotice userNotice = new SysUserNotice();
            Long userId = user.getUserId();
            userNotice.setUserId(userId);
            userNotice.setIsRead(UserConstants.IS_READ_NO);
            userNotice.setNoticeId(notice.getNoticeId());
            userNoticeMapper.insertSysUserNotice(userNotice);
        });
    }

    /**
     * 修改公告
     * 
     * @param notice 公告信息
     * @return 结果
     */
    @Override
    public int updateNotice(SysNotice notice)
    {
        notice.setUpdateTime(DateUtils.getNowDate());
        return noticeMapper.updateNotice(notice);
    }

    /**
     * 删除公告对象
     * 
     * @param noticeId 公告ID
     * @return 结果
     */
    @Override
    public int deleteNoticeById(Long noticeId)
    {
        return noticeMapper.deleteNoticeById(noticeId);
    }

    /**
     * 批量删除公告信息
     * 
     * @param noticeIds 需要删除的公告ID
     * @return 结果
     */
    @Override
    public int deleteNoticeByIds(Long[] noticeIds)
    {
        return noticeMapper.deleteNoticeByIds(noticeIds);
    }
}
