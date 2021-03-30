package com.ua.controller;

import com.ua.domain.Role;
import com.ua.domain.User;
import com.ua.repos.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

    private final UserRepository userRepository;

    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/")
    public String greeting() {
        return "greeting";
    }

    @GetMapping("/{user}")
    public String greeting(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Model model) {
        return "main";
    }
}
