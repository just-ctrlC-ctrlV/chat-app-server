package com.grpchat.webServer.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grpchat.webServer.entity.FileEntity;
import com.grpchat.webServer.model.FileModel;
import com.grpchat.webServer.repository.FileUploadRepository;
import org.springframework.stereotype.Service;

@Service
public class FileUploadService {
    private final FileUploadRepository fileUploadRepository;
    private final ObjectMapper objectMapper;

    public FileUploadService(FileUploadRepository fileUploadRepository, ObjectMapper objectMapper) {
        this.fileUploadRepository = fileUploadRepository;
        this.objectMapper = objectMapper;
    }

    public void saveFile(FileModel file){
        fileUploadRepository.save(objectMapper.convertValue(file, FileEntity.class));
    }
}
