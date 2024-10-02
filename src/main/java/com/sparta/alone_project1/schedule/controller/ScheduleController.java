package com.sparta.alone_project1.schedule.controller;

import com.sparta.alone_project1.schedule.dto.ScheduleRequestDto;
import com.sparta.alone_project1.schedule.dto.ScheduleResponseDto;
import com.sparta.alone_project1.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ScheduleResponseDto creatSchedule(@RequestBody ScheduleRequestDto scheduleRequestDto){

        return scheduleService.creatSchedule(scheduleRequestDto);
    }

    @GetMapping("/{scheduleId}")
    public ScheduleResponseDto inquirySchedule(@PathVariable Long scheduleId){

        return scheduleService.inquirySchedule(scheduleId);
    }

    @PutMapping("/{scheduleId}")
    public ScheduleResponseDto updateSchedule(@PathVariable Long scheduleId, @RequestBody ScheduleRequestDto scheduleRequestDto){

        return scheduleService.updateSchedule(scheduleId,scheduleRequestDto);
    }
}
