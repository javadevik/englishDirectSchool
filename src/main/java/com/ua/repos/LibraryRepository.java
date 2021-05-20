package com.ua.repos;

import com.ua.domain.UploadFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryRepository extends JpaRepository<UploadFile, Long> {
    List<UploadFile> findAllByType(String type);
    List<UploadFile> findAllByTypeAndLevel(String type, int level);
    boolean existsUploadFileByNameAndType(String name, String type);
}
