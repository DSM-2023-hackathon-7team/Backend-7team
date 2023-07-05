package com.example.backend7team.domain.comment.domain.repository.vo;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class QueryCommentVO {

    private final String name;
    private final String content;

    @QueryProjection
    public QueryCommentVO(String name, String content) {
        this.name = name;
        this.content = content;
    }
}
