package com.example.backend7team.domain.comment.domain.repository;

import com.example.backend7team.domain.comment.domain.Comment;
import com.example.backend7team.domain.comment.domain.repository.vo.QQueryCommentVO;
import com.example.backend7team.domain.comment.domain.repository.vo.QueryCommentVO;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.backend7team.domain.accident.domain.QAccident.accident;
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

    public List<QueryCommentVO> queryAccidentInformationCommentList(Long accidentInformationId) {
        return queryFactory
                .select(
                        new QQueryCommentVO(
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

    public List<QueryCommentVO> queryAccidentCommentList(Long accidentId) {
        return queryFactory
                .select(
                        new QQueryCommentVO(
                                user.name,
                                comment.content
                        )
                )
                .from(accident)
                .join(accident.comments, comment)
                .join(comment.user, user)
                .where(accident.id.eq(accidentId))
                .orderBy(comment.createdAt.desc())
                .fetch();
    }
}
