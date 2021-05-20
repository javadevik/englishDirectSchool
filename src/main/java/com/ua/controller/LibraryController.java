package com.ua.controller;

import com.ua.domain.UploadFile;
import com.ua.domain.User;
import com.ua.exception.FileExistsException;
import com.ua.service.LibraryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.HttpConstraint;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
public class LibraryController {

    private final Logger log = LoggerFactory.getLogger(LibraryController.class);

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }


    @GetMapping("/library")
    public String library(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("books", libraryService.getAllBook());
        model.addAttribute("voices", libraryService.getAllVoice());

        return "library";
    }

    @RequestMapping(value = "/library/file/get/{fileId}", method = RequestMethod.GET,
            produces = {"application/pdf", MediaType.APPLICATION_OCTET_STREAM_VALUE})
    public ResponseEntity<InputStreamResource> playAudio(@PathVariable("fileId") UploadFile uploadFile) throws FileNotFoundException {

        log.info("[downloadRecipientFile] = {}", uploadFile.toString());

        long length = new File(uploadFile.getPath()).length();


        InputStreamResource inputStreamResource = new InputStreamResource( new FileInputStream(uploadFile.getPath()));
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentLength(length);
        httpHeaders.setCacheControl(CacheControl.noCache().getHeaderValue());
        return new ResponseEntity<>(inputStreamResource, httpHeaders, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/uploadFile")
    public String loadFile(@RequestParam("files") MultipartFile[] files, @RequestParam int level,
            @HttpConstraint HttpServletRequest request, Model model) throws IOException {

        if(files.length != 0) {
            for(MultipartFile multipartFile : files) {
                try {
                    libraryService.saveFile(level, multipartFile, request);
                } catch (FileExistsException e) {
                    model.addAttribute("messages", e.getMessage() + e.getFilename());
                }
            }
            return "redirect:/library";
        }
        return "redirect:/main";
    }
}
