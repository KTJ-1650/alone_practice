package com.sparta.alone_project1.comment.entity;

import com.sparta.alone_project1.comment.dto.CommentRequestDto;
import com.sparta.alone_project1.config.TimeStamp;
import com.sparta.alone_project1.schedule.entity.Schedule;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Comment extends TimeStamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    private String content;
    private String username;


    @ManyToOne
    @JoinColumn(name = "scheduleId")
    private Schedule schedule;

    public Comment(CommentRequestDto commentRequestDto,Schedule schedule){
        this.content = commentRequestDto.getContent();
        this.username = commentRequestDto.getUsername();
        this.schedule = schedule;
    }

    public void update(CommentRequestDto commentRequestDto) {

        this.content = commentRequestDto.getContent();
        this.username = commentRequestDto.getUsername();
    }
}
