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

    //월별 스케쥴 가져오기
    public List<Schedule> getMonthScheduleList(Schedule schedule, int month) {
        List<Schedule> scheduleList = scheduleMapper.getAllScheduleList(schedule);

        int m = 0;//month와 비교하기 위한 변수

        //가져온 스케쥴리스트(2차원배열이니까) 하나씩 뽑아서 시작날짜 알아내기

        for (Schedule s : scheduleList) {

            //sql에 있는 날짜 데이터 스트링으로 변환
            String startDate = scheduleMapper.dateToString(s.getStartDate());

            //월부분 잘라내기
            String substring = startDate.substring(2, 4);

            //month와 비교하기 위해 int로 형변환(sql데이터)
            m = Integer.parseInt(substring);

        }

        if (month == m) {//들어온 month와 기존 데이터 중에서 뽑아낸 m의 수가 같다면
            return scheduleMapper.getMonthScheduleList(m);//리턴해야하는데...얘가 아닌데...

        } else {

            // n개 이상일 경우 그외 일정 m개 표시
            return null;
        }

    }

    // 일별 스케쥴 가져오기
    public List<Schedule> getDayScheduleList(int day) {
        return scheduleMapper.getDayScheduleList(day);
    }

    // 스케쥴 세부 일정 가져오기 - 스케쥴 번호를 통해 스케쥴 세부 정보 가져오기
    public Schedule getSchedule(int scdNo) {
        return scheduleMapper.getSchedule(scdNo);
    }

    //전체 스케쥴 가져오기
    public List<Schedule> getAllSchedule(Schedule schedule) {
        return scheduleMapper.getAllScheduleList(schedule);
    }


    // 스케쥴 등록
    public boolean insertSchedule(String type, Schedule schedule) {

        //스트링타입으로 날짜와 시간을 받아 변환하여 넣어줌...

        //날짜와 시간을 합쳐서
        String startDT = schedule.getStartD().concat(schedule.getStartTime());
        String endDT = schedule.getEndD().concat(schedule.getEndTime());

        //Date타입으로 변환//시작날짜
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-ddHH:mm");

        try {
            Date date = fm.parse(startDT);
            schedule.setStartDate(date);//스케쥴의 Date타입 변수에 저장
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //Date타입으로 변환//종료날짜
        SimpleDateFormat fm2= new SimpleDateFormat("yyyy-MM-ddHH:mm");

        try {
            Date date2 = fm2.parse(endDT);
            schedule.setEndDate(date2);//스케쥴의 Date타입 변수에 저장
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 로그인 상황 파악하여 작성자 사번 데이터 삽입

        // 1.임시직원 한명 생성
        Employee employee = employeeMapper.getEmployee(2);

        // 2.임시직원의 사번으로 작성자번호 생성
        schedule.setWriterEmpNo(employee.getEmpNo());

        // 3.타입에 따른 스케쥴 코드 생성
        schedule.setScdCode(type);

        return scheduleMapper.insertSchedule(schedule);
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
