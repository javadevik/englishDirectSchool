package com.ua.domain.student_models;

import com.ua.domain.Person;
import com.ua.domain.User;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    private Integer level;

    private boolean active;

    public Student() {
    }

    public Student(User user, Person person, boolean active) {
        this.user = user;
        this.person = person;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (active != student.active) return false;
        if (!id.equals(student.id)) return false;
        if (!user.equals(student.user)) return false;
        if (!person.equals(student.person)) return false;
        if (group != null ? !group.equals(student.group) : student.group != null) return false;
        return level != null ? level.equals(student.level) : student.level == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + user.hashCode();
        result = 31 * result + person.hashCode();
        result = 31 * result + (group != null ? group.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (active ? 1 : 0);
        return result;
    }
}
