package com.ua.service;

import com.ua.domain.UploadFile;
import com.ua.repos.UploadFileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class UploadFileService {

    @Value("${upload.path}")
    private String uploadPath;
    private final UploadFileRepository uploadFileRepository;

    private final static Logger log = LoggerFactory.getLogger(UploadFileService.class);

    public UploadFileService(UploadFileRepository uploadFileRepository) {
        this.uploadFileRepository = uploadFileRepository;
    }


    public void saveFile(int level, MultipartFile multipartFile, HttpServletRequest request) throws IOException {

        UploadFile uploadFile = new UploadFile();


        String realPath = request.getServletContext().getRealPath(uploadPath);
        File uploadDir = new File(realPath);
        if(!uploadDir.exists()) {
            System.out.println("First conditional is true");
            if(uploadDir.mkdirs()) {
                System.out.println("was created");
            }
        }

        log.info("realPathToUpload = {}", realPath);

        uploadFile.setName(multipartFile.getOriginalFilename());
        uploadFile.setType(multipartFile.getContentType());
        uploadFile.setLevel(level);
        uploadFile.setPath(realPath + uploadFile.getName());

        File fileToStorage = new File(uploadFile.getPath());
        multipartFile.transferTo(fileToStorage);

        uploadFileRepository.save(uploadFile);
    }
}
