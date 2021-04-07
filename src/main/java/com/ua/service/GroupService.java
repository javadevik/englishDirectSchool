package com.ua.service;

import com.ua.domain.Group;
import com.ua.domain.Student;
import com.ua.repos.GroupRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class GroupService {

    private final GroupRepository groupRepository;
    private final static Logger log = LoggerFactory.getLogger(GroupService.class);

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public void createGroup(Group group, String name, Set<Student> students) {
        group.setName(name);
        group.setStudents(students);
        groupRepository.save(group);
        log.info(group.getName() + " created");
    }

    public void addToGroup(Group group, List<Student> students) {
        log.info("Start add to group process");
        for (Student student: students) {
            if (!group.getStudents().contains(student)) {
                group.getStudents().add(student);
                log.info(student.getPerson().toString() + " added to group " + group.getName());
            }
        }
        groupRepository.save(group);
    }
}
