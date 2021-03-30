package com.ua.controller;

import com.ua.domain.UploadFile;
import com.ua.domain.User;
import com.ua.repos.UploadFileRepository;
import com.ua.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.HttpConstraint;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


@Controller
@PreAuthorize("hasAuthority('STUDENT') or hasAuthority('ADMIN')")
public class StudentController {

    private final static Logger log = LoggerFactory.getLogger(StudentController.class);

    private final StudentService studentService;
    private final UploadFileRepository uploadFileRepository;

    public StudentController(StudentService studentService, UploadFileRepository uploadFileRepository) {
        this.studentService = studentService;
        this.uploadFileRepository = uploadFileRepository;
    }

    @GetMapping("library")
    public String library(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("books", studentService.getAllBook());
        model.addAttribute("voices", studentService.getAllVoice());

        return "library";
    }

    @RequestMapping(value = "/library/voice/get/{voiceId}", method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_OCTET_STREAM_VALUE })
    public ResponseEntity playAudio(HttpServletRequest request,
                                     HttpServletResponse response,
                                    @PathVariable("voiceId") UploadFile uploadFile) throws FileNotFoundException{

        log.debug("[downloadRecipientFile]");

        long length = new File(uploadFile.getPath()).length();


        InputStreamResource inputStreamResource = new InputStreamResource( new FileInputStream(uploadFile.getPath()));
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentLength(length);
        httpHeaders.setCacheControl(CacheControl.noCache().getHeaderValue());
        return new ResponseEntity(inputStreamResource, httpHeaders, HttpStatus.OK);
    }

}