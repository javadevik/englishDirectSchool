package com.ua.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
@EnableScheduling
public class ScheduleGeneration {

    private static Logger log = LoggerFactory.getLogger(ScheduleGeneration.class);

    @Scheduled(fixedRate = 10_000)
    public void setSchedule() {
        log.info("[ScheduleGeneration]: " + LocalDate.now().toString());
    }
}
