package com.project.scheduler.schedule.service;

import com.project.scheduler.employee.repository.EmployeeMapper;
import com.project.scheduler.schedule.domain.Schedule;
import com.project.scheduler.schedule.repository.ScheduleMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import com.project.scheduler.employee.domain.Employee;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleMapper scheduleMapper;
    private final EmployeeMapper employeeMapper;

     //월별 스케쥴 가져오기
    public List<Schedule> getMonthScheduleList(Schedule schedule,int month){

        //sql에 있는 날짜 데이터 스트링으로 변환
        String startDate = scheduleMapper.dateToString(schedule.getStartDate());
        String substring = startDate.substring(2, 4);

        int m= Integer.parseInt(substring);//month와 비교하기 위해 int로 형변환(sql데이터)

        if(month == m) {
            return scheduleMapper.getMonthScheduleList(month);

        } else{

        // n개 이상일 경우 그외 일정 m개 표시
            return null;
        }

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

        // 1.임시직원 한명 생성
        Employee employee = employeeMapper.getEmployee(3);

        // 로그인 상황 파악하여 작성자 사번 데이터 삽입

        // 2.임시직원의 사번으로 작성자번호 생성
        schedule.setWriterEmpNo(employee.getEmpNo());

        // 3.타입에 따른 스케쥴 코드 생성
        if(type.equals("A")) {
            schedule.setScdCode("A");
        }else if(type.equals("D")) {
            schedule.setScdCode("D");
        }else if(type.equals("P")) {
            schedule.setScdCode("P");
        }
        /*
             Response (서버 -> 클라이언트) 로 전달할 때에는 @JsonFormat 을 사용,
             Request(클라이언트 -> 서버)로 전달할 때는 @DateTimeFormat 을 사용한다.
             (post요청시 request에서는 @jsonFormat 사용 가능)
         */
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
