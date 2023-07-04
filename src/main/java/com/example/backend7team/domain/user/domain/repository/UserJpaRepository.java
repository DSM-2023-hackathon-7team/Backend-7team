package com.example.backend7team.domain.user.domain.repository;

import com.example.backend7team.domain.user.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserJpaRepository extends CrudRepository<User, Long> {
}
