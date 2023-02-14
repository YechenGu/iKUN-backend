package com.iKUN.task.mapper;

import com.iKUN.task.domain.ImsTaskDept;
import com.iKUN.task.domain.vo.ImsTaskUserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 任务与班级关联信息Mapper接口
 * 
 * @author iKUN
 * @date 2023-01-05
 */
public interface ImsTaskDeptMapper 
{
    /**
     * 查询任务与班级关联信息
     * 
     * @param taskId 任务与班级关联信息ID
     * @return 任务与班级关联信息
     */
    public ImsTaskDept selectImsTaskDeptById(@Param("taskId") Long taskId,@Param("userId") Long userId);

    /**
     * 查询任务与班级关联信息列表
     * 
     * @param imsTaskDept 任务与班级关联信息
     * @return 任务与班级关联信息集合
     */
    public List<ImsTaskDept> selectImsTaskDeptList(ImsTaskDept imsTaskDept);

    /**
     * 查询用户对应的任务是否存在
     * @param academicYear
     * @param userId
     * @return
     */
    public ImsTaskUserVo selectTaskIdByUserId(@Param("academicYear") String academicYear,@Param("userId") Long userId);

    /**
     * 新增任务与班级关联信息
     * 
     * @param imsTaskDept 任务与班级关联信息
     * @return 结果
     */
    public int insertImsTaskDept(ImsTaskDept imsTaskDept);

    /**
     * 修改任务与班级关联信息
     * 
     * @param imsTaskDept 任务与班级关联信息
     * @return 结果
     */
    public int updateImsTaskDept(ImsTaskDept imsTaskDept);

    /**
     * 删除任务与班级关联信息
     * 
     * @param taskId 任务与班级关联信息ID
     * @return 结果
     */
    public int deleteImsTaskDeptById(Long taskId);

    /**
     * 批量删除任务与班级关联信息
     * 
     * @param taskIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteImsTaskDeptByIds(Long[] taskIds);
}
