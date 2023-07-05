package com.example.backend7team.domain.comment.presentation.dto.response;

import com.example.backend7team.domain.comment.domain.repository.vo.QueryCommentVO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QueryCommentListResponse {

    private final List<QueryCommentVO> comments;
}
