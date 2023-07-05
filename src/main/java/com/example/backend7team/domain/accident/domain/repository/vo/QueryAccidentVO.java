package com.example.backend7team.domain.accident.domain.repository.vo;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class QueryAccidentVO {

    private final Long id;
    private final String title;
    private final String content;
    private final String imageUrl;
    private final LocalDateTime createdAt;
    private final Integer views;
    //TODO 댓글 개수

    @QueryProjection
    public QueryAccidentVO(Long id, String title, String content, String imageUrl, LocalDateTime createdAt, Integer views) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;
        this.views = views;
    }
}
