package com.grpchat.webServer.repository;

import com.grpchat.webServer.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<FileEntity, Long> {
    List<FileEntity> findByFileId(String fileId);
}

