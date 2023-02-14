package com.iKUN.file.mapper;

import com.iKUN.file.domain.ImsFileInfo;

import java.util.List;

/**
 * 文件信息Mapper接口
 * 
 * @author iKUN
 * @date 2022-12-08
 */
public interface ImsFileInfoMapper 
{
    /**
     * 查询文件信息
     * 
     * @param fileId 文件信息ID
     * @return 文件信息
     */
    public ImsFileInfo selectImsFileInfoById(String fileId);

    /**
     * 查询文件信息列表
     * 
     * @param imsFileInfo 文件信息
     * @return 文件信息集合
     */
    public List<ImsFileInfo> selectImsFileInfoList(ImsFileInfo imsFileInfo);

    /**
     * 新增文件信息
     * 
     * @param imsFileInfo 文件信息
     * @return 结果
     */
    public int insertImsFileInfo(ImsFileInfo imsFileInfo);

    /**
     * 删除文件信息
     * 
     * @param fileId 文件信息ID
     * @return 结果
     */
    public int deleteImsFileInfoById(String fileId);

    /**
     * 批量删除文件信息
     * 
     * @param fileIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteImsFileInfoByIds(String[] fileIds);
}
