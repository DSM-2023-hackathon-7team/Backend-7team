package com.example.backend7team.domain.likes.domain.repository;

import com.example.backend7team.domain.likes.domain.Likes;
import com.example.backend7team.domain.likes.domain.LikesId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesJpaRepository extends JpaRepository<Likes, LikesId> {
}
