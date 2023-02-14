package com.iKUN.web.controller.ims.task;

import com.iKUN.common.annotation.Log;
import com.iKUN.common.core.controller.BaseController;
import com.iKUN.common.core.domain.AjaxResult;
import com.iKUN.common.core.page.TableDataInfo;
import com.iKUN.common.enums.BusinessType;
import com.iKUN.common.utils.poi.ExcelUtil;
import com.iKUN.task.domain.ImsApprovalDetails;
import com.iKUN.task.service.IImsApprovalDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 审批明细信息Controller
 * 
 * @author iKUN
 * @date 2023-01-11
 */
@RestController
@RequestMapping("/ims/approval")
public class ImsApprovalDetailsController extends BaseController
{
    @Resource
    private IImsApprovalDetailsService imsApprovalDetailsService;

    /**
     * 查询审批明细信息列表
     */
    @GetMapping("/list")
    public TableDataInfo list(ImsApprovalDetails imsApprovalDetails)
    {
        startPage();
        List<ImsApprovalDetails> list = imsApprovalDetailsService.selectImsApprovalDetailsList(imsApprovalDetails);
        return getDataTable(list);
    }

    /**
     * 导出审批明细信息列表
     */
    @Log(title = "审批明细信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ImsApprovalDetails imsApprovalDetails)
    {
        List<ImsApprovalDetails> list = imsApprovalDetailsService.selectImsApprovalDetailsList(imsApprovalDetails);
        ExcelUtil<ImsApprovalDetails> util = new ExcelUtil<ImsApprovalDetails>(ImsApprovalDetails.class);
        return util.exportExcel(list, "approval");
    }

    /**
     * 获取审批明细信息详细信息
     */
    @GetMapping(value = "/{approvalId}")
    public AjaxResult getInfo(@PathVariable("approvalId") Long approvalId)
    {
        return AjaxResult.success(imsApprovalDetailsService.selectImsApprovalDetailsById(approvalId));
    }

    /**
     * 新增审批明细信息
     */
    @Log(title = "审批明细信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ImsApprovalDetails imsApprovalDetails)
    {
        return toAjax(imsApprovalDetailsService.insertImsApprovalDetails(imsApprovalDetails));
    }

    /**
     * 修改审批明细信息
     */
    @Log(title = "审批明细信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ImsApprovalDetails imsApprovalDetails)
    {
        return toAjax(imsApprovalDetailsService.updateImsApprovalDetails(imsApprovalDetails));
    }

    /**
     * 删除审批明细信息
     */
    @Log(title = "审批明细信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{approvalIds}")
    public AjaxResult remove(@PathVariable Long[] approvalIds)
    {
        return toAjax(imsApprovalDetailsService.deleteImsApprovalDetailsByIds(approvalIds));
    }
}
