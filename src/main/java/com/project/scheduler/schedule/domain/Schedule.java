package com.project.scheduler.schedule.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;


@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor

public class Schedule {
    
    private int scdNo; // 스케쥴 번호
    private String scdTitle; // 스케쥴 제목
    private String scdContent; //스케쥴 내용
    private int writerEmpNo; // 작성자 사번
    private String scdCode; // 스케쥴 코드 (A-00, A : 회사 일정, D : 부서 일정, P: 개인 일정 - 부서(사원) 번호)

    // 컨트롤러로부터 입력받는 date의 타입이 string이므로 date로 형변환
    private Date startDate; // 스케쥴 시작 날짜
    private Date endDate; // 스케쥴 종료 날짜

    // fullCaledar 전용 변수
    private String start; // 시작 날짜 문자열
    private String end; // 종료 날짜 문자열

    //스트링타입
    private String startDay;//스케쥴 날짜(월,일)
    private String endDay;//스케쥴 종료

    private String startTime;//스케쥴시작시간
    private String endTime;//스케쥴종료시간


    public void setStartDate(Date startDate) {
        this.startDate = startDate;
        start = dateToString(startDate);
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
        end = dateToString(endDate);
    }

    private String dateToString(Date date) {
        SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        String changedDate = dayFormat.format(date) + "T" + timeFormat.format(date);

        System.out.println(changedDate);
        return changedDate;
    }

}
