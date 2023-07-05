package com.example.backend7team.domain.comment.service;

import com.example.backend7team.domain.accident.domain.Accident;
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
public class CreateAccidentCommentService {


    private final CommentRepository commentRepository;
    private final AccidentRepository accidentRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long accidentId, CreateCommentRequest request) {
        User user = userFacade.getCurrentUser();
        Accident accident = accidentRepository.queryAccidentById(accidentId)
                .orElseThrow(() -> AccidentInformationNotFoundException.EXCEPTION);

        commentRepository.saveComment(
                Comment.builder()
                        .user(user)
                        .accident(accident)
                        .content(request.getContent())
                        .build()
        );
    }
}
