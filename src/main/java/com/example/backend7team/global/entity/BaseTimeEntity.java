package com.example.backend7team.global.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@MappedSuperclass
public abstract class BaseTimeEntity {

    @CreatedDate
    @Column(columnDefinition = "DATETIME(6)", updatable = false)
    private LocalDateTime createdAt;
}
