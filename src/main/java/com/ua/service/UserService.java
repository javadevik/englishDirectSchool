package com.ua.service;

import com.ua.domain.Role;
import com.ua.domain.User;
import com.ua.repos.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    private final static Logger log = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final PersonService personService;
    private final StudentService studentService;

    public UserService(UserRepository userRepository, PersonService personService, StudentService studentService) {
        this.userRepository = userRepository;
        this.personService = personService;
        this.studentService = studentService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(username);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void saveUser(User user, String username, Map<String, String> form) {

        user.setUsername(username);
        user.getRoles().clear();
        Set<String> roles = Arrays.stream(Role.values()).map(Role::name).collect(Collectors.toSet());
        for(String key : form.keySet()) {
            if(roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userRepository.save(user);

        if (user.getRoles().contains(Role.STUDENT)) {
            log.info("Trying to set active");
            studentService.setActiveStudent(personService.findByUser(user));
        } else {
            log.info("Trying to set non active");
            studentService.setNonActiveStudent(personService.findByUser(user));
        }
    }
}
