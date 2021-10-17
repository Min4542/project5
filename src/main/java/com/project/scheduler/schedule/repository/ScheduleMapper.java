package com.project.scheduler.schedule.repository;

import com.project.scheduler.schedule.domain.Schedule;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface ScheduleMapper {

    //날짜 타입 스트링으로 변경하기//쓸지 안 쓸지 모름
    String dateToString(Date startDate);

    //스케쥴 전체 가져오기
    List<Schedule> getAllScheduleList(Schedule schedule);

    // 월별 스케쥴 가져오기
    List<Schedule> getMonthScheduleList(int month);
    
    // 일별 스케쥴 가져오기
    List<Schedule> getDayScheduleList(int day);

    // 스케쥴 세부 일정 가져오기 - 스케쥴 번호를 통해 스케쥴 세부 정보 가져오기
    Schedule getSchedule(int scdNo);

    // 스케쥴 등록
    boolean insertSchedule(Schedule schedule);

    // 스케쥴 삭제
    boolean deleteSchedule(int scdNo);

    // 스케쥴 수정
    boolean modifySchedule(Schedule schedule);
}
