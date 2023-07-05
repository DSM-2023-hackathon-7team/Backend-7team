package com.example.backend7team.domain.comment.service;

import com.example.backend7team.domain.comment.domain.repository.CommentRepository;
import com.example.backend7team.domain.comment.presentation.dto.response.QueryCommentListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QueryAccidentCommentListService {

    private final CommentRepository commentRepository;

    @Transactional(readOnly = true)
    public QueryCommentListResponse execute(Long accidentId) {
        return new QueryCommentListResponse(
                commentRepository.queryAccidentCommentList(accidentId)
        );
    }
}
