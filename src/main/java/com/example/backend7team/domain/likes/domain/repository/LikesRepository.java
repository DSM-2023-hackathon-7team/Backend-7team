package com.example.backend7team.domain.likes.domain.repository;

import com.example.backend7team.domain.accident.domain.AccidentInformation;
import com.example.backend7team.domain.likes.domain.Likes;
import com.example.backend7team.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class LikesRepository {

    private final LikesJpaRepository likesJpaRepository;

    public void saveLikes(Likes likes) {
        likesJpaRepository.save(likes);
    }

    public void deleteLikes(Likes likes) {
        likesJpaRepository.delete(likes);
    }

    public Optional<Likes> queryLikesByUserAndAccidentInformation(User user, AccidentInformation accidentInformation) {
        return likesJpaRepository.findByUserAndAccidentInformation(user, accidentInformation);
    }
}
