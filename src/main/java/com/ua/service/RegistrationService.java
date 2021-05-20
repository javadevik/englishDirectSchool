package com.ua.service;

import com.ua.domain.Person;
import com.ua.domain.Role;
import com.ua.domain.User;
import com.ua.exception.UserMenageException;
import com.ua.repos.PersonRepository;
import com.ua.repos.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class RegistrationService {

    private final UserRepository userRepository;
    private final PersonRepository personRepository;

    public RegistrationService(UserRepository userRepository, PersonRepository personRepository) {
        this.userRepository = userRepository;
        this.personRepository = personRepository;
    }

    public void save(User user, Person person) throws UserMenageException {
        User userFromDb = userRepository.findUserByUsername(user.getUsername());
        if (userFromDb != null) {
            throw new UserMenageException("User " + user.getUsername() + " is already exists!", user);
        }

        user.setRoles(Collections.singleton(Role.USER));
        user.setActive(true);
        userRepository.save(user);

        person.setUser(userRepository.findUserByUsername(user.getUsername()));
        personRepository.save(person);

    }
}
