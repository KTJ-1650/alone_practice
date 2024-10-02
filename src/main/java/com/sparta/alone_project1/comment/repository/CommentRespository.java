package com.sparta.alone_project1.comment.repository;

import com.sparta.alone_project1.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRespository extends JpaRepository<Comment,Long> {
    Optional<Comment> findByScheduleIdAndCommentId(Long scheduleId, Long commentId);
}
