package com.ua.service;

import com.ua.domain.Person;
import com.ua.domain.student_models.Group;
import com.ua.domain.student_models.HistoryEducation;
import com.ua.domain.student_models.Student;
import com.ua.repos.HistoryEducationRepository;
import com.ua.repos.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {

    private final Logger log = LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository studentRepository;
    private final GroupService groupService;
    private final HistoryEducationRepository historyEducationRepository;

    public StudentService(StudentRepository studentRepository, GroupService groupService, HistoryEducationRepository historyEducationRepository) {
        this.studentRepository = studentRepository;
        this.groupService = groupService;
        this.historyEducationRepository = historyEducationRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public void setActiveStudent(Person person) {
        Student student = studentRepository.findByPerson(person);
        if (student == null) {
            student = new Student(person, true);
            log.info("Adding a new student");
        } else if (!student.isActive()) {
            student.setActive(true);
            log.info("Set student is active");
        }
        HistoryEducation historyEducation = new HistoryEducation(LocalDate.now(), student.getLevel(), student);
        student.getHistoryEducations().add(historyEducation);
        studentRepository.save(student);
        historyEducationRepository.save(historyEducation);
    }

    public void setNonActiveStudent(Person person) {
        Student student = studentRepository.findByPerson(person);
        if (student != null && student.isActive()) {
            student.setActive(false);
            student.getHistoryEducations().get(student.getHistoryEducations().size()-1)
                    .setEndStudyingDate(LocalDate.now());
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
