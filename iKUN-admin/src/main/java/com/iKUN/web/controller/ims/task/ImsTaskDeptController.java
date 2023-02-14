package com.iKUN.web.controller.ims.task;

import com.iKUN.common.annotation.Log;
import com.iKUN.common.core.controller.BaseController;
import com.iKUN.common.core.domain.AjaxResult;
import com.iKUN.common.core.page.TableDataInfo;
import com.iKUN.common.enums.BusinessType;
import com.iKUN.common.utils.poi.ExcelUtil;
import com.iKUN.task.domain.ImsTaskDept;
import com.iKUN.task.domain.vo.ImsTaskLinkVo;
import com.iKUN.task.service.IImsTaskDeptService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author iKUN
 * @Date 2023/1/8 17:36
 * @Description TODO
 * @Version 1.0
 */
@RestController
@RequestMapping("/ims/assignment")
public class ImsTaskDeptController extends BaseController {

    @Resource
    private IImsTaskDeptService taskDeptService;

    /**
     * 查询任务与班级用户关联信息列表
     */
    @GetMapping("/list")
    public TableDataInfo list(ImsTaskDept imsTaskDept) {
        startPage();
        List<ImsTaskDept> list = taskDeptService.selectImsTaskDeptList(imsTaskDept);
        return getDataTable(list);
    }

    /**
     * 导出任务与班级用户关联信息列表
     */
    @Log(title = "任务与班级用户关联信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ImsTaskDept imsTaskDept)
    {
        List<ImsTaskDept> list = taskDeptService.selectImsTaskDeptList(imsTaskDept);
        ExcelUtil<ImsTaskDept> util = new ExcelUtil<ImsTaskDept>(ImsTaskDept.class);
        return util.exportExcel(list, "assignment");
    }

    /**
     * 获取任务与班级用户关联信息详细信息
     */
    @GetMapping(value = "/{taskId}/{userId}")
    public AjaxResult getInfo(@PathVariable("taskId") Long taskId,@PathVariable("userId")Long userId)
    {
        return AjaxResult.success(taskDeptService.selectImsTaskDeptById(taskId,userId));
    }

    /**
     * 新增任务分配信息
     */
    @Log(title = "流程配置信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ImsTaskLinkVo imsTaskLinkVo){
        taskDeptService.insertImsTaskLinkVo(imsTaskLinkVo);
        return AjaxResult.success();
    }

    /**
     * 修改任务与班级用户关联信息
     */
    @Log(title = "任务与班级用户关联信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ImsTaskDept imsTaskDept)
    {
        return toAjax(taskDeptService.updateImsTaskDept(imsTaskDept));
    }

    /**
     * 删除任务与班级用户关联信息
     */
    @Log(title = "任务与班级用户关联信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{taskIds}")
    public AjaxResult remove(@PathVariable Long[] taskIds)
    {
        return toAjax(taskDeptService.deleteImsTaskDeptByIds(taskIds));
    }
}
