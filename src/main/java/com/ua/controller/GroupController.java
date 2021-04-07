package com.ua.controller;

import com.ua.domain.Group;
import com.ua.domain.Student;
import com.ua.service.GroupService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class GroupController {

    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/group")
    public String groups(Model model) {
        model.addAttribute("groups", groupService.findAll());
        return "";
    }

    @PostMapping("/group")
    public String createGroup(Group group, Model model) {
        return "";
    }

    @PostMapping("/group/add")
    public String addToGroup(@Validated Group group, List<Student> students, Model model) {
        groupService.addToGroup(group, students);
        model.addAttribute("groups", groupService.findAll());
        return "";
    }
}
