package com.ua.controller;

import com.ua.domain.Person;
import com.ua.domain.User;
import com.ua.exception.UserMenageException;
import com.ua.service.RegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private final Logger log = LoggerFactory.getLogger(RegistrationController.class);

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@Validated User user, @Validated Person person, Model model) {
        try {
            registrationService.save(user, person);
        } catch (UserMenageException e) {
            log.error(e.getMessage());
            log.error(e.getUser().toString());
            model.addAttribute("message", e.getMessage());
            return "registration";
        }
        return "redirect:/";
    }
}
