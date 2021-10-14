package com.project.scheduler.schedule.domain;

import lombok.*;

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
    private Date startDate; // 스케쥴 시작 날짜
    private Date endDate; // 스케쥴 종료 날짜
}
