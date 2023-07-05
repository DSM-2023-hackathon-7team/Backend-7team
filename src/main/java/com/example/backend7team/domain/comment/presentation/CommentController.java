package com.example.backend7team.domain.comment.presentation;

import com.example.backend7team.domain.comment.presentation.dto.request.CreateCommentRequest;
import com.example.backend7team.domain.comment.presentation.dto.response.QueryCommentListResponse;
import com.example.backend7team.domain.comment.service.CreateAccidentCommentService;
import com.example.backend7team.domain.comment.service.CreateAccidentInformationCommentService;
import com.example.backend7team.domain.comment.service.QueryAccidentCommentListService;
import com.example.backend7team.domain.comment.service.QueryAccidentInformationCommentListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/comments")
@RestController
public class CommentController {

    private final CreateAccidentInformationCommentService createAccidentInformationCommentService;
    private final CreateAccidentCommentService createAccidentCommentService;
    private final QueryAccidentInformationCommentListService queryAccidentInformationCommentListService;
    private final QueryAccidentCommentListService queryAccidentCommentListService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/accident-information/{accident-information-id}")
    public void createAccidentInformationComment(
            @PathVariable("accident-information-id") Long accidentInformationId,
            @RequestBody @Valid CreateCommentRequest request
            ) {
        createAccidentInformationCommentService.execute(accidentInformationId, request);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/accident/{accident-id}")
    public void createAccidentComment(
            @PathVariable("accident-id") Long accidentId,
            @RequestBody @Valid CreateCommentRequest request
    ) {
        createAccidentCommentService.execute(accidentId, request);
    }

    @GetMapping("/accident-information/{accident-information-id}")
    public QueryCommentListResponse queryAccidentInformationCommentList(
            @PathVariable("accident-information-id") Long accidentInformationId
    ) {
        return queryAccidentInformationCommentListService.execute(accidentInformationId);
    }

    @GetMapping("/accident/{accident-id}")
    public QueryCommentListResponse queryAccidentCommentList(
            @PathVariable("accident-id") Long accidentId
    ) {
        return queryAccidentCommentListService.execute(accidentId);
    }
}
