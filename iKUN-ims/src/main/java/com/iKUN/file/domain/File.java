package com.iKUN.file.domain;

import org.springframework.core.io.Resource;

/**
 * 文件信息，用于获取文件信息以及文件本身，对应下载和预览功能
 *
 * @author iKUN
 * @date 2022-12-08
 */
public class File {
    /**
     * 文件唯一标识
     */
    private String fileId;
    /**
     * 文件名
     */
    private String fileName;
    /**
     * 文件类型
     */
    private String fileType;
    /**
     * 文件内容
     */
    private Resource fileContent;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Resource getFileContent() {
        return fileContent;
    }

    public void setFileContent(Resource fileContent) {
        this.fileContent = fileContent;
    }
}
