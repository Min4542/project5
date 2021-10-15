package com.project.scheduler.schedule.controller;

import com.project.scheduler.schedule.domain.Schedule;
import com.project.scheduler.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/schedule")
@Log4j2
public class ScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping("/add")
    public String add() {

        return "/add";
    }

    @GetMapping("scd-add")
    public String scdAdd(Schedule schedule, String type) {

        log.info(schedule);
        //scheduleService.insertSchedule(type, schedule);

        return "/add";
    }
}
