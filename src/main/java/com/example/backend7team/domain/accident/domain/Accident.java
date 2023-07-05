package com.example.backend7team.domain.accident.domain;

import com.example.backend7team.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Accident extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(25)", nullable = false)
    private String title;

    @Column(columnDefinition = "VARCHAR(1000)", nullable = false)
    private String content;

    @Column(columnDefinition = "VARCHAR(300)")
    private String imageUrl;

    @Column(columnDefinition = "BIGINT", nullable = false)
    private Integer views;

    @Builder
    public Accident(String title, String content, String imageUrl, Integer views) {
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.views = views;
    }

    public void addViews() {
        this.views += 1;
    }
}
