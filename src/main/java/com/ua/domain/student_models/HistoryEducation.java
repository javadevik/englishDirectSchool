package com.ua.domain.student_models;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "history_edu")
public class HistoryEducation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private LocalDate startStudyingDate;
    private int startLevel;
    private LocalDate endStudyingDate;
    private int endLevel;

    public HistoryEducation() {

    }

    public HistoryEducation(LocalDate startStudyingDate, int startLevel, Student student) {
        this.startStudyingDate = startStudyingDate;
        this.startLevel = startLevel;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public LocalDate getStartStudyingDate() {
        return startStudyingDate;
    }

    public void setStartStudyingDate(LocalDate startStudying) {
        this.startStudyingDate = startStudying;
    }

    public LocalDate getEndStudyingDate() {
        return endStudyingDate;
    }

    public void setEndStudyingDate(LocalDate endStudying) {
        this.endStudyingDate = endStudying;
    }

    public int getStartLevel() {
        return startLevel;
    }

    public void setStartLevel(int startLevel) {
        this.startLevel = startLevel;
    }

    public int getEndLevel() {
        return endLevel;
    }

    public void setEndLevel(int endLevel) {
        this.endLevel = endLevel;
    }

    @Override
    public String toString() {
        return "HistoryEducation{" +
                "startStudying=" + startStudyingDate +
                ", startLevel=" + startLevel +
                ", endStudying=" + endStudyingDate +
                ", endLevel=" + endLevel +
                '}';
    }
}
