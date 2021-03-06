package com.ua.service;

import com.ua.domain.Person;
import com.ua.domain.User;
import com.ua.repos.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person findByUser(User user) {
        return personRepository.findPersonByUser(user);
    }

}
