package com.ua.service;

import com.ua.domain.UploadFile;
import com.ua.repos.UploadFileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final UploadFileRepository uploadFileRepository;

    public StudentService(UploadFileRepository uploadFileRepository) {
        this.uploadFileRepository = uploadFileRepository;
    }

    public List<UploadFile> getAllBook() {
        return uploadFileRepository.findAll();
    }

    public List<UploadFile> getAllVoice() {
        return uploadFileRepository.findAll();
    }
}
