package com.breakingbad.workerhub.core.scheduler.job;

import com.breakingbad.workerhub.core.scheduler.HolidayScheduler;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.Year;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class HolidaysSchedulerJob {

    private final HolidayScheduler scheduler;

    /**
     * 매년 12월 25일 00시 15분에 N 년도 두의 공휴일 정보를 저장한다.
     *
     * <p> N년 -> 정책적으로 정해야함.
     *
     * @throws IOException
     */
    @Scheduled(cron = "0 15 0 25 12 * ")
    public void saveHolidays() throws IOException {
        Year standard = Year.now().plusYears(5);
        List<Year> years = Stream.iterate(standard, year -> year.plusYears(1))
                .limit(5)
                .collect(toList());

        scheduler.saveHolidaysByYears(years);
    }

}
