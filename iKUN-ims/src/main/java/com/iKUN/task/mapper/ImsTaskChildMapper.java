package com.iKUN.task.mapper;

import com.iKUN.task.domain.ImsTaskChild;
import com.iKUN.task.domain.vo.practiceVo.ImsChildPracticeVo;
import com.iKUN.task.domain.vo.practiceVo.ImsPracticeApplicationVo;

import java.util.List;

/**
 * 子任务信息Mapper接口
 * 
 * @author iKUN
 * @date 2022-12-25
 */
public interface ImsTaskChildMapper 
{
    /**
     * 查询子任务信息
     * 
     * @param childId 子任务信息ID
     * @return 子任务信息
     */
    public ImsTaskChild selectImsTaskChildById(Long childId);

    /**
     * 查询子任务信息
     * @return ImsTaskChild
     */
    public ImsTaskChild selectImsTaskChildByIds(ImsTaskChild imsTaskChild);

    /**
     * 查询子任务信息列表
     * 
     * @param imsTaskChild 子任务信息
     * @return 子任务信息集合
     */
    public List<ImsTaskChild> selectImsTaskChildList(ImsTaskChild imsTaskChild);

    /**
     * 查询实习周记、总结子任务信息列表
     *
     * @param imsChildPracticeVo 子任务信息
     * @return 子任务信息集合
     */
    public List<ImsChildPracticeVo> selectChildPracticeList(ImsChildPracticeVo imsChildPracticeVo);

    /**
     * 查询实习申请待办列表
     * @param vo
     * @return
     */
    public List<ImsPracticeApplicationVo> selectPracticeApplicationList(ImsPracticeApplicationVo vo);

    /**
     * 新增子任务信息
     * 
     * @param imsTaskChild 子任务信息
     * @return 结果
     */
    public int insertImsTaskChild(ImsTaskChild imsTaskChild);

    /**
     * 修改子任务信息
     * 
     * @param imsTaskChild 子任务信息
     * @return 结果
     */
    public int updateImsTaskChild(ImsTaskChild imsTaskChild);

    /**
     * 删除子任务信息
     * 
     * @param childId 子任务信息ID
     * @return 结果
     */
    public int deleteImsTaskChildById(Long childId);

    /**
     * 批量删除子任务信息
     * 
     * @param childIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteImsTaskChildByIds(Long[] childIds);
}
