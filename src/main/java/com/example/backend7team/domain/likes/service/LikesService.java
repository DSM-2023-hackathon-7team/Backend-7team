package com.example.backend7team.domain.likes.service;

import com.example.backend7team.domain.accident.domain.AccidentInformation;
import com.example.backend7team.domain.accident.domain.repository.AccidentRepository;
import com.example.backend7team.domain.accident.exception.AccidentInformationNotFoundException;
import com.example.backend7team.domain.likes.domain.Likes;
import com.example.backend7team.domain.likes.domain.repository.LikesRepository;
import com.example.backend7team.domain.user.domain.User;
import com.example.backend7team.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LikesService {

    private final LikesRepository likesRepository;
    private final AccidentRepository accidentRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long accidentInformationId) {
        User user = userFacade.getCurrentUser();
        AccidentInformation accidentInformation = accidentRepository.queryAccidentInformationById(accidentInformationId)
                        .orElseThrow(() -> AccidentInformationNotFoundException.EXCEPTION);

        likesRepository.queryLikesByUserAndAccidentInformation(user, accidentInformation)
                .ifPresentOrElse(
                        likesRepository::deleteLikes,
                        () -> likesRepository.saveLikes(new Likes(user, accidentInformation))
                );
    }
}
