package com.example.backend7team.domain.accident.domain;

import com.example.backend7team.domain.likes.domain.Likes;
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
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

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
    private Integer views;

    @Column(columnDefinition = "TINYINT(1)", nullable = false)
    private boolean isVerified;

    @Column(columnDefinition = "INT", nullable = false)
    private Integer likesCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "accidentInformation", orphanRemoval = true)
    private final List<Likes> likesList = new ArrayList<>();

    @Builder
    public AccidentInformation(String title, String content, String imageUrl, Integer views, boolean isVerified, Integer likesCount, User user) {
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.views = views;
        this.isVerified = isVerified;
        this.likesCount = likesCount;
        this.user = user;
    }

    public void addLikesCount() {
        this.likesCount += 1;
    }

    public void subLikesCount() {
        this.likesCount -= 1;
    }
}
