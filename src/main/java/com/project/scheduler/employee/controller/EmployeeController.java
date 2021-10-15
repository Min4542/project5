package com.project.scheduler.employee.controller;

import com.project.scheduler.employee.domain.Employee;
import com.project.scheduler.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;

@Controller
@Log4j2
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    public boolean loginEmployee(int empNo, int empPw){
        boolean result = employeeService.loginEmployee(empNo, empPw);
        return result;
    }



}
