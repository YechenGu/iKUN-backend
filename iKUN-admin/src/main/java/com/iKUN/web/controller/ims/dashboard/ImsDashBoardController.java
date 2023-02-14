package com.iKUN.web.controller.ims.dashboard;

import com.iKUN.analysis.domain.ImsPracticeWeeklyStatisticsVo;
import com.iKUN.analysis.domain.ImsThesisStatisticsVo;
import com.iKUN.common.core.controller.BaseController;
import com.iKUN.common.core.domain.AjaxResult;
import com.iKUN.common.utils.SecurityUtils;
import com.iKUN.dashboard.domain.ImsDashBoardNoticeVo;
import com.iKUN.dashboard.domain.ImsDashBoardTaskVo;
import com.iKUN.dashboard.service.ImsDashBoardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author iKUN
 * @Date 2023/1/25 15:43
 * @Description 首页plate
 * @Version 1.0
 */
@RestController
@RequestMapping("/dashBoard")
public class ImsDashBoardController extends BaseController {

    @Resource
    private ImsDashBoardService dashBoardService;

    /**
     *首页实习plate数据
     * @return
     */
    @GetMapping("/plate")
    public AjaxResult getPracticePlate(){
        List<List<?>> lists = dashBoardService.selectPracticeWeeklyStatisticsListInDashBoard(new ImsPracticeWeeklyStatisticsVo());
        return AjaxResult.success(lists);
    }

    /**
     *首页实习plate数据
     * @return
     */
    @GetMapping("/thesis/plate")
    public AjaxResult getThesisPlate(){
        List<List<?>> lists = dashBoardService.selectThesisStatisticsListInDashBoard(new ImsThesisStatisticsVo());
        return AjaxResult.success(lists);
    }



    /**
     *首页--我的任务
     * @return
     */
    @GetMapping("/task/mine")
    public AjaxResult getTaskInfo(){
        ImsDashBoardTaskVo vo = new ImsDashBoardTaskVo();
        Long userId = SecurityUtils.getLoginUser().getUser().getUserId();
        vo.setUserId(userId);
        List<ImsDashBoardTaskVo> list = dashBoardService.selectTaskInfoByUserId(vo);
        return AjaxResult.success(list);
    }

    /**
     * 最新动态
     * @return
     */
    @GetMapping("/notice/mine")
    public AjaxResult getNoticeInfo(){
        Long userId = SecurityUtils.getLoginUser().getUser().getUserId();
        List<ImsDashBoardNoticeVo> list = dashBoardService.selectNoticeInfoByUserId(userId);
        return AjaxResult.success(list);
    }
}
