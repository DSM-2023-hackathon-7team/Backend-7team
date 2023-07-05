package com.example.backend7team.domain.accident.service;

import com.example.backend7team.domain.accident.domain.AccidentInformation;
import com.example.backend7team.domain.accident.domain.repository.AccidentRepository;
import com.example.backend7team.domain.accident.exception.AccidentInformationNotFoundException;
import com.example.backend7team.domain.accident.presentation.dto.response.QueryAccidentInformationDetailsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QueryAccidentInformationDetailsService {

    private final AccidentRepository accidentRepository;

    public QueryAccidentInformationDetailsResponse execute(Long accidentInformationId) {
        AccidentInformation accidentInformation = accidentRepository.queryAccidentInformationById(accidentInformationId)
                .orElseThrow(() -> AccidentInformationNotFoundException.EXCEPTION);

        accidentInformation.addViews();
        return QueryAccidentInformationDetailsResponse.builder()
                .title(accidentInformation.getTitle())
                .content(accidentInformation.getContent())
                .imageUrl(accidentInformation.getImageUrl())
                .createdAt(accidentInformation.getCreatedAt())
                .likesCount(accidentInformation.getLikesCount())
                .build();
    }
}
