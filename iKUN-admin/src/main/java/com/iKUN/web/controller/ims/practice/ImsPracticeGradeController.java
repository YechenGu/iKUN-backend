package com.iKUN.web.controller.ims.practice;

import com.iKUN.common.annotation.Log;
import com.iKUN.common.core.controller.BaseController;
import com.iKUN.common.core.domain.AjaxResult;
import com.iKUN.common.core.page.TableDataInfo;
import com.iKUN.common.enums.BusinessType;
import com.iKUN.common.utils.poi.ExcelUtil;
import com.iKUN.practice.domain.ImsPracticeGrade;
import com.iKUN.practice.service.IImsPracticeGradeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 实习成绩信息Controller
 * 
 * @author iKUN
 * @date 2022-12-20
 */
@RestController
@RequestMapping("/practice/grade")
public class ImsPracticeGradeController extends BaseController
{
    @Resource
    private IImsPracticeGradeService imsPracticeGradeService;

    /**
     * 查询实习成绩信息列表
     */
    @GetMapping("/list")
    public TableDataInfo list(ImsPracticeGrade imsPracticeGrade)
    {
        startPage();
        List<ImsPracticeGrade> list = imsPracticeGradeService.selectImsPracticeGradeList(imsPracticeGrade);
        return getDataTable(list);
    }

    /**
     * 导出实习成绩信息列表
     */
    @Log(title = "实习成绩信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ImsPracticeGrade imsPracticeGrade)
    {
        List<ImsPracticeGrade> list = imsPracticeGradeService.selectImsPracticeGradeList(imsPracticeGrade);
        ExcelUtil<ImsPracticeGrade> util = new ExcelUtil<ImsPracticeGrade>(ImsPracticeGrade.class);
        return util.exportExcel(list, "grade");
    }

    /**
     * 获取实习成绩信息详细信息
     */
    @GetMapping(value = "/{gradeId}")
    public AjaxResult getInfo(@PathVariable("gradeId") Long gradeId)
    {
        return AjaxResult.success(imsPracticeGradeService.selectImsPracticeGradeById(gradeId));
    }

    /**
     * 新增实习成绩信息
     */
    @Log(title = "实习成绩信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ImsPracticeGrade imsPracticeGrade)
    {
        return toAjax(imsPracticeGradeService.insertImsPracticeGrade(imsPracticeGrade));
    }

    /**
     * 修改实习成绩信息
     */
    @Log(title = "实习成绩信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ImsPracticeGrade imsPracticeGrade)
    {
        return toAjax(imsPracticeGradeService.updateImsPracticeGrade(imsPracticeGrade));
    }

    /**
     * 删除实习成绩信息
     */
    @Log(title = "实习成绩信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{gradeIds}")
    public AjaxResult remove(@PathVariable Long[] gradeIds)
    {
        return toAjax(imsPracticeGradeService.deleteImsPracticeGradeByIds(gradeIds));
    }
}
