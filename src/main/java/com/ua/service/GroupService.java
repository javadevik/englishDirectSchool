package com.ua.service;

import com.ua.domain.student_models.Group;
import com.ua.domain.student_models.Student;
import com.ua.exception.GroupAddException;
import com.ua.repos.GroupRepository;
import com.ua.repos.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class GroupService {

    private final static Logger log = LoggerFactory.getLogger(GroupService.class);

    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;

    public GroupService(GroupRepository groupRepository, StudentRepository studentRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
    }

    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public void addToGroup(String nameGroup, Student student) throws GroupAddException {
        if (student == null || !student.isActive())
            throw new GroupAddException("Attempt add to group empty value", nameGroup);
        Group group = groupRepository.findByName(nameGroup);
        if (group == null) {
            Group newGroup = new Group(nameGroup, Collections.singleton(student));
            //newGroup.setName(nameGroup);
            groupRepository.save(newGroup);

            student.setGroup(groupRepository.findByName(newGroup.getName()));
            studentRepository.save(student);
            log.info("Creating a group with students [" + log.getClass() + "]");
        } else {
            if (group.getStudents().contains(student))
                throw new GroupAddException("Student is already exists", nameGroup, student);
            group.getStudents().add(student);
            groupRepository.save(group);
            student.setGroup(groupRepository.findByName(group.getName()));
            studentRepository.save(student);
            log.info("Adding to group [" + log.getClass() + "]");
        }

    }

    public void removeStudentFromGroup(Group group, Student student) {
        group.getStudents().remove(student);
        if (group.getStudents().isEmpty()) {
            groupRepository.delete(group);
            log.info("Deleting group because of it's empty [" + log.getClass() + "]");
        } else {
            groupRepository.save(group);
        }
    }

}
