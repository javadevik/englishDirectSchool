package com.ua.service;

import com.ua.domain.student_models.Group;
import com.ua.domain.student_models.Student;
import com.ua.domain.User;
import com.ua.repos.PersonRepository;
import com.ua.repos.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final Logger log = LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository studentRepository;
    private final GroupService groupService;
    private final PersonRepository personRepository;

    public StudentService(StudentRepository studentRepository, GroupService groupService, PersonRepository personRepository) {
        this.studentRepository = studentRepository;
        this.groupService = groupService;
        this.personRepository = personRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public void setActiveStudent(User user) {
        Student student = studentRepository.findByUser(user);
        if (student == null) {
            Student newStudent = new Student(user, personRepository.findPersonByUser(user), true);
            log.info("Adding a new student");
            studentRepository.save(newStudent);
        } else if (!student.isActive()) {
            student.setActive(true);
            log.info("Set student is active");
            studentRepository.save(student);
        }
    }

    public void setNonActiveStudent(User user) {
        Student student = studentRepository.findByUser(user);
        if (student != null && student.isActive()) {
            student.setActive(false);
            if (student.getGroup() != null) {
                Group group = student.getGroup();
                student.setGroup(null);
                studentRepository.save(student);
                log.info("Making a student " + student.toString() + " of non active");
                groupService.removeStudentFromGroup(group, student);
            } else {
                studentRepository.save(student);
            }
        }
    }
}
