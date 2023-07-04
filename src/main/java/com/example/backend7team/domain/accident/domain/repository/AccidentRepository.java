package com.example.backend7team.domain.accident.domain.repository;

import com.example.backend7team.domain.accident.domain.AccidentInformation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class AccidentRepository {

    private final AccidentInformationJpaRepository accidentInformationJpaRepository;

    public void saveAccidentInformation(AccidentInformation accidentInformation) {
        accidentInformationJpaRepository.save(accidentInformation);
    }
}
