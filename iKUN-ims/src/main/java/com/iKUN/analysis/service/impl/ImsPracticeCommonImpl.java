package com.iKUN.analysis.service.impl;

import com.iKUN.analysis.service.ImsPracticeCommonService;
import com.iKUN.common.core.domain.entity.SysUser;
import com.iKUN.system.mapper.SysUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author iKUN
 * @Date 2023/1/2 10:22
 * @Description 实习统计分析公用Impl
 * @Version 1.0
 */
@Service
public class ImsPracticeCommonImpl implements ImsPracticeCommonService {

    @Resource
    private SysUserMapper userMapper;
    /**
     * 统计未实习人数
     * @param deptId 院系ID
     * @param alreadyCount 已经完成
     * @param endCount 已经结束
     * @return
     */
    @Override
    public Long calculationNo(Long deptId, Long alreadyCount, Long endCount) {
        SysUser user = new SysUser();
        user.setDeptId(deptId);
        user.setRoleId(100L);
        //院系总人数
        Long resultCount;
        long count = userMapper.selectUserList(user).size();
        resultCount = count - alreadyCount - endCount;
        if (resultCount < 0){
            resultCount = 0L;
        }
        return resultCount;
    }

    /**
     * 创建plate 数据
     * @param list1 数据1
     * @param list2 数据2
     * @param list3 数据3
     * @param title 数据标题
     * @return
     */
    @Override
    public List<Map<String, Object>> calculationPlate(List<Long> list1, List<Long> list2, List<Long> list3, List<Object> title) {
        //返回结果 plate
        List<Map<String,Object>> sumList = new ArrayList<>();
        //实习结束总数
        Map<String, Object> sumMap1 = new HashMap<>();
        long listSum1 = list1.stream().mapToLong(Long::longValue).sum();
        sumMap1.put("title",title.get(0));
        sumMap1.put("count",listSum1);
        sumList.add(sumMap1);
        //实习中人数总数
        Map<String, Object> sumMap2 = new HashMap<>();
        long listSum2 = list2.stream().mapToLong(Long::longValue).sum();
        sumMap2.put("title",title.get(1));
        sumMap2.put("count",listSum2);
        sumList.add(sumMap2);
        //未实习总数
        Map<String, Object> sumMap3 = new HashMap<>();
        long listSum3 = list3.stream().mapToLong(Long::longValue).sum();
        sumMap3.put("title",title.get(2));
        sumMap3.put("count",listSum3);
        sumList.add(sumMap3);
        return sumList;
    }
}
