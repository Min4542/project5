package com.project.scheduler.schedule.repository;

import com.project.scheduler.schedule.domain.Schedule;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface ScheduleMapper {

    //스케쥴 회사 일정 가져오기
    List<Schedule> getScheduleList(String code);


    // 스케쥴 세부 일정 가져오기 - 스케쥴 번호를 통해 스케쥴 세부 정보 가져오기
    Schedule getSchedule(int scdNo);

    // 스케쥴 등록
    boolean insertSchedule(Schedule schedule);

    // 스케쥴 삭제
    boolean deleteSchedule(int scdNo);

    // 스케쥴 수정
    boolean modifySchedule(Schedule schedule);
}
