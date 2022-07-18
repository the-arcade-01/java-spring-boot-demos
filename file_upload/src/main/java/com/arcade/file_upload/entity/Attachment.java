package com.arcade.file_upload.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Attachment {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String fileName;
    private String fileType;

    @Lob
    private byte[] data;

    public Attachment() {
    }

    public Attachment(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return this.fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Attachment id(String id) {
        setId(id);
        return this;
    }

    public Attachment fileName(String fileName) {
        setFileName(fileName);
        return this;
    }

    public Attachment fileType(String fileType) {
        setFileType(fileType);
        return this;
    }

    public Attachment data(byte[] data) {
        setData(data);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Attachment)) {
            return false;
        }
        Attachment attachment = (Attachment) o;
        return Objects.equals(id, attachment.id) && Objects.equals(fileName, attachment.fileName)
                && Objects.equals(fileType, attachment.fileType) && Objects.equals(data, attachment.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fileName, fileType, data);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", fileName='" + getFileName() + "'" +
                ", fileType='" + getFileType() + "'" +
                ", data='" + getData() + "'" +
                "}";
    }
}
