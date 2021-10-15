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

    // 월별 스케쥴 가져오기
    public List<Schedule> getMonthScheduleList(int month){
        // n개 이상일 경우 그외 일정 m개 표시
        return scheduleMapper.getMonthScheduleList(month);
    }
    
    // 일별 스케쥴 가져오기
    public List<Schedule> getDayScheduleList(int day) {
        return scheduleMapper.getDayScheduleList(day);
    }

    // 스케쥴 세부 일정 가져오기 - 스케쥴 번호를 통해 스케쥴 세부 정보 가져오기
    public Schedule getSchedule(int scdNo){
     return scheduleMapper.getSchedule(scdNo);
    }

    // 스케쥴 등록
    public boolean insertSchedule(String type, Schedule schedule){
        // 로그인 상황 파악하여 작성자 사번 데이터 삽입
        schedule.setWriterEmpNo(1);
        // 타입에 따른 스케쥴 코드 생성
        schedule.setScdCode(type);

        return scheduleMapper.insertSchedule(schedule);
    }

    // 스케쥴 삭제
    public boolean deleteSchedule(int scdNo){
        return scheduleMapper.deleteSchedule(scdNo);
    }

    // 스케쥴 수정
    public boolean modifySchedule(Schedule schedule){
        return scheduleMapper.modifySchedule(schedule);
    }
}
