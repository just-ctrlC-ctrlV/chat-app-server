package com.grpchat.webServer.repository;

import com.grpchat.webServer.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileUploadRepository extends JpaRepository<FileEntity, Long> {}

