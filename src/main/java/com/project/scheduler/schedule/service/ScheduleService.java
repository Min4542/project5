package com.project.scheduler.schedule.service;

import com.project.scheduler.schedule.domain.Schedule;
import com.project.scheduler.schedule.repository.ScheduleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleMapper scheduleMapper;

    // 전체 스케쥴 가져오기
    List<Schedule> getScheduleList(){
        return scheduleMapper.getScheduleList();
    }

    // 스케쥴 세부 일정 가져오기 - 스케쥴 번호를 통해 스케쥴 세부 정보 가져오기
    Schedule getSchedule(int scdNo){
     return scheduleMapper.getSchedule(scdNo);
    }

    // 스케쥴 등록
    Schedule insertSchedule(Schedule schedule){
        return scheduleMapper.insertSchedule(schedule);
    }

    // 스케쥴 삭제
    boolean deleteSchedule(int scdNo){
        return scheduleMapper.deleteSchedule(scdNo);
    }

    // 스케쥴 수정
    boolean modifySchedule(Schedule schedule){
        return scheduleMapper.modifySchedule(schedule);
    }
}
