package com.iKUN.practice.service.impl;

import com.iKUN.common.core.domain.entity.SysDept;
import com.iKUN.common.core.domain.entity.SysUser;
import com.iKUN.common.utils.DateUtils;
import com.iKUN.common.utils.SecurityUtils;
import com.iKUN.common.utils.StringUtils;
import com.iKUN.common.utils.bean.BeanUtils;
import com.iKUN.commons.ImsConstants;
import com.iKUN.enterprise.domain.ImsEnterpriseInfo;
import com.iKUN.enterprise.mapper.ImsEnterpriseInfoMapper;
import com.iKUN.practice.domain.ImsPractice;
import com.iKUN.practice.domain.vo.ImsInternInstructorVo;
import com.iKUN.practice.mapper.ImsPracticeMapper;
import com.iKUN.practice.service.IImsPracticeService;
import com.iKUN.system.mapper.SysDeptMapper;
import com.iKUN.task.domain.ImsTaskChild;
import com.iKUN.task.domain.vo.ImsTaskUserVo;
import com.iKUN.task.mapper.ImsTaskDeptMapper;
import com.iKUN.task.service.IImsTaskChildService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 实习信息Service业务层处理
 * 
 * @author iKUN
 * @date 2022-11-20
 */
@Service
public class ImsPracticeServiceImpl implements IImsPracticeService
{
    private Logger log = LoggerFactory.getLogger(getClass());
    @Resource
    private IImsTaskChildService taskChildService;
    @Resource
    private ImsPracticeMapper imsPracticeMapper;
    @Resource
    private ImsTaskDeptMapper taskDeptMapper;
    @Resource
    private SysDeptMapper deptMapper;
    @Resource
    private ImsEnterpriseInfoMapper infoMapper;

    /**
     * 查询实习信息
     * 
     * @param practiceId 实习信息ID
     * @return 实习信息
     */
    @Override
    public ImsPractice selectImsPracticeById(Long practiceId)
    {
        return imsPracticeMapper.selectImsPracticeById(practiceId);
    }

    /**
     * 查询实习信息列表
     * 
     * @param imsPractice 实习信息
     * @return 实习信息
     */
    @Override
    public List<ImsPractice> selectImsPracticeList(ImsPractice imsPractice)
    {
        return imsPracticeMapper.selectImsPracticeList(imsPractice);
    }

    /**
     * 查询个人的实习信息列表
     * @param userId 用户ID
     * @return
     */
    @Override
    public List<ImsPractice> selectImsPracticePersonalList(Long userId,String practiceStatus) {
        return imsPracticeMapper.selectImsPracticePersonalList(userId,practiceStatus);
    }

    /**
     * 查询实习指导老师列表
     * @param imsInstructorVo
     * @return
     */
    @Override
    public List<ImsInternInstructorVo> selectInternInstructorList(ImsInternInstructorVo imsInstructorVo) {
        //初始化list
        List<ImsInternInstructorVo> resultList = new ArrayList<ImsInternInstructorVo>();
        //获取的结果
        List<ImsInternInstructorVo> voList = imsPracticeMapper.selectInternInstructorList(imsInstructorVo);
        return getImsInternInstructorVos(resultList, voList);
    }

    /**
     * 导出
     * @param imsInstructorVo
     * @return
     */
    @Override
    public List<ImsInternInstructorVo> exportInternInstructorList(ImsInternInstructorVo imsInstructorVo) {
        //初始化list
        List<ImsInternInstructorVo> resultList = new ArrayList<ImsInternInstructorVo>();
        //获取的结果
        List<ImsInternInstructorVo> voList = imsPracticeMapper.exportInternInstructorList(imsInstructorVo);
        return getImsInternInstructorVos(resultList, voList);
    }

    /**
     *  获取专业名
     * @param resultList 结果list
     * @param voList 查询的list
     * @return
     */
    private List<ImsInternInstructorVo> getImsInternInstructorVos(List<ImsInternInstructorVo> resultList, List<ImsInternInstructorVo> voList) {
        if (null != voList && 0 < voList.size()){
            for (ImsInternInstructorVo vo : voList) {
                Long deptId;
                if (StringUtils.isNotNull(vo.getProfessionName()) && !"0".equals(vo.getProfessionName())){
                    deptId = Long.parseLong(vo.getProfessionName());
                }else {
                    deptId = 100L;
                }
                SysDept dept = deptMapper.selectDeptById(deptId);
                vo.setProfessionName(dept.getDeptName());
                resultList.add(vo);
            }
        }
        return resultList;
    }

    /**
     * 新增实习信息
     * 
     * @param imsPractice 实习信息
     * @return 结果
     */
    @Override
    public int insertImsPractice(ImsPractice imsPractice)
    {
        Long companyId = selectCompanyName(imsPractice);
        if (StringUtils.isNotNull(companyId)){
            imsPractice.setCompanyId(companyId);
        }
        Date date = DateUtils.getNowDate();
        imsPractice.setCreateTime(date);
        imsPractice.setUpdateTime(date);
        //判断是否存在实习单位，如果有，则结束原来的实习单位
        isPractice(imsPractice);

        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long userId = user.getUserId();
        String academicYear = DateUtils.parseDateToStr(DateUtils.YYYY, date);
        ImsTaskUserVo taskUserVo = taskDeptMapper.selectTaskIdByUserId(academicYear, userId);
        imsPractice.setTaskId(taskUserVo.getTaskId());
        int practiceId = imsPracticeMapper.insertImsPractice(imsPractice);
        insertTaskChild(imsPractice);
        return practiceId;
    }

