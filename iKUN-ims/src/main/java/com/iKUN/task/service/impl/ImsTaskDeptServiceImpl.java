package com.iKUN.task.service.impl;

import com.iKUN.common.utils.StringUtils;
import com.iKUN.task.domain.ImsTaskDept;
import com.iKUN.task.domain.vo.ImsTaskLinkVo;
import com.iKUN.task.mapper.ImsTaskDeptMapper;
import com.iKUN.task.service.IImsTaskDeptService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 任务与班级关联信息Service业务层处理
 * 
 * @author iKUN
 * @date 2023-01-05
 */
@Service
public class ImsTaskDeptServiceImpl implements IImsTaskDeptService 
{
    @Resource
    private ImsTaskDeptMapper imsTaskDeptMapper;

    /**
     * 查询任务与班级关联信息
     * 
     * @param taskId 任务与班级关联信息ID
     * @return 任务与班级关联信息
     */
    @Override
    public ImsTaskDept selectImsTaskDeptById(Long taskId,Long userId)
    {
        return imsTaskDeptMapper.selectImsTaskDeptById(taskId,userId);
    }

    /**
     * 查询任务与班级关联信息列表
     * 
     * @param imsTaskDept 任务与班级关联信息
     * @return 任务与班级关联信息
     */
    @Override
    public List<ImsTaskDept> selectImsTaskDeptList(ImsTaskDept imsTaskDept)
    {
        return imsTaskDeptMapper.selectImsTaskDeptList(imsTaskDept);
    }

    /**
     * 新增任务与班级关联信息
     * 
     * @param imsTaskDept 任务与班级关联信息
     * @return 结果
     */
    @Override
    public int insertImsTaskDept(ImsTaskDept imsTaskDept)
    {
        return imsTaskDeptMapper.insertImsTaskDept(imsTaskDept);
    }

    /**
     * 新增任务与班级关联信息
     * @param imsTaskLinkVo
     * @return
     */
    @Async
    @Override
    public void insertImsTaskLinkVo(ImsTaskLinkVo imsTaskLinkVo) {
        ImsTaskDept taskDept = new ImsTaskDept();
        taskDept.setTaskId(imsTaskLinkVo.getTaskId());
        taskDept.setTeaId(imsTaskLinkVo.getUserId());
        taskDept.setDeptId(imsTaskLinkVo.getClassIds().get(imsTaskLinkVo.getClassIds().size() - 1));
        if (StringUtils.isNotNull(imsTaskLinkVo.getStudentIds())) {
            for (Long studentId : imsTaskLinkVo.getStudentIds()) {
                ImsTaskDept imsTaskDept = new ImsTaskDept(taskDept);
                imsTaskDept.setUserId(studentId);
                ImsTaskDept dept = imsTaskDeptMapper.selectImsTaskDeptById(imsTaskLinkVo.getTaskId(), studentId);
                if (null != dept) {
                    dept.setTeaId(imsTaskDept.getUserId());
                    dept.setDeptId(imsTaskDept.getDeptId());
                    dept.setTaskId(imsTaskDept.getTaskId());
                    dept.setUserId(imsTaskDept.getUserId());
                    imsTaskDeptMapper.updateImsTaskDept(dept);
                }else {
                    imsTaskDeptMapper.insertImsTaskDept(imsTaskDept);
                }
            }
        }
    }

    /**
     * 修改任务与班级关联信息
     * 
     * @param imsTaskDept 任务与班级关联信息
     * @return 结果
     */
    @Override
    public int updateImsTaskDept(ImsTaskDept imsTaskDept)
    {
        return imsTaskDeptMapper.updateImsTaskDept(imsTaskDept);
    }

    /**
     * 批量删除任务与班级关联信息
     * 
     * @param taskIds 需要删除的任务与班级关联信息ID
     * @return 结果
     */
    @Override
    public int deleteImsTaskDeptByIds(Long[] taskIds)
    {
        return imsTaskDeptMapper.deleteImsTaskDeptByIds(taskIds);
    }

    /**
     * 删除任务与班级关联信息信息
     * 
     * @param taskId 任务与班级关联信息ID
     * @return 结果
     */
    @Override
    public int deleteImsTaskDeptById(Long taskId)
    {
        return imsTaskDeptMapper.deleteImsTaskDeptById(taskId);
    }
}
