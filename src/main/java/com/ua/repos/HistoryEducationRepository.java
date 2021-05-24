package com.ua.repos;

import com.ua.domain.student_models.HistoryEducation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface HistoryEducationRepository extends JpaRepository<HistoryEducation, Long> {
    List<HistoryEducation> findByStartStudyingDate(LocalDate date);
}
