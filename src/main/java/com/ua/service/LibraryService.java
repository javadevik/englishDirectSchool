package com.ua.service;

import com.ua.domain.UploadFile;
import com.ua.domain.User;
import com.ua.exception.FileExistsException;
import com.ua.repos.LibraryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
public class LibraryService {

    private final Logger log = LoggerFactory.getLogger(LibraryService.class);

    @Value("${upload.path}")
    private String uploadPath;

    private final LibraryRepository libraryRepository;

    public static final String AUDIO_TYPE = "audio/mpeg";
    public static final String BOOK_TYPE = "application/pdf";

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public List<UploadFile> getAllBook() {
        return libraryRepository.findAllByType(BOOK_TYPE);
    }

    public List<UploadFile> getAllVoice() {
        return libraryRepository.findAllByType(AUDIO_TYPE);
    }

    public void saveFile(User user, int level, MultipartFile multipartFile, HttpServletRequest request)
            throws IOException, FileExistsException {

        if (libraryRepository.existsUploadFileByNameAndType(multipartFile.getOriginalFilename(),
                multipartFile.getContentType())) {
            throw new FileExistsException("File is exists", multipartFile.getOriginalFilename());
        }

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

        uploadFile.setUploadDate(LocalDate.now());
        uploadFile.setUser(user);

        File fileToStorage = new File(uploadFile.getPath());
        multipartFile.transferTo(fileToStorage);

        libraryRepository.save(uploadFile);
    }
}
