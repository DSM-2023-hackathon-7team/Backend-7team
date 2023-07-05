package com.example.backend7team.domain.likes.domain.repository;

import com.example.backend7team.domain.accident.domain.AccidentInformation;
import com.example.backend7team.domain.likes.domain.Likes;
import com.example.backend7team.domain.likes.domain.LikesId;
import com.example.backend7team.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikesJpaRepository extends JpaRepository<Likes, LikesId> {

    Optional<Likes> findByUserAndAccidentInformation(User user, AccidentInformation accidentInformation);
}
