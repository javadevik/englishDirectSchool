package com.ua.service;

import com.ua.domain.Role;
import com.ua.domain.Student;
import com.ua.domain.User;
import com.ua.repos.StudentRepository;
import com.ua.repos.UserRepository;
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
    private final UserRepository userRepository;
    private final StudentRepository studentRepository;

    public UserService(UserRepository userRepository, StudentRepository studentRepository) {
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(username);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void saveUser(User user, String username, Map<String, String> form) {
        Student student = new Student();
        user.setUsername(username);
        user.getRoles().clear();
        Set<String> roles = Arrays.stream(Role.values()).map(Role::name).collect(Collectors.toSet());
        for(String key : form.keySet()) {
            if(roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }
        if (user.getRoles().contains(Role.STUDENT)) {
            if (!studentRepository.existsByUser(user)) {
                student.setUser(user);
                studentRepository.save(student);
            }
        } else if (studentRepository.existsByUser(user)){
            studentRepository.delete(studentRepository.findByUser(user));
        }
        userRepository.save(user);
    }
}
