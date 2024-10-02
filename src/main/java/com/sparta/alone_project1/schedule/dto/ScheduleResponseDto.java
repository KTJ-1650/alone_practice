package com.sparta.alone_project1.schedule.dto;

import com.sparta.alone_project1.schedule.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {

    private String username;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime  modifiedAt;

    public ScheduleResponseDto(Schedule schedule){

        this.username = schedule.getUsername();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.createdAt = schedule.getCreatedAt();
        this.modifiedAt = schedule.getModifiedAt();
    }
}
