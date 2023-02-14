package com.iKUN.file.service;

import com.iKUN.file.domain.File;
import com.iKUN.file.domain.ImsFileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 文件信息Service接口
 * 
 * @author iKUN
 * @date 2022-12-08
 */
public interface IImsFileInfoService 
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
     * 上传文件信息
     * @param fileName
     * @param filePath
     * @param file
     * @return
     */
    public ImsFileInfo insertImsFileInfo(String fileName, String filePath, MultipartFile file,String createDept) throws IOException;

    /**
     * 根据文件存储标识，获取文件基本信息以及文件本身
     *
     * @param fileId 文件Id
     * @return {@link File} 文件信息以及本身
     */
    public File getFile(String fileId);

    /**
     * 根据文件存储标识，获取文件基本信息以及文件本身
     *
     * @param fileInfo 文件文件信息
     * @return {@link File} 文件信息以及本身
     */
    public File getFileInfo(ImsFileInfo fileInfo);

    /**
     * 批量删除文件信息
     * 
     * @param fileIds 需要删除的文件信息ID
     * @return 结果
     */
    public int deleteImsFileInfoByIds(String[] fileIds);

    /**
     * 删除文件信息信息
     * 
     * @param fileId 文件信息ID
     * @return 结果
     */
    public int deleteImsFileInfoById(String fileId);
}
