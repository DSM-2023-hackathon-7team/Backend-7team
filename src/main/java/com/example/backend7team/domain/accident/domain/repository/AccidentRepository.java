package com.example.backend7team.domain.accident.domain.repository;

import com.example.backend7team.domain.accident.domain.AccidentInformation;
import com.example.backend7team.domain.accident.domain.repository.vo.QQueryAccidentInformationVO;
import com.example.backend7team.domain.accident.domain.repository.vo.QueryAccidentInformationVO;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.backend7team.domain.accident.domain.QAccidentInformation.accidentInformation;
import static com.example.backend7team.domain.user.domain.QUser.user;

@RequiredArgsConstructor
@Repository
public class AccidentRepository {

    private final AccidentInformationJpaRepository accidentInformationJpaRepository;
    private final JPAQueryFactory queryFactory;

    public void saveAccidentInformation(AccidentInformation accidentInformation) {
        accidentInformationJpaRepository.save(accidentInformation);
    }

    public Optional<AccidentInformation> queryAccidentInformationById(Long id) {
        return accidentInformationJpaRepository.findById(id);
    }

    public List<QueryAccidentInformationVO> queryAccidentInformationListByConditions(String title) {
        return queryFactory
                .select(
                        new QQueryAccidentInformationVO(
                                accidentInformation.title,
                                accidentInformation.content,
                                accidentInformation.imageUrl
                        )
                )
                .from(accidentInformation)
                .join(accidentInformation.user, user)
                .where(containsTitle(title))
                .orderBy(accidentInformation.createdAt.desc())
                //TODO 좋아요순 정렬추가
                .fetch();
    }

    //===condition===//

    private BooleanExpression containsTitle(String title) {
        return title == null ? null : accidentInformation.title.contains(title);
    }
}