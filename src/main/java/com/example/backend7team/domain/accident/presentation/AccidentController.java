package com.example.backend7team.domain.accident.presentation;

import com.example.backend7team.domain.accident.domain.repository.enums.SortType;
import com.example.backend7team.domain.accident.presentation.dto.request.CreateAccidentInformationRequest;
import com.example.backend7team.domain.accident.presentation.dto.response.QueryAccidentInformationDetailsResponse;
import com.example.backend7team.domain.accident.presentation.dto.response.QueryAccidentInformationListResponse;
import com.example.backend7team.domain.accident.service.CreateAccidentInformationService;
import com.example.backend7team.domain.accident.service.QueryAccidentInformationDetailsService;
import com.example.backend7team.domain.accident.service.QueryAccidentInformationListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/accidents")
@RestController
public class AccidentController {

    private final CreateAccidentInformationService createAccidentInformationService;
    private final QueryAccidentInformationListService queryAccidentInformationListService;
    private final QueryAccidentInformationDetailsService queryAccidentInformationDetailsService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/information")
    public void createAccidentInformation(@RequestBody @Valid CreateAccidentInformationRequest request) {
        createAccidentInformationService.execute(request);
    }

    @GetMapping("/information")
    public QueryAccidentInformationListResponse queryAccidentInformationList(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "sort_type", defaultValue = "LIKES") SortType type
            ) {
        return queryAccidentInformationListService.execute(title, type);
    }

    @GetMapping("/information/{accident-information-id}")
    public QueryAccidentInformationDetailsResponse queryAccidentInformationDetails(
            @PathVariable("accident-information-id") Long accidentInformationId
    ) {
        return queryAccidentInformationDetailsService.execute(accidentInformationId);
    }
}
