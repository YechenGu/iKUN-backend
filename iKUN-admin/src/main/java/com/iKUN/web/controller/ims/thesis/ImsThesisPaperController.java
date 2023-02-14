package com.iKUN.web.controller.ims.thesis;

import com.iKUN.common.annotation.Log;
import com.iKUN.common.core.controller.BaseController;
import com.iKUN.common.core.domain.AjaxResult;
import com.iKUN.common.core.page.TableDataInfo;
import com.iKUN.common.enums.BusinessType;
import com.iKUN.common.utils.poi.ExcelUtil;
import com.iKUN.thesis.domain.ImsThesisPaper;
import com.iKUN.thesis.service.IImsThesisPaperService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 论文信息Controller
 * 
 * @author iKUN
 * @date 2022-12-18
 */
@RestController
@RequestMapping("/thesis/paper")
public class ImsThesisPaperController extends BaseController
{
    @Resource
    private IImsThesisPaperService imsThesisPaperService;

    /**
     * 查询论文信息列表
     */
    @GetMapping("/list")
    public TableDataInfo list(ImsThesisPaper imsThesisPaper)
    {
        startPage();
        List<ImsThesisPaper> list = imsThesisPaperService.selectImsThesisPaperList(imsThesisPaper);
        return getDataTable(list);
    }

    /**
     * 导出论文信息列表
     */
    @Log(title = "论文信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ImsThesisPaper imsThesisPaper)
    {
        List<ImsThesisPaper> list = imsThesisPaperService.selectImsThesisPaperList(imsThesisPaper);
        ExcelUtil<ImsThesisPaper> util = new ExcelUtil<ImsThesisPaper>(ImsThesisPaper.class);
        return util.exportExcel(list, "paper");
    }

    /**
     * 获取论文信息详细信息
     */
    @GetMapping(value = "/{paperId}")
    public AjaxResult getInfo(@PathVariable("paperId") String paperId)
    {
        return AjaxResult.success(imsThesisPaperService.selectImsThesisPaperById(paperId));
    }

    /**
     * 新增论文信息
     */
    @Log(title = "论文信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ImsThesisPaper imsThesisPaper)
    {
        return toAjax(imsThesisPaperService.insertImsThesisPaper(imsThesisPaper));
    }

    /**
     * 修改论文信息
     */
    @Log(title = "论文信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ImsThesisPaper imsThesisPaper)
    {
        return toAjax(imsThesisPaperService.updateImsThesisPaper(imsThesisPaper));
    }

    /**
     * 删除论文信息
     */
    @Log(title = "论文信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{paperIds}")
    public AjaxResult remove(@PathVariable String[] paperIds)
    {
        return toAjax(imsThesisPaperService.deleteImsThesisPaperByIds(paperIds));
    }
}
