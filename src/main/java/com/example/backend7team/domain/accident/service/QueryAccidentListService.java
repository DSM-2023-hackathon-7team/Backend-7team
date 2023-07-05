package com.example.backend7team.domain.accident.service;

import com.example.backend7team.domain.accident.domain.repository.AccidentRepository;
import com.example.backend7team.domain.accident.presentation.dto.response.QueryAccidentListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QueryAccidentListService {

    private final AccidentRepository accidentRepository;

    @Transactional(readOnly = true)
    public QueryAccidentListResponse execute() {
        return new QueryAccidentListResponse(
                accidentRepository.queryAccidentList()
        );
    }
}
