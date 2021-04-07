package com.ua.repos;

import com.ua.domain.Group;
import com.ua.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findGroupByStudentsContains(Student student);
}
