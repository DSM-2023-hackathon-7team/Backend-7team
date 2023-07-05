package com.example.backend7team.domain.comment.service;

import com.example.backend7team.domain.accident.domain.AccidentInformation;
import com.example.backend7team.domain.accident.domain.repository.AccidentRepository;
import com.example.backend7team.domain.accident.exception.AccidentInformationNotFoundException;
import com.example.backend7team.domain.comment.domain.Comment;
import com.example.backend7team.domain.comment.domain.repository.CommentRepository;
import com.example.backend7team.domain.comment.presentation.dto.request.CreateCommentRequest;
import com.example.backend7team.domain.user.domain.User;
import com.example.backend7team.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateAccidentInformationCommentService {

    private final CommentRepository commentRepository;
    private final AccidentRepository accidentRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long accidentInformationId, CreateCommentRequest request) {
        User user = userFacade.getCurrentUser();
        AccidentInformation accidentInformation = accidentRepository.queryAccidentInformationById(accidentInformationId)
                .orElseThrow(() -> AccidentInformationNotFoundException.EXCEPTION);

        commentRepository.saveComment(
                Comment.builder()
                        .user(user)
                        .accidentInformation(accidentInformation)
                        .content(request.getContent())
                        .build()
        );
    }
}
