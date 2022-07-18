package com.arcade.file_upload;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData {
    private String fileName;
    private String downloadUrl;
    private String fileType;
    private Long fileSize;

    public ResponseData() {
    }

    public ResponseData(String fileName, String downloadUrl, String fileType, Long fileSize) {
        this.fileName = fileName;
        this.downloadUrl = downloadUrl;
        this.fileType = fileType;
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getFileType() {
        return this.fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Long getFileSize() {
        return this.fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public ResponseData fileName(String fileName) {
        setFileName(fileName);
        return this;
    }

    public ResponseData downloadUrl(String downloadUrl) {
        setDownloadUrl(downloadUrl);
        return this;
    }

    public ResponseData fileType(String fileType) {
        setFileType(fileType);
        return this;
    }

    public ResponseData fileSize(Long fileSize) {
        setFileSize(fileSize);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ResponseData)) {
            return false;
        }
        ResponseData responseData = (ResponseData) o;
        return Objects.equals(fileName, responseData.fileName) && Objects.equals(downloadUrl, responseData.downloadUrl) && Objects.equals(fileType, responseData.fileType) && Objects.equals(fileSize, responseData.fileSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileName, downloadUrl, fileType, fileSize);
    }

    @Override
    public String toString() {
        return "{" +
            " fileName='" + getFileName() + "'" +
            ", downloadUrl='" + getDownloadUrl() + "'" +
            ", fileType='" + getFileType() + "'" +
            ", fileSize='" + getFileSize() + "'" +
            "}";
    }

}
