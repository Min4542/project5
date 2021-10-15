package com.project.scheduler.employee.repository;

import com.project.scheduler.employee.domain.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper {

    // 사원정보 가져오기 - 사번을 통해 사원 정보 가져옴
    Employee getEmployee(int empNo);

    //로그인 기능

    // 이후 사원등록

    // 사원 정보 수정
    boolean modifyEmployee(Employee employee);

    // 사원 정보 삭제
    boolean deleteEmployee(int empNo);
}
