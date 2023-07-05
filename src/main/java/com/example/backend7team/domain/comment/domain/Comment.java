package com.example.backend7team.domain.comment.domain;

import com.example.backend7team.domain.accident.domain.Accident;
import com.example.backend7team.domain.accident.domain.AccidentInformation;
import com.example.backend7team.domain.user.domain.User;
import com.example.backend7team.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(500)", nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accident_id")
    private Accident accident;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accident_information_id")
    private AccidentInformation accidentInformation;

    @Builder
    public Comment(String content, User user, Accident accident, AccidentInformation accidentInformation) {
        this.content = content;
        this.user = user;
        this.accident = accident;
        this.accidentInformation = accidentInformation;
    }
}
