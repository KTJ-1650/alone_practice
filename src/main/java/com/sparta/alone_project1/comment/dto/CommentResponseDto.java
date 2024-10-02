package com.sparta.alone_project1.comment.dto;

import com.sparta.alone_project1.comment.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {
    private String content;
    private String username;
    private LocalDateTime createdAt;
    private LocalDateTime  modifiedAt;

    public CommentResponseDto(Comment comment){

        this.content = comment.getContent();
        this.username = comment.getUsername();
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
    }

}
