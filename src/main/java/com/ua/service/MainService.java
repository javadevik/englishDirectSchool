package com.ua.service;

import com.ua.domain.Person;
import com.ua.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MainService {
    
    private final Logger log = LoggerFactory.getLogger(MainService.class);

    private final PersonService personService;

    public MainService(PersonService personService) {
        this.personService = personService;
    }


    public Person getPersonByUser(User user) {
        return personService.findByUser(user);
    }

}
