package com.example.backend7team.domain.accident.service;

import com.example.backend7team.domain.accident.domain.AccidentInformation;
import com.example.backend7team.domain.accident.domain.repository.AccidentRepository;
import com.example.backend7team.domain.accident.presentation.dto.request.CreateAccidentInformationRequest;
import com.example.backend7team.domain.user.domain.User;
import com.example.backend7team.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateAccidentInformationService {

    private final AccidentRepository accidentRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(CreateAccidentInformationRequest request) {
        User user = userFacade.getCurrentUser();

        accidentRepository.saveAccidentInformation(
                AccidentInformation.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .imageUrl(request.getImageUrl())
                        .views(0)
                        .isVerified(false)
                        .user(user)
                        .build()
        );
    }
}
