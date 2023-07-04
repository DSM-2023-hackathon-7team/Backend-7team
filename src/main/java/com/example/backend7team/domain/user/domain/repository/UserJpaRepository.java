package com.example.backend7team.domain.user.domain.repository;

import com.example.backend7team.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserJpaRepository extends CrudRepository<User, Long> {

    Optional<User> findByAccountId(String accountId);

    boolean existsByAccountId(String accountId);
}
