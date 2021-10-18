package com.project.scheduler.schedule.service;

import com.project.scheduler.employee.repository.EmployeeMapper;
import com.project.scheduler.schedule.domain.Schedule;
import com.project.scheduler.schedule.repository.ScheduleMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import com.project.scheduler.employee.domain.Employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleMapper scheduleMapper;
    private final EmployeeMapper employeeMapper;

    // 전체 일정 가져오기
    public List<Schedule> getScheduleList(){
        return scheduleMapper.getScheduleList();
    }

    // 스케쥴 세부 일정 가져오기 - 스케쥴 번호를 통해 스케쥴 세부 정보 가져오기
    public Schedule getSchedule(int scdNo) {
        return scheduleMapper.getSchedule(scdNo);
    }

    // 일정 등록
    public boolean insertSchedule(String type, Schedule schedule) {

        try {
            schedule.setStartDate(stringToDate(schedule.getStartDay(), schedule.getStartTime()));
            schedule.setEndDate(stringToDate(schedule.getEndDay(), schedule.getEndTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // 1.임시직원 한명 생성
        Employee employee = employeeMapper.getEmployee(2);

        schedule.setScdCode(makeScdCode(type, employee));

        log.info(schedule);

        return false;
    }

    // String(날짜와 시간)을 Date타입으로 변환
    private Date stringToDate(String day, String time) throws ParseException {
        String dateStr = day.concat(time);
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-ddHH:mm");
        Date date = fm.parse(dateStr);
        return date;
    }

    // 일정 코드 생성
    private String makeScdCode(String type, Employee employee) {
        String code;
        switch (type) {
            case "C":
                code = type;
                break;
            case "D":
                code = type + "-" + employee.getDep().getDptNo();
                break;
            case "P":
                code = type + "-" + employee.getPos().getPosNo();
                break;
            default:
                code = "";
        }
        return code;
    }

    // 스케쥴 삭제
    public boolean deleteSchedule(int scdNo) {
        return scheduleMapper.deleteSchedule(scdNo);
    }

    // 스케쥴 수정
    public boolean modifySchedule(Schedule schedule) {
        return scheduleMapper.modifySchedule(schedule);
    }
}
