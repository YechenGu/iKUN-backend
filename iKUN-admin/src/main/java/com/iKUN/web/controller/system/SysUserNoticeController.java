package com.iKUN.web.controller.system;

import com.iKUN.common.annotation.Log;
import com.iKUN.common.core.controller.BaseController;
import com.iKUN.common.core.domain.AjaxResult;
import com.iKUN.common.core.page.TableDataInfo;
import com.iKUN.common.enums.BusinessType;
import com.iKUN.common.utils.poi.ExcelUtil;
import com.iKUN.system.domain.SysUserNotice;
import com.iKUN.system.service.ISysUserNoticeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户与公告关联信息Controller
 * 
 * @author iKUN
 * @date 2022-12-31
 */
@RestController
@RequestMapping("/system/userNotice")
public class SysUserNoticeController extends BaseController
{
    @Resource
    private ISysUserNoticeService sysUserNoticeService;

    /**
     * 查询用户与公告关联信息列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SysUserNotice sysUserNotice)
    {
        startPage();
        List<SysUserNotice> list = sysUserNoticeService.selectSysUserNoticeList(sysUserNotice);
        return getDataTable(list);
    }

    /**
     * 导出用户与公告关联信息列表
     */
    @Log(title = "用户与公告关联信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysUserNotice sysUserNotice)
    {
        List<SysUserNotice> list = sysUserNoticeService.selectSysUserNoticeList(sysUserNotice);
        ExcelUtil<SysUserNotice> util = new ExcelUtil<SysUserNotice>(SysUserNotice.class);
        return util.exportExcel(list, "userNotice");
    }

    /**
     * 获取用户与公告关联信息详细信息
     */
    @GetMapping(value = "/{userId}")
    public AjaxResult getInfo(@PathVariable("userId") Long userId)
    {
        return AjaxResult.success(sysUserNoticeService.selectSysUserNoticeById(userId));
    }

    /**
     * 新增用户与公告关联信息
     */
    @Log(title = "用户与公告关联信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysUserNotice sysUserNotice)
    {
        return toAjax(sysUserNoticeService.insertSysUserNotice(sysUserNotice));
    }

    /**
     * 修改用户与公告关联信息
     */
    @Log(title = "用户与公告关联信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysUserNotice sysUserNotice)
    {
        return toAjax(sysUserNoticeService.updateSysUserNotice(sysUserNotice));
    }

    /**
     * 删除用户与公告关联信息
     */
    @Log(title = "用户与公告关联信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{userIds}")
    public AjaxResult remove(@PathVariable Long[] userIds)
    {
        return toAjax(sysUserNoticeService.deleteSysUserNoticeByIds(userIds));
    }
}
