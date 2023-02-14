package com.iKUN.web.controller.ims.thesis;

import com.iKUN.common.annotation.Log;
import com.iKUN.common.core.controller.BaseController;
import com.iKUN.common.core.domain.AjaxResult;
import com.iKUN.common.core.page.TableDataInfo;
import com.iKUN.common.enums.BusinessType;
import com.iKUN.common.utils.poi.ExcelUtil;
import com.iKUN.thesis.domain.ImsThesisReport;
import com.iKUN.thesis.service.IImsThesisReportService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 开题报告信息Controller
 * 
 * @author iKUN
 * @date 2022-12-18
 */
@RestController
@RequestMapping("/thesis/report")
public class ImsThesisReportController extends BaseController
{
    @Resource
    private IImsThesisReportService imsThesisReportService;

    /**
     * 查询开题报告信息列表
     */
    @GetMapping("/list")
    public TableDataInfo list(ImsThesisReport imsThesisReport)
    {
        startPage();
        List<ImsThesisReport> list = imsThesisReportService.selectImsThesisReportList(imsThesisReport);
        return getDataTable(list);
    }

    /**
     * 导出开题报告信息列表
     */
    @Log(title = "开题报告信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ImsThesisReport imsThesisReport)
    {
        List<ImsThesisReport> list = imsThesisReportService.selectImsThesisReportList(imsThesisReport);
        ExcelUtil<ImsThesisReport> util = new ExcelUtil<ImsThesisReport>(ImsThesisReport.class);
        return util.exportExcel(list, "report");
    }

    /**
     * 获取开题报告信息详细信息
     */
    @GetMapping(value = "/{reportId}")
    public AjaxResult getInfo(@PathVariable("reportId") Long reportId)
    {
        return AjaxResult.success(imsThesisReportService.selectImsThesisReportById(reportId));
    }

    /**
     * 新增开题报告信息
     */
    @Log(title = "开题报告信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ImsThesisReport imsThesisReport)
    {
        return toAjax(imsThesisReportService.insertImsThesisReport(imsThesisReport));
    }

    /**
     * 修改开题报告信息
     */
    @Log(title = "开题报告信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ImsThesisReport imsThesisReport)
    {
        return toAjax(imsThesisReportService.updateImsThesisReport(imsThesisReport));
    }

    /**
     * 删除开题报告信息
     */
    @Log(title = "开题报告信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{reportIds}")
    public AjaxResult remove(@PathVariable Long[] reportIds)
    {
        return toAjax(imsThesisReportService.deleteImsThesisReportByIds(reportIds));
    }
}
