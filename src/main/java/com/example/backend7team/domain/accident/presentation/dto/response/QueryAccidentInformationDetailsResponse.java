package com.example.backend7team.domain.accident.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class QueryAccidentInformationDetailsResponse {

    private final String title;
    private final String content;
    private final String imageUrl;
    private final LocalDateTime createdAt;
    private final Integer likesCount;
}
