package com.project.scheduler.schedule.domain;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yy-MM-dd")
    private Date startDate; // 스케쥴 시작 날짜
    @DateTimeFormat(pattern = "yy-MM-dd")
    private Date endDate; // 스케쥴 종료 날짜
}
