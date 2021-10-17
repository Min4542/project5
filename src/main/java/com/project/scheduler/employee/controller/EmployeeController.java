package com.project.scheduler.employee.controller;

import com.project.scheduler.employee.domain.Employee;
import com.project.scheduler.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/schedule")
public class EmployeeController {

    private final EmployeeService employeeService;

    //로그인

    @GetMapping("/login")
    public String add() {

        return "/login";
    }
    @PostMapping("/login")
    public String login(int empNo, String password) {
        if(employeeService.checkEmpNo(empNo)) {
            if(employeeService.getPassward(empNo).equals((password))) {
                //로그인 성공
            }
        }
        //패스워드 불일치
        //없는 사번
        log.info(empNo);
        log.info(password);
        return "/login";
    }



}
