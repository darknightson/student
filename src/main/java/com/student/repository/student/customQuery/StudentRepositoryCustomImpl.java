package com.student.repository.student.customQuery;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.student.domain.department.QDepartmentEntity;
import com.student.dto.StudentDepartmentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.student.domain.department.QDepartmentEntity.departmentEntity;
import static com.student.domain.student.QStudentEntity.studentEntity;

@RequiredArgsConstructor
public class StudentRepositoryCustomImpl implements StudentRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    @Override
    public Page<StudentDepartmentDto> findDepartmentStudents(String departmentName, String memberName, Pageable pageable) {

        QDepartmentEntity departmentEntity = QDepartmentEntity.departmentEntity;

        List<StudentDepartmentDto> contents = queryFactory
                .select(
                        Projections.fields(StudentDepartmentDto.class,
                                studentEntity.studentId,
                                studentEntity.memberName,
                                studentEntity.memberEmail,
                                departmentEntity.departmentName,
                                departmentEntity.departmentCode,
                                studentEntity.createdAt
                        )
                )
                .from(studentEntity)
                .join(studentEntity.departmentEntity, departmentEntity)
                .where(
                        memberNameEq(memberName), departmentNameEq(departmentName)
                )
                .orderBy(studentEntity.createdAt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<StudentDepartmentDto> countQuery = queryFactory
                .select(
                        Projections.fields(StudentDepartmentDto.class,
                                studentEntity.studentId,
                                studentEntity.memberName,
                                studentEntity.memberEmail,
                                departmentEntity.departmentName,
                                departmentEntity.departmentCode,
                                studentEntity.createdAt
                        )
                )
                .from(studentEntity)
                .join(studentEntity.departmentEntity, departmentEntity)
                .where(
                        memberNameEq(memberName), departmentNameEq(departmentName)
                );

        return PageableExecutionUtils.getPage(contents, pageable, countQuery::fetchCount);

    }

    private BooleanExpression departmentNameEq(String departmentName) {
        if (StringUtils.hasText(departmentName)) {
            return departmentEntity.departmentName.eq(departmentName);
        }
        return null;
    }

    private BooleanExpression memberNameEq(String memberName) {
        if ( StringUtils.hasText(memberName)) {
            return studentEntity.memberName.eq(memberName);
        }
        return null;
    }
}
