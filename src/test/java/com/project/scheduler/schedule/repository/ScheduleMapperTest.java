package com.project.scheduler.schedule.repository;

import com.project.scheduler.schedule.domain.Schedule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScheduleMapperTest {

    @Autowired
    ScheduleMapper scheduleMapper;

    @Test
    @DisplayName("해당하는 달의 스케줄 목록을 가져와야 한다.")
    void getScheduleList() {

        List<Schedule> scheduleList = scheduleMapper.getMonthScheduleList(10);
        System.out.println("\n++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("scheduleList = " + scheduleList);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++\n");
        
    }
    
    @Test
    @DisplayName("해당하는 번호의 스케줄을 가져와야한다.")
    void getSchedule() {
        Schedule schedule = scheduleMapper.getSchedule(2);
        System.out.println("\n++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("schedule = " + schedule);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++\n");
    }

    @Test
    @DisplayName("스케쥴 등록을 성공해야한다.")
    void insertSchedule() {
        Schedule schedule = new Schedule();

        schedule.setScdTitle("다섯번째 스케쥴");
        schedule.setScdContent("다섯번째 내용");
        schedule.setWriterEmpNo(3);
        schedule.setScdCode("D");
        Date date = new Date();
        schedule.setStartDate(date);
        schedule.setEndDate(date);

        scheduleMapper.insertSchedule(schedule);
    }

    @Test
    @DisplayName("해당하는 스케쥴이 삭제돼야한다.")
    void deleteSchedule() {
        boolean result = scheduleMapper.deleteSchedule(1);
        Schedule schedule = scheduleMapper.getSchedule(1);
        assertTrue(result);//삭제성공하면 트루가 나올 것이다.
        assertNull(schedule);

    }

    @Test
    @DisplayName("해당하는 스케쥴이 수정돼야한다.")
    void modifySchedule() {
        Schedule schedule = scheduleMapper.getSchedule(22);
        Date date = new Date();
        schedule.setScdContent("수정수정");
        schedule.setScdTitle("수정된 스케쥴");
        schedule.setWriterEmpNo(2);
        schedule.setStartDate(date);
        schedule.setEndDate(date);

        boolean result = scheduleMapper.modifySchedule(schedule);
        Schedule schedule1 = scheduleMapper.getSchedule(1);

        assertTrue(result);
        System.out.println(schedule1);

    }




}