package com.example.backend7team.domain.accident.service;

import com.example.backend7team.domain.accident.domain.Accident;
import com.example.backend7team.domain.accident.domain.repository.AccidentRepository;
import com.example.backend7team.domain.accident.exception.AccidentNotFoundException;
import com.example.backend7team.domain.accident.presentation.dto.response.QueryAccidentDetailsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QueryAccidentDetailsService {

    private final AccidentRepository accidentRepository;

    @Transactional(readOnly = true)
    public QueryAccidentDetailsResponse execute(Long accidentId) {
        Accident accident = accidentRepository.queryAccidentById(accidentId)
                .orElseThrow(() -> AccidentNotFoundException.EXCEPTION);

        accident.addViews();
        return QueryAccidentDetailsResponse.builder()
                .title(accident.getTitle())
                .content(accident.getContent())
                .imageUrl(accident.getImageUrl())
                .createdAt(accident.getCreatedAt())
                .views(accident.getViews())
                .build();
    }
}
