package com.project.scheduler.employee.repository;


import com.project.scheduler.employee.domain.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class EmployeeMapperTest {

    @Autowired
    EmployeeMapper employeeMapper;



    @Test
    @DisplayName("사원정보를 가져와야한다.")
    void getEmployee() {
        Employee employee = employeeMapper.getEmployee(6);
        System.out.println("\n++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("사원번호 = " + employee);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++\n");

    }

    @Test
    @DisplayName("해당하는 사원을 삭제해야한다.")
    void deleteEmployee() {
        boolean result = employeeMapper.deleteEmployee(6);
        Employee employee = employeeMapper.getEmployee(6);
        assertTrue(result);
        assertNull(employee);

    }


}