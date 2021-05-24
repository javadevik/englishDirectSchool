package com.ua.domain.student_models;

import com.ua.domain.Person;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany (mappedBy = "student", fetch=FetchType.LAZY)
    private List<HistoryEducation> historyEducations = new LinkedList<>();

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    private Integer level = 1;

    private boolean active;

    public Student() {
    }

    public Student(Person person, boolean active) {
        this.person = person;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<HistoryEducation> getHistoryEducations() {
        return historyEducations;
    }

    public void setHistoryEducations(List<HistoryEducation> historyEducations) {
        this.historyEducations = historyEducations;
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
    public String toString() {
        return "Student{" +
                "person=" + person +
                ", group=" + group +
                ", level=" + level +
                '}';
    }
}
