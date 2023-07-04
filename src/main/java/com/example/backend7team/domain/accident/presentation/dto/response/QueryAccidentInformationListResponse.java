package com.example.backend7team.domain.accident.presentation.dto.response;

import com.example.backend7team.domain.accident.domain.repository.vo.QueryAccidentInformationVO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QueryAccidentInformationListResponse {

    private final List<QueryAccidentInformationVO> accidentInformationList;
}
