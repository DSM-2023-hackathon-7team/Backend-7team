package com.example.backend7team.domain.accident.presentation.dto.response;


import com.example.backend7team.domain.accident.domain.repository.vo.QueryAccidentVO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QueryAccidentListResponse {

    private final List<QueryAccidentVO> accidentList;
}
