package com.iKUN.web.controller.ims.analysis;

import com.iKUN.analysis.service.ImsThesisAnalysisService;
import com.iKUN.common.core.domain.AjaxResult;
import com.iKUN.common.utils.SecurityUtils;
import com.iKUN.common.utils.StringUtils;
import com.iKUN.system.service.ISysUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author iKUN
 * @Date 2023/1/24 23:34
 * @Description 论文分析
 * @Version 1.0
 */
@RestController
@RequestMapping("/ims/analysis")
public class ImsThesisAnalysisController {

    @Resource
    private ImsThesisAnalysisService thesisAnalysisService;
    @Resource
    private ISysUserService userService;
    /**
     * 实习周记分析统计
     * @param deptId 院系ID
     * @param academicYear 年份
     * @param deptType 机构类型
     * @param topicStatus 论文状态
     * @return
     */
    @GetMapping("/thesis")
    public AjaxResult practiceWeeklyAnalysis(
            @RequestParam(value = "deptId",required = false) Long deptId
            ,@RequestParam(value = "academicYear",required = false) String academicYear
            , @RequestParam(value = "deptType",required = false) String deptType
            , @RequestParam(value = "topicStatus",required = false) String topicStatus){
        if (StringUtils.isEmpty(deptType) && StringUtils.isNull(deptId)){
            deptType = String.valueOf(Long.parseLong(userService.selectUserByUserName(SecurityUtils.getUsername()).getDept().getDeptType())+1);
            deptId = SecurityUtils.getLoginUser().getUser().getDeptId();
        }
        Map<Object, List<?>> map = thesisAnalysisService.calculationThesis(deptId, academicYear, deptType, topicStatus);
        return AjaxResult.success(map);
    }
}
