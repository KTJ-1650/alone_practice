package com.sparta.alone_project1.schedule.entity;

import com.sparta.alone_project1.comment.entity.Comment;
import com.sparta.alone_project1.config.TimeStamp;
import com.sparta.alone_project1.schedule.dto.ScheduleRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Schedule extends TimeStamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String title;
    private String content;

    public Schedule(ScheduleRequestDto scheduleRequestDto){
        this.username = scheduleRequestDto.getUsername();
        this.title = scheduleRequestDto.getTitle();
        this.content = scheduleRequestDto.getContent();
    }

    public void updateSchedule(ScheduleRequestDto scheduleRequestDto) {

        this.username = scheduleRequestDto.getUsername();
        this.title = scheduleRequestDto.getTitle();
        this.content = scheduleRequestDto.getContent();
    }

    @OneToMany(mappedBy = "schedule",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Comment> commentList;
}
