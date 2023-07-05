package com.example.backend7team.domain.accident.domain.repository.vo;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;

@Getter
public class QueryAccidentInformationVO {

    private final Long accidentInformationId;
    private final String title;
    private final String content;
    private final String imageUrl;
    private final Integer likeCount;
    private boolean isLikes;

    @Builder
    @QueryProjection
    public QueryAccidentInformationVO(Long accidentInformationId, String title, String content, String imageUrl, Integer likeCount, Long isLikes) {
        this.accidentInformationId = accidentInformationId;
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.likeCount = likeCount;
        this.isLikes = isLikes != 0;
    }
}
