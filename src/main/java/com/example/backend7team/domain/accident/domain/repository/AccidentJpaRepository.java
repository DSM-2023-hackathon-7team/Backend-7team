package com.example.backend7team.domain.accident.domain.repository;

import com.example.backend7team.domain.accident.domain.Accident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccidentJpaRepository extends JpaRepository<Accident, Long> {
}
