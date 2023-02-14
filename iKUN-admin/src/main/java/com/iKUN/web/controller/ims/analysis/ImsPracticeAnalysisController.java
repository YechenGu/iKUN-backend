package com.iKUN.web.controller.ims.analysis;

import com.iKUN.analysis.service.ImsPracticeAnalysisService;
import com.iKUN.analysis.service.ImsPracticeWareAnalysisService;
import com.iKUN.analysis.service.ImsPracticeWeeklyAnalysisService;
import com.iKUN.common.core.controller.BaseController;
import com.iKUN.common.core.domain.AjaxResult;
import com.iKUN.common.utils.SecurityUtils;
import com.iKUN.common.utils.StringUtils;
import com.iKUN.commons.ImsConstants;
import com.iKUN.system.service.ISysUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author iKUN
 * @Date 2023/1/22 17:20
 * @Description 实习分析统计
 * @Version 1.0
 */
@RestController
@RequestMapping("/ims/analysis")
public class ImsPracticeAnalysisController extends BaseController {
    @Resource
    private ImsPracticeAnalysisService analysisService;
    @Resource
    private ISysUserService userService;
    @Resource
    private ImsPracticeWeeklyAnalysisService weeklyAnalysisService;
    @Resource
    private ImsPracticeWareAnalysisService wareAnalysisService;

    /**
     * 实习人数分析统计
     * @param deptId 院系ID
     * @param academicYear 年份
     * @return map
     */
    @GetMapping("/practice")
    public AjaxResult practiceAnalysis(@RequestParam(value = "deptId",required = false) Long deptId,@RequestParam(value = "academicYear",required = false) String academicYear, @RequestParam(value = "deptType",required = false) String deptType){
        if (StringUtils.isEmpty(deptType) && StringUtils.isNull(deptId)){
            deptType = String.valueOf(Long.parseLong(userService.selectUserByUserName(SecurityUtils.getUsername()).getDept().getDeptType())+1);
            deptId = SecurityUtils.getLoginUser().getUser().getDeptId();
        }
        Map<Object, List<?>> map = analysisService.calculationPractice(deptId, academicYear, deptType);
        return AjaxResult.success(map);
    }

    /**
     * 实习周记分析统计
     * @param deptId 院系ID
     * @param academicYear 年份
     * @param deptType 机构类型
     * @param week 周次
     * @return
     */
    @GetMapping("/practice/weekly")
    public AjaxResult practiceWeeklyAnalysis(
             @RequestParam(value = "deptId",required = false) Long deptId
            ,@RequestParam(value = "academicYear",required = false) String academicYear
            , @RequestParam(value = "deptType",required = false) String deptType
            , @RequestParam(value = "week",required = false) String week){
        if (StringUtils.isEmpty(deptType) && StringUtils.isNull(deptId)){
            deptType = String.valueOf(Long.parseLong(userService.selectUserByUserName(SecurityUtils.getUsername()).getDept().getDeptType())+1);
            deptId = SecurityUtils.getLoginUser().getUser().getDeptId();
        }
        Map<Object, List<?>> map = weeklyAnalysisService.calculationPracticeWeekly(deptId, academicYear, deptType,week);
        return AjaxResult.success(map);
    }


    /**
     * 实习总结分析统计
     * @param deptId  院系ID
     * @param academicYear  年份
     * @param deptType  院系类型
     * @return map
     */
    @GetMapping("/practice/summary")
    public AjaxResult practiceSummaryAnalysis(
            @RequestParam(value = "deptId",required = false) Long deptId
            ,@RequestParam(value = "academicYear",required = false) String academicYear
            , @RequestParam(value = "deptType",required = false) String deptType
            ){
        if (StringUtils.isEmpty(deptType) && StringUtils.isNull(deptId)){
            deptType = String.valueOf(Long.parseLong(userService.selectUserByUserName(SecurityUtils.getUsername()).getDept().getDeptType())+1);
            deptId = SecurityUtils.getLoginUser().getUser().getDeptId();
        }
        String week = ImsConstants.ASSESSMENT_TYPE_1_SUMMARY;
        Map<Object, List<?>> map = weeklyAnalysisService.calculationPracticeWeekly(deptId, academicYear, deptType,week);
        return AjaxResult.success(map);
    }

    /**
     * 实习工资分析统计
     * @param deptId 院系ID
     * @param academicYear 年份
     * @return map
     */
    @GetMapping("/practice/ware")
    public AjaxResult practiceWareAnalysis(@RequestParam(value = "deptId",required = false) Long deptId,@RequestParam(value = "academicYear",required = false) String academicYear, @RequestParam(value = "deptType",required = false) String deptType){
        if (StringUtils.isEmpty(deptType) && StringUtils.isNull(deptId)){
            deptType = String.valueOf(Long.parseLong(userService.selectUserByUserName(SecurityUtils.getUsername()).getDept().getDeptType())+1);
            deptId = SecurityUtils.getLoginUser().getUser().getDeptId();
        }
        Map<Object, List<?>> map = wareAnalysisService.calculationWarePractice(deptId, academicYear, deptType);
        return AjaxResult.success(map);
    }
}
