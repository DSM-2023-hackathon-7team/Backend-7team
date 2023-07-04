package com.example.backend7team.domain.user.domain.repository;

import com.example.backend7team.domain.user.domain.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, String> {
}
