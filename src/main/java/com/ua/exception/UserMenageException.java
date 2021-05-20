package com.ua.exception;

import com.ua.domain.User;

public class UserMenageException extends Exception{

    User user;

    public UserMenageException(String message, User user) {
        super(message);
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
