package com.ua.domain.student_models;

import javax.persistence.*;
import java.sql.Date;

//@Entity
//@Table(name = "schedule")
public class Schedule<T> {
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private T obj;

    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
