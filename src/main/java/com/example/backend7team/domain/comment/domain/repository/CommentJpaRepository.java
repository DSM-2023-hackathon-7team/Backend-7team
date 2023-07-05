package com.example.backend7team.domain.comment.domain.repository;

import com.example.backend7team.domain.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentJpaRepository extends JpaRepository<Comment, Long> {
}
