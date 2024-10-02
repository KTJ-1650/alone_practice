package com.sparta.alone_project1.comment.service;

import com.sparta.alone_project1.comment.dto.CommentRequestDto;
import com.sparta.alone_project1.comment.dto.CommentResponseDto;
import com.sparta.alone_project1.comment.entity.Comment;
import com.sparta.alone_project1.comment.repository.CommentRespository;
import com.sparta.alone_project1.schedule.entity.Schedule;
import com.sparta.alone_project1.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRespository commentRespository;
    private final ScheduleRepository scheduleRepository;

    public CommentResponseDto creatComment(Long scheduleId, CommentRequestDto commentRequestDto) {

       Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(()->new RuntimeException("스케쥴 존재 여부 X"));

        Comment comment = new Comment(commentRequestDto,schedule);

        return new CommentResponseDto(comment);
    }

    public CommentResponseDto inquiryComment(Long scheduleId, Long commentId) {
       Comment comment = commentRespository.findByScheduleIdAndCommentId(scheduleId,commentId)
                .orElseThrow(()->new IllegalArgumentException("스케쥴과 댓글의 아이디가 존재하지 않습니다."));

       return new CommentResponseDto(comment);
    }

    public List<CommentResponseDto> fullInquiryComment(Long scheduleId) {

        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(()-> new IllegalArgumentException("스케쥴의 아이디가 존재하지 않습니다."));

        return schedule.getCommentList().stream().map(CommentResponseDto::new).toList();
    }

    @Transactional
    public CommentResponseDto updateComment(Long scheduleId, Long commentId, CommentRequestDto commentRequestDto) {
        Comment comment = commentRespository.findByScheduleIdAndCommentId(scheduleId,commentId)
                .orElseThrow(()->new IllegalArgumentException("스케쥴과 댓글의 아이디가 존재하지 않습니다."));

        comment.update(commentRequestDto);

        return new CommentResponseDto(comment);
    }


    public void deleteComment(Long scheduleId, Long commentId) {
       Comment comment = commentRespository.findById(commentId)
                .orElseThrow(()->new IllegalArgumentException("댓글이 존재하지 않습니다."));

       if(comment.getSchedule().getId().equals(scheduleId)) {
           throw new IllegalArgumentException("해당 댓글은 스케쥴에 속하지 않습니다");
       }

       commentRespository.deleteById(commentId);


    }
}
