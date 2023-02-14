package com.iKUN.file.service.impl;

import com.iKUN.common.exception.BaseException;
import com.iKUN.common.utils.DateUtils;
import com.iKUN.common.utils.SecurityUtils;
import com.iKUN.common.utils.file.FileUploadUtils;
import com.iKUN.common.utils.uuid.IdUtils;
import com.iKUN.commons.ImsConstants;
import com.iKUN.file.domain.File;
import com.iKUN.file.domain.ImsFileInfo;
import com.iKUN.file.mapper.ImsFileInfoMapper;
import com.iKUN.file.service.FileService;
import com.iKUN.file.service.IImsFileInfoService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * 文件信息Service业务层处理
 * 
 * @author iKUN
 * @date 2022-12-08
 */
@Service
public class ImsFileInfoServiceImpl implements IImsFileInfoService 
{
    @Resource
    private ImsFileInfoMapper imsFileInfoMapper;

    @Resource
    private FileService fileService;
    /**
     * 通过文件ID查询文件信息
     * 
     * @param fileId 文件信息ID
     * @return 文件信息
     */
    @Override
    public ImsFileInfo selectImsFileInfoById(String fileId)
    {
        return imsFileInfoMapper.selectImsFileInfoById(fileId);
    }


    /**
     * 获取原文件
     * @param fileInfo 文件信息
     * @return
     */
    public File getFileInfo(ImsFileInfo fileInfo) {
        if (fileInfo == null) {
            throw new BaseException("没有找到文件源信息: " + fileInfo.getFileId());
        }
        File file = new File();
        file.setFileId(fileInfo.getFileId());
        file.setFileName(fileInfo.getFileName());
        file.setFileType(fileInfo.getFileType());
        file.setFileContent(fileService.loadAsResource(fileInfo));
        return file;
    }

    /**
     * 通过文件ID获取文件信息
     * @param fileId 文件Id
     * @return
     */
    public File getFile(String fileId){
        ImsFileInfo fileInfo = imsFileInfoMapper.selectImsFileInfoById(fileId);
        if (fileInfo == null) {
            throw new BaseException("没有找到文件源信息: " + fileId);
        }
        return getFileInfo(fileInfo);
    }

    /**
     * 查询文件信息列表
     * 
     * @param imsFileInfo 文件信息
     * @return 文件信息
     */
    @Override
    public List<ImsFileInfo> selectImsFileInfoList(ImsFileInfo imsFileInfo)
    {
        return imsFileInfoMapper.selectImsFileInfoList(imsFileInfo);
    }

    /**
     * 上传文件信息
     * @param fileName
     * @param filePath
     * @param file
     * @return
     */
    @Override
    public ImsFileInfo insertImsFileInfo(String fileName, String filePath, MultipartFile file,String createDept) throws IOException {
        ImsFileInfo fileInfo = new ImsFileInfo();
        fileInfo.setFileId(IdUtils.simpleUUID());
        fileInfo.setFileName(fileName);
        fileInfo.setFileType(FileUploadUtils.getExtension(file));
        fileInfo.setFileSize(file.getSize());
        fileInfo.setDelFlag(ImsConstants.dEL_NO);
        fileInfo.setFilePath(filePath);
        fileInfo.setCreateTime(DateUtils.getNowDate());
        fileInfo.setCreateDept(createDept);
        fileInfo.setCreateBy(SecurityUtils.getUsername());
        imsFileInfoMapper.insertImsFileInfo(fileInfo);
        return fileInfo;
    }

    /**
     * 批量删除文件信息
     * 
     * @param fileIds 需要删除的文件信息ID
     * @return 结果
     */
    @Override
    public int deleteImsFileInfoByIds(String[] fileIds)
    {
        return imsFileInfoMapper.deleteImsFileInfoByIds(fileIds);
    }

    /**
     * 删除文件信息信息
     * 
     * @param fileId 文件信息ID
     * @return 结果
     */
    @Override
    public int deleteImsFileInfoById(String fileId)
    {
        return imsFileInfoMapper.deleteImsFileInfoById(fileId);
    }
}
