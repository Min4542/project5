package com.project.scheduler.employee.domain;

import lombok.*;

@Setter @Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private int empNo; // 사원번호
    private String empName; // 사원 이름
    private int dptNo; // 부서번호
    private String dptName; //부서 이름
    private int posNo; // 직급 번호
    private int posName; // 직급 이름
}
