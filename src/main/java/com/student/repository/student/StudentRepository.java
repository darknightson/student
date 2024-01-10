package com.student.repository.student;

import com.student.domain.student.StudentEntity;
import com.student.repository.student.customQuery.StudentRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentEntity, Long>, StudentRepositoryCustom {
    Optional<StudentEntity> findByStudentId(String studentId);

    @Query( "select s" +
            "  from StudentEntity s " +
            "  join fetch DepartmentEntity d" +
            "  join fetch DepartmentClassesEntity dc")
    List<StudentEntity>findStudentFetch(String studentId);

    @Query( "select s " +
            "  from StudentEntity s" +
            "  join fetch s.departmentEntity d" +
            " order by s.createdAt desc")
    List<StudentEntity> findAllStudent();

    @Query( "select s.memberName " +
            "  from StudentEntity s" +
            " where s.studentId = :studentId")
    Optional<String> findStudentName(String studentId);

    Optional<StudentEntity> findByMemberName(String memberName);

}
