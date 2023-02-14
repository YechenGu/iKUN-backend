package com.iKUN.web.controller.ims.enterprise;

import com.iKUN.common.annotation.Log;
import com.iKUN.common.core.controller.BaseController;
import com.iKUN.common.core.domain.AjaxResult;
import com.iKUN.common.core.domain.entity.SysUser;
import com.iKUN.common.core.page.TableDataInfo;
import com.iKUN.common.enums.BusinessType;
import com.iKUN.common.utils.SecurityUtils;
import com.iKUN.common.utils.poi.ExcelUtil;
import com.iKUN.enterprise.domain.ImsEnterpriseInfo;
import com.iKUN.enterprise.service.IImsEnterpriseInfoService;
import com.iKUN.system.service.ISysUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 企业信息Controller
 * 
 * @author iKUN
 * @date 2022-11-17
 */
@RestController
@RequestMapping("/ims/info")
public class ImsEnterpriseInfoController extends BaseController
{
    @Resource
    private IImsEnterpriseInfoService imsEnterpriseInfoService;

    @Resource
    private ISysUserService iSysUserService;

    /**
     * 查询企业信息列表
     */
    @GetMapping("/list")
    public TableDataInfo list(ImsEnterpriseInfo imsEnterpriseInfo)
    {
        startPage();
        List<ImsEnterpriseInfo> list = imsEnterpriseInfoService.selectImsEnterpriseInfoList(imsEnterpriseInfo);
        return getDataTable(list);
    }
    /**
     * 查询企业信息列表
     */
    @GetMapping("/company/list")
    public TableDataInfo CompanyList(ImsEnterpriseInfo imsEnterpriseInfo)
    {
        List<ImsEnterpriseInfo> list = imsEnterpriseInfoService.selectImsEnterpriseCompanyInfoList(imsEnterpriseInfo);
        return getDataTable(list);
    }

    /**
     * 导出企业信息列表
     */
    @Log(title = "企业信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ImsEnterpriseInfo imsEnterpriseInfo)
    {
        List<ImsEnterpriseInfo> list = imsEnterpriseInfoService.selectImsEnterpriseInfoList(imsEnterpriseInfo);
        ExcelUtil<ImsEnterpriseInfo> util = new ExcelUtil<ImsEnterpriseInfo>(ImsEnterpriseInfo.class);
        return util.exportExcel(list, "info");
    }

    /**
     * 获取企业信息详细信息
     */
    @GetMapping(value = "/{companyId}")
    public AjaxResult getInfo(@PathVariable("companyId") Long companyId)
    {
        return AjaxResult.success(imsEnterpriseInfoService.selectImsEnterpriseInfoById(companyId));
    }

    /**
     * 新增企业信息
     */
    @Log(title = "企业信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ImsEnterpriseInfo imsEnterpriseInfo)
    {
        SysUser user = iSysUserService.selectUserByUserName(SecurityUtils.getUsername());
        imsEnterpriseInfo.setCreateDept(user.getDept().getDeptName());
        imsEnterpriseInfo.setCreateBy(user.getUserName());
        return toAjax(imsEnterpriseInfoService.insertImsEnterpriseInfo(imsEnterpriseInfo));
    }

    /**
     * 修改企业信息
     */
    @Log(title = "企业信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ImsEnterpriseInfo imsEnterpriseInfo)
    {
        imsEnterpriseInfo.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(imsEnterpriseInfoService.updateImsEnterpriseInfo(imsEnterpriseInfo));
    }

    /**
     * 删除企业信息
     */
    @Log(title = "企业信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{companyIds}")
    public AjaxResult remove(@PathVariable Long[] companyIds)
    {
        return toAjax(imsEnterpriseInfoService.deleteImsEnterpriseInfoByIds(companyIds));
    }
}
