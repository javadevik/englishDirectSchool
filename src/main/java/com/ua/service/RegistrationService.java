package com.ua.service;

import com.ua.domain.Role;
import com.ua.domain.User;
import com.ua.repos.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Collections;

@Service
public class RegistrationService {
    private final UserRepository userRepository;

    public RegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String save(User user, Model model) {
        User userFromDb = userRepository.findUserByUsername(user.getUsername());
        if(userFromDb != null) {
            model.addAttribute("message", "User is exists");
            return "/registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
        return "redirect:/";
    }
}
