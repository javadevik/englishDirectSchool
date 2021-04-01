package com.ua.repos;

import com.ua.domain.Student;
import com.ua.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByUser(User user);
    boolean existsByUser(User user);
}