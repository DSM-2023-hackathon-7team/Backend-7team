package com.example.backend7team.domain.likes.domain.repository;

import com.example.backend7team.domain.likes.domain.Likes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class LikesRepository {

    private final LikesJpaRepository likesJpaRepository;

    public void saveLikes(Likes likes) {
        likesJpaRepository.save(likes);
    }
}
