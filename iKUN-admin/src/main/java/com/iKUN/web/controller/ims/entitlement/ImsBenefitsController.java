package com.iKUN.web.controller.ims.entitlement;

import com.iKUN.common.annotation.Log;
import com.iKUN.common.core.controller.BaseController;
import com.iKUN.common.core.domain.AjaxResult;
import com.iKUN.common.core.domain.entity.SysUser;
import com.iKUN.common.core.page.TableDataInfo;
import com.iKUN.common.enums.BusinessType;
import com.iKUN.common.utils.SecurityUtils;
import com.iKUN.common.utils.poi.ExcelUtil;
import com.iKUN.entitlement.domain.ImsBenefits;
import com.iKUN.entitlement.service.IImsBenefitsService;
import com.iKUN.system.service.ISysUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 工资待遇信息Controller
 * 
 * @author iKUN
 * @date 2022-12-05
 */
@RestController
@RequestMapping("/ims/benefits")
public class ImsBenefitsController extends BaseController
{
    @Resource
    private IImsBenefitsService imsBenefitsService;

    @Resource
    private ISysUserService sysUserService;

    /**
     * 查询工资待遇信息列表
     */
    @GetMapping("/list")
    public TableDataInfo list(ImsBenefits imsBenefits)
    {
        startPage();
        List<ImsBenefits> list = imsBenefitsService.selectImsBenefitsList(imsBenefits);
        return getDataTable(list);
    }

    /**
     * 导出工资待遇信息列表
     */
    @Log(title = "工资待遇信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ImsBenefits imsBenefits)
    {
        List<ImsBenefits> list = imsBenefitsService.selectImsBenefitsList(imsBenefits);
        ExcelUtil<ImsBenefits> util = new ExcelUtil<ImsBenefits>(ImsBenefits.class);
        return util.exportExcel(list, "benefits");
    }

    /**
     * 获取工资待遇信息详细信息
     */
    @GetMapping(value = "/{benefitsId}")
    public AjaxResult getInfo(@PathVariable("benefitsId") Long benefitsId)
    {
        return AjaxResult.success(imsBenefitsService.selectImsBenefitsById(benefitsId));
    }

    /**
     * 新增工资待遇信息
     */
    @Log(title = "工资待遇信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ImsBenefits imsBenefits)
    {
        SysUser sysUser = sysUserService.selectUserByUserName(SecurityUtils.getUsername());
        imsBenefits.setCreateDept(sysUser.getDept().getDeptName());
        imsBenefits.setCreateBy(sysUser.getUserName());
        return toAjax(imsBenefitsService.insertImsBenefits(imsBenefits));
    }

    /**
     * 修改工资待遇信息
     */
    @Log(title = "工资待遇信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ImsBenefits imsBenefits)
    {
        return toAjax(imsBenefitsService.updateImsBenefits(imsBenefits));
    }

    /**
     * 删除工资待遇信息
     */
    @Log(title = "工资待遇信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{benefitsIds}")
    public AjaxResult remove(@PathVariable Long[] benefitsIds)
    {
        return toAjax(imsBenefitsService.deleteImsBenefitsByIds(benefitsIds));
    }
}
