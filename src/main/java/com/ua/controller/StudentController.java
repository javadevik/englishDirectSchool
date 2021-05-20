package com.ua.controller;

import com.ua.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;


@Controller
@PreAuthorize("hasAuthority('STUDENT') or hasAuthority('ADMIN')")
public class StudentController {

    private final static Logger log = LoggerFactory.getLogger(StudentController.class);

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }



}