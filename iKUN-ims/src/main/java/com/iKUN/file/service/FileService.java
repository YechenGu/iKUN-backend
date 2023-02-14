package com.iKUN.file.service;

import com.iKUN.file.domain.ImsFileInfo;
import org.springframework.core.io.Resource;

import java.nio.file.Path;

public interface FileService {
    /**
     * 根据文件信息获取文件
     * @param imsFileInfo
     * @return
     */
    Resource loadAsResource(ImsFileInfo imsFileInfo);

    /**
     * 根据文件名获取存储文件路径
     *
     * @param imsFileInfo 文件信息
     * @return
     */
    Path load(ImsFileInfo imsFileInfo);
}
