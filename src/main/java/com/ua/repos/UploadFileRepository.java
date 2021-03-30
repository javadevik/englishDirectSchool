package com.ua.repos;

import com.ua.domain.UploadFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UploadFileRepository extends JpaRepository<UploadFile, Long> {
    List<UploadFile> findAllByType(String type);
    UploadFile findByName(String name);
    boolean existsUploadFileByNameAndType(String name, String type);
}
