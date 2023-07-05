package com.example.backend7team.domain.accident.service;


import com.example.backend7team.domain.accident.domain.repository.AccidentRepository;
import com.example.backend7team.domain.accident.domain.repository.enums.SortType;
import com.example.backend7team.domain.accident.presentation.dto.response.QueryAccidentInformationListResponse;
import com.example.backend7team.domain.user.domain.User;
import com.example.backend7team.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QueryAccidentInformationListService {

    private final AccidentRepository accidentRepository;
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public QueryAccidentInformationListResponse execute(String title, SortType type) {
        User user = userFacade.getCurrentUser();

        return new QueryAccidentInformationListResponse(
                accidentRepository.queryAccidentInformationListByConditions(title, type, user.getId())
        );
    }
}
