package com.ua.repos;

import com.ua.domain.Person;
import com.ua.domain.student_models.Student;
import com.ua.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByUser(User user);
    Student findByPerson(Person person);
    boolean existsByUser(User user);
}
