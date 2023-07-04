package com.example.backend7team.domain.accident.domain.repository.vo;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;

@Getter
public class QueryAccidentInformationVO {

    private final String title;
    private final String content;
    private final String imageUrl;
    //TODO 좋아요 개수 추가

    @Builder
    @QueryProjection
    public QueryAccidentInformationVO(String title, String content, String imageUrl) {
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
    }
}
