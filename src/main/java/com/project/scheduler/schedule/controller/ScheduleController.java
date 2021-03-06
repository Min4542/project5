package com.project.scheduler.schedule.controller;

import com.project.scheduler.employee.domain.Employee;
import com.project.scheduler.employee.service.EmployeeService;
import com.project.scheduler.schedule.domain.Schedule;
import com.project.scheduler.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/schedule")
@Log4j2


public class ScheduleController {

    private final ScheduleService scheduleService;
    private final EmployeeService employeeService;

    //Date타입으로 변환하는 방법 <1>
//    @InitBinder
//    protected void initBinder(WebDataBinder binder){
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat,true));
//    }

    @GetMapping("/add")
    public String add() {

        return "/add";
    }

    @GetMapping("/scd-add")
    public String scdAdd(Schedule schedule, String type, Model model) {

        // 클라이언트로부터 데이터를 받아 서비스메서드로 보냄
        log.info(schedule);
        log.info("==========================================");

        scheduleService.insertSchedule(type, schedule);
        return "/calendar";
    }

    @GetMapping("/calendar")
    public String calendar() {
        return "/calendar";
    }

    @GetMapping("/get-schedule")
    @ResponseBody
    public ResponseEntity<List<Schedule>> data() {
        log.info("호출됨");
        List<Schedule> schedules = scheduleService.getScheduleList("C");
        log.info(schedules);
        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }

    @GetMapping("/modify")//수정화면요청
    public String modifyScheduleView(Schedule schedule, Model model){

        Schedule schedules = scheduleService.getSchedule(5);
        model.addAttribute("schedules", schedules);

        return "/modify";
    }

    @PostMapping("/modify")//수정완료처리
    public String modifyScheduleContent(Schedule schedule) {
        log.info("/schedule/modify POST!" + schedule);
        scheduleService.modifySchedule(schedule);
        //jsp에서 input type hidden으로 scdNo 넘겨줌

        return "redirect:/schedule/plan?scdNo=" + schedule.getScdNo();//상세보기로 돌아가게 처리
    }

    //게시물 삭제
    @GetMapping("/delete")
    public String delete(int scdNo) {
        log.info("/board/delete GET-"+ scdNo);
        scheduleService.deleteSchedule(scdNo);

        return "redirect:/schedule/plan";
    }
}
