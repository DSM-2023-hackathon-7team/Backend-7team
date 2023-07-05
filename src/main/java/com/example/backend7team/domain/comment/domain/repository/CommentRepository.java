package com.example.backend7team.domain.comment.domain.repository;

import com.example.backend7team.domain.comment.domain.Comment;
import com.example.backend7team.domain.comment.domain.repository.vo.QQueryAccidentInformationCommentVO;
import com.example.backend7team.domain.comment.domain.repository.vo.QueryAccidentInformationCommentVO;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.backend7team.domain.accident.domain.QAccidentInformation.accidentInformation;
import static com.example.backend7team.domain.comment.domain.QComment.comment;
import static com.example.backend7team.domain.user.domain.QUser.user;

@RequiredArgsConstructor
@Repository
public class CommentRepository {

    private final CommentJpaRepository commentJpaRepository;
    private final JPAQueryFactory queryFactory;

    public void saveComment(Comment comment) {
        commentJpaRepository.save(comment);
    }

    public List<QueryAccidentInformationCommentVO> queryAccidentInformationCommentList(Long accidentInformationId) {
        return queryFactory
                .select(
                        new QQueryAccidentInformationCommentVO(
                                user.name,
                                comment.content
                        )
                )
                .from(accidentInformation)
                .join(accidentInformation.comments, comment)
                .join(comment.user, user)
                .where(accidentInformation.id.eq(accidentInformationId))
                .orderBy(comment.createdAt.desc())
                .fetch();
    }
}
