package com.iKUN.system.domain;

import com.iKUN.common.annotation.Excel;
import com.iKUN.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 用户与公告关联信息对象 sys_user_notice
 * 
 * @author iKUN
 * @date 2022-12-31
 */
public class SysUserNotice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    private Long userId;

    /** 公告ID */
    private Long noticeId;

    /**公告类型 */
    private String noticeType;
    /** 是否已读 */
    @Excel(name = "是否已读")
    private String isRead;

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setNoticeId(Long noticeId) 
    {
        this.noticeId = noticeId;
    }

    public Long getNoticeId() 
    {
        return noticeId;
    }

    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }

    public void setIsRead(String isRead)
    {
        this.isRead = isRead;
    }

    public String getIsRead() 
    {
        return isRead;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("noticeId", getNoticeId())
            .append("noticeType", getNoticeType())
            .append("isRead", getIsRead())
            .toString();
    }
}
