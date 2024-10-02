package com.sparta.alone_project1.schedule.dto;

import com.sparta.alone_project1.schedule.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {

    private String username;
    private String title;
    private String content;


    public ScheduleResponseDto(Schedule schedule){

        this.username = schedule.getUsername();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
    }
}
