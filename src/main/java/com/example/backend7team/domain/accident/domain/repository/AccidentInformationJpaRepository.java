package com.example.backend7team.domain.accident.domain.repository;


import com.example.backend7team.domain.accident.domain.AccidentInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccidentInformationJpaRepository extends JpaRepository<AccidentInformation, Long> {
}
