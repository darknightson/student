package com.student.repository.student;

import com.student.domain.department.DepartmentEntity;
import com.student.domain.student.StudentEntity;
import com.student.repository.department.DepartmentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {

        DepartmentEntity departmentEntity = DepartmentEntity.builder()
                .departmentCode("DEPT01")
                .departmentName("빅데이터학과")
                .build();

        departmentRepository.save(departmentEntity);

        StudentEntity studentEntity = StudentEntity.builder()
                .studentId("anthony123")
                .memberName("안토니")
                .memberEmail("anthony@kakaoent.com")
                .age("28")
                .phoneNumber("010-1234-5678")
                .departmentEntity(departmentEntity)
                .build();
        studentRepository.save(studentEntity);

    }

    @AfterEach
    void tearDown() {
        studentRepository.deleteAll();
    }

    @DisplayName("학생 한명을 조회 합니다.")
    @Test
    void findStudent() {
        // given
        String studentId = "anthony123";
        // when
        StudentEntity findStudent = studentRepository.findByStudentId(studentId).orElseThrow();
        // then
        assertThat(findStudent.getStudentId()).isEqualTo(studentId);

        assertThat(findStudent)
                .extracting("studentId", "memberName")
                .containsExactly("anthony123", "안토니");
    }

    @DisplayName("FETCH JOIN 으로 조회 합니다.")
    @Test
    void findAllFetchJoinStudent() {

        // given & when
        List<StudentEntity> allStudent = studentRepository.findAllStudent();
        // then
        assertThat(allStudent.size()).isEqualTo(1);
    }

    @DisplayName("")
    @Test
    void Test() {

        // given
        String memberName = "anthony";
        // when
        StudentEntity byMemberName = studentRepository.findByMemberName(memberName).orElseThrow();

        // then
        assertThat(byMemberName.getMemberName()).isEqualTo(memberName);
    }


}