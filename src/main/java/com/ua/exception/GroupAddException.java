package com.ua.exception;

import com.ua.domain.student_models.Student;

public class GroupAddException extends Exception{

    private String nameGroup;
    private Student student;

    public GroupAddException(String message, String nameGroup) {
        super(message);
        this.nameGroup = nameGroup;
    }

    public GroupAddException(String message, String nameGroup, Student student) {
        super(message);
        this.nameGroup = nameGroup;
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public String getNameGroup() {
        return nameGroup;
    }
}