    /**
     * 判断实习公司是否存在，不存在则新增
     * @param imsPractice 实习信息
     * @return companyId
     */
    public Long selectCompanyName(ImsPractice imsPractice){
        Long companyId = null;
        if (StringUtils.isNotEmpty(imsPractice.getCompanyName()) && StringUtils.isNull(imsPractice.getCompanyId())){
            String companyName = imsPractice.getCompanyName();
            ImsEnterpriseInfo info = infoMapper.selectImsEnterpriseInfoByCompanyName(companyName);
            if (StringUtils.isNull(info)){
                ImsEnterpriseInfo enterpriseInfo = new ImsEnterpriseInfo();
                enterpriseInfo.setCompanyName(companyName);
                enterpriseInfo.setDelFlag(ImsConstants.dEL_NO);
                enterpriseInfo.setCreateBy(imsPractice.getCreateBy());
                enterpriseInfo.setCreateTime(DateUtils.getNowDate());
                infoMapper.insertImsEnterpriseInfo(enterpriseInfo);
                companyId = enterpriseInfo.getCompanyId();
            }else {
                companyId = info.getCompanyId();
            }
        }else {
            ImsEnterpriseInfo enterpriseInfo = infoMapper.selectImsEnterpriseInfoById(imsPractice.getCompanyId());
            imsPractice.setCompanyName(enterpriseInfo.getCompanyName());
        }
        return companyId;
    }

    /**
     * 插入子任务
     * @param imsPractice
     */
    public void insertTaskChild(ImsPractice imsPractice){
        String childProcessTypeI00 = ImsConstants.CHILD_PROCESS_TYPE_I00;
        //初始化子任务类型
        String stage = ImsConstants.TASK_STAGE_Y01;
        //插入子任务
        ImsTaskChild imsTaskChild = new ImsTaskChild();
        imsTaskChild.setTaskId(imsPractice.getTaskId());
        imsTaskChild.setUserId(imsPractice.getUserId());
        log.info("用户Id:{}",imsPractice.getUserId());
        imsTaskChild.setProcessType(ImsConstants.TASK_PROCESS_TYPE_1);
        imsTaskChild.setChildProcessType(childProcessTypeI00);
        imsTaskChild.setChildTaskStatus(stage);
        imsTaskChild.setBusinessId(imsPractice.getPracticeId());
        imsTaskChild.setCreateBy(imsPractice.getCreateBy());
        imsTaskChild.setCreateDept(imsPractice.getCreateDept());
        taskChildService.insertImsTaskChild(imsTaskChild);
    }

    /**
     * 修改实习信息
     * 
     * @param imsPractice 实习信息
     * @return 结果
     */
    @Override
    public int updateImsPractice(ImsPractice imsPractice)
    {
        imsPractice.setUpdateTime(DateUtils.getNowDate());
        //当审核状态为1以及实习状态为0--->教师审核
        if (ImsConstants.STATUS_YES.equals(imsPractice.getStatus()) && ImsConstants.PRACTICE_STATUS_0.equals(imsPractice.getPracticeStatus())){
            imsPractice.setPracticeStatus(ImsConstants.PRACTICE_STATUS_1);
        }
        //当审核状态为1以及实习状态为2--->实习结束
        if (ImsConstants.STATUS_YES.equals(imsPractice.getStatus()) && ImsConstants.PRACTICE_STATUS_2.equals(imsPractice.getPracticeStatus())){
            imsPractice.setPracticeStatus(ImsConstants.PRACTICE_STATUS_2);
        }
        return imsPracticeMapper.updateImsPractice(imsPractice);
    }

    /**
     * 批量删除实习信息
     * 
     * @param practiceIds 需要删除的实习信息ID
     * @return 结果
     */
    @Override
    public int deleteImsPracticeByIds(Long[] practiceIds)
    {
        return imsPracticeMapper.deleteImsPracticeByIds(practiceIds);
    }

    /**
     * 删除实习信息信息
     * 
     * @param practiceId 实习信息ID
     * @return 结果
     */
    @Override
    public int deleteImsPracticeById(Long practiceId)
    {
        return imsPracticeMapper.deleteImsPracticeById(practiceId);
    }


    /**
     * 检查用户是否存在实习单位，
     * @param imsPractice
     */
    public void isPractice(ImsPractice imsPractice){
        //如果存在正在实习的单位，将原实习单位状态改为：实习结束
        List<ImsPractice> list = imsPracticeMapper.selectImsPracticePersonalList(imsPractice.getUserId(), ImsConstants.PRACTICE_STATUS_1);
        if (null != list && 0 < list.size()){
            ImsPractice practice1;
            for (ImsPractice practice : list) {
                practice1 = new ImsPractice();
                BeanUtils.copyBeanProp(practice1,practice);
                practice1.setUserId(practice.getUserId());
                practice1.setPracticeStatus(ImsConstants.PRACTICE_STATUS_2);
                imsPracticeMapper.updateImsPractice(practice1);
            }
        }
    }
}
