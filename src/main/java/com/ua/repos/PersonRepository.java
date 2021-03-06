package com.ua.repos;

import com.ua.domain.Person;
import com.ua.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findPersonByUser(User user);
}
