package com.example.backend7team.domain.accident.domain;

import com.example.backend7team.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class AccidentInformation extends BaseTimeEntity {

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
    private Long views;

    @Column(columnDefinition = "TINYINT(1)", nullable = false)
    private Boolean isVerified;

    @Builder
    public AccidentInformation(String title, String content, String imageUrl, Long views, Boolean isVerified) {
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.views = views;
        this.isVerified = isVerified;
    }
}
