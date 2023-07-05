package com.example.backend7team.domain.accident.service;

import com.example.backend7team.domain.accident.domain.Accident;
import com.example.backend7team.domain.accident.domain.repository.AccidentRepository;
import com.example.backend7team.domain.accident.presentation.dto.request.CreateAccidentRequest;
import com.example.backend7team.domain.user.domain.User;
import com.example.backend7team.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateAccidentService {

    private final AccidentRepository accidentRepository;
    private final UserFacade userFacade;

    @Transactional
    public void execute(CreateAccidentRequest request) {
        User user = userFacade.getCurrentUser();

        accidentRepository.saveAccident(
                Accident.builder()
                        .title(request.getTitle())
                        .content(request.getContent())
                        .imageUrl(request.getImageUrl())
                        .views(0)
                        .user(user)
                        .build()
        );
    }
}
