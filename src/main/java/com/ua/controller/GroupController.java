package com.ua.controller;

import com.ua.domain.student_models.Student;
import com.ua.exception.GroupAddException;
import com.ua.service.GroupService;
import com.ua.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GroupController {

    private final Logger log = LoggerFactory.getLogger(GroupController.class);

    private final GroupService groupService;
    private final StudentService studentService;

    public GroupController(GroupService groupService, StudentService studentService) {
        this.groupService = groupService;
        this.studentService = studentService;
    }

    @GetMapping("/group")
    public String groups(Model model) {
        model.addAttribute("groups", groupService.findAll());
        model.addAttribute("students", studentService.findAll());
        return "group";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/group")
    public String addToGroup(String name, @RequestParam("studentId") Student student, Model model) {
        try {
            groupService.addToGroup(name,student);
        } catch (GroupAddException e) {
            log.error(e.getMessage() + ": " + e.getNameGroup() + " [" + log.getClass() + "]");
            model.addAttribute("message", e.getMessage());
        }
        model.addAttribute("groups", groupService.findAll());
        model.addAttribute("students", studentService.findAll());
        return "group";
    }



}
