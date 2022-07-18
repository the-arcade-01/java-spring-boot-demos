package com.arcade.file_upload.service;

import com.arcade.file_upload.entity.Attachment;
import com.arcade.file_upload.repository.AttachmentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AttachmentService {

    private AttachmentRepo repository;

    @Autowired
    AttachmentService(AttachmentRepo repository) {
        this.repository = repository;
    }

    public Attachment saveAttachment(MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (fileName.contains("..")) {
                throw new Exception("Filename contains invalid path sequence" + fileName);
            }
            Attachment attachment = new Attachment(fileName, file.getContentType(), file.getBytes());
            return repository.save(attachment);
        } catch (Exception e) {
            throw new Exception("Could not save File: " + fileName);
        }
    }

    public Attachment getAttachment(String id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("File not found with Id " + id));
    }
}
