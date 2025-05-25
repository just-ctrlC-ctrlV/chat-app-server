package com.grpchat.webServer.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grpchat.webServer.entity.FileEntity;
import com.grpchat.webServer.model.FileModel;
import com.grpchat.webServer.repository.FileRepository;
import org.springframework.stereotype.Service;

@Service
public class FileService {
    private final FileRepository fileRepository;
    private final ObjectMapper objectMapper;

    public FileService(FileRepository fileRepository, ObjectMapper objectMapper) {
        this.fileRepository = fileRepository;
        this.objectMapper = objectMapper;
    }

    public void saveFile(FileModel file){
        fileRepository.save(objectMapper.convertValue(file, FileEntity.class));
    }
    public FileModel getFileById(String fileId){
        return objectMapper.convertValue(fileRepository.findByFileId(fileId).getFirst(), FileModel.class);
    }
}
