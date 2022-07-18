package com.arcade.file_upload.repository;

import com.arcade.file_upload.entity.Attachment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepo extends JpaRepository<Attachment, String> {

}