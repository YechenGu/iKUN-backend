package com.iKUN.web.controller.ims.task;

import com.iKUN.common.annotation.Log;
import com.iKUN.common.core.controller.BaseController;
import com.iKUN.common.core.domain.AjaxResult;
import com.iKUN.common.core.page.TableDataInfo;
import com.iKUN.common.enums.BusinessType;
import com.iKUN.common.utils.poi.ExcelUtil;
import com.iKUN.task.domain.ImsTaskConfig;
import com.iKUN.task.service.IImsTaskConfigService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 流程配置信息Controller
 * 
 * @author iKUN
 * @date 2022-12-25
 */
@RestController
@RequestMapping("/ims/config")
public class ImsTaskConfigController extends BaseController
{
    @Resource
    private IImsTaskConfigService imsTaskConfigService;

    /**
     * 查询流程配置信息列表
     */
    @GetMapping("/list")
    public TableDataInfo list(ImsTaskConfig imsTaskConfig)
    {
        startPage();
        List<ImsTaskConfig> list = imsTaskConfigService.selectImsTaskConfigList(imsTaskConfig);
        return getDataTable(list);
    }

    /**
     * 导出流程配置信息列表
     */
    @Log(title = "流程配置信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ImsTaskConfig imsTaskConfig)
    {
        List<ImsTaskConfig> list = imsTaskConfigService.selectImsTaskConfigList(imsTaskConfig);
        ExcelUtil<ImsTaskConfig> util = new ExcelUtil<ImsTaskConfig>(ImsTaskConfig.class);
        return util.exportExcel(list, "config");
    }

    /**
     * 获取流程配置信息详细信息
     */
    @GetMapping(value = "/{processId}")
    public AjaxResult getInfo(@PathVariable("processId") String processId)
    {
        return AjaxResult.success(imsTaskConfigService.selectImsTaskConfigById(processId));
    }

    /**
     * 新增流程配置信息
     */
    @Log(title = "流程配置信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ImsTaskConfig imsTaskConfig)
    {
        return toAjax(imsTaskConfigService.insertImsTaskConfig(imsTaskConfig));
    }

    /**
     * 修改流程配置信息
     */
    @Log(title = "流程配置信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ImsTaskConfig imsTaskConfig)
    {
        return toAjax(imsTaskConfigService.updateImsTaskConfig(imsTaskConfig));
    }

    /**
     * 删除流程配置信息
     */
    @Log(title = "流程配置信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{processIds}")
    public AjaxResult remove(@PathVariable String[] processIds)
    {
        return toAjax(imsTaskConfigService.deleteImsTaskConfigByIds(processIds));
    }
}
