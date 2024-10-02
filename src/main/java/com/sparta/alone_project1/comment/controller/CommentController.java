package com.sparta.alone_project1.comment.controller;

import com.sparta.alone_project1.comment.dto.CommentRequestDto;
import com.sparta.alone_project1.comment.dto.CommentResponseDto;
import com.sparta.alone_project1.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/{scheduleId}")
    public CommentResponseDto creatComment(@PathVariable Long scheduleId, @RequestBody CommentRequestDto commentRequestDto){

        return commentService.creatComment(scheduleId,commentRequestDto);
    }

    @GetMapping("/schedule/{scheduleId}/comment/{commentId}")
    public CommentResponseDto inquiryComment(@PathVariable Long scheduleId, @PathVariable Long commentId){

        return commentService.inquiryComment(scheduleId,commentId);
    }

    @GetMapping("/{scheduleId}")
    public List<CommentResponseDto> fullInquiryComment(@PathVariable Long scheduleId){

        return commentService.fullInquiryComment(scheduleId);
    }

    @PutMapping("/schedule/{scheduleId}/comment/{commentId}")
    public CommentResponseDto updateComment(@PathVariable Long scheduleId,@PathVariable Long commentId,@RequestBody CommentRequestDto commentRequestDto){

        return commentService.updateComment(scheduleId,commentId,commentRequestDto);
    }

    @DeleteMapping("/schedule/{scheduleId}/comment/{commentId}")
    public void deleteComment(@PathVariable Long scheduleId, @PathVariable Long commentId){

         commentService.deleteComment(scheduleId,commentId);
    }

}
