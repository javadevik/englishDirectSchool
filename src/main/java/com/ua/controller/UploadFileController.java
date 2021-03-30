package com.ua.controller;

import com.ua.domain.UploadFile;
import com.ua.repos.UploadFileRepository;
import com.ua.service.UploadFileService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.HttpConstraint;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class UploadFileController {

    private final UploadFileService uploadFileService;
    private final UploadFileRepository uploadFileRepository;

    public UploadFileController(UploadFileService uploadFileService, UploadFileRepository uploadFileRepository) {
        this.uploadFileService = uploadFileService;
        this.uploadFileRepository = uploadFileRepository;
    }

    @PostMapping("/uploadFile")
    public String loadFile(
            @RequestParam("files")MultipartFile[] files,
            @RequestParam int level,
            @HttpConstraint HttpServletRequest request,
            Model model) throws IOException {

        if(files.length != 0) {
            for(MultipartFile multipartFile : files) {
                if (!uploadFileRepository.existsUploadFileByNameAndType(multipartFile.getOriginalFilename(),
                        multipartFile.getContentType())) {
                    uploadFileService.saveFile(level, multipartFile, request);
                }
            }
            return "redirect:/library";
        }
        return "redirect:/main";
    }
}
