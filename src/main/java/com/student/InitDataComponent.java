package com.student;

import com.student.domain.department.DepartmentEntity;
import com.student.domain.departmentClass.DepartmentClassesEntity;
import com.student.domain.student.StudentEntity;
import com.student.redisCache.User;
import com.student.redisCache.UserRepository;
import com.student.repository.DepartmentClassesRepository;
import com.student.repository.department.DepartmentRepository;
import com.student.repository.student.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class InitDataComponent {

    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;
    private final DepartmentClassesRepository departmentClassesRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void initDataSetting() {
        DepartmentEntity departmentEntity = DepartmentEntity.builder()
                .departmentCode("DEPT01")
                .departmentName("빅데이터학과")
                .build();

        departmentRepository.save(departmentEntity);

        DepartmentEntity departmentEntity1 = DepartmentEntity.builder()
                .departmentCode("DEPT02")
                .departmentName("디자인학과")
                .build();

        departmentRepository.save(departmentEntity);
        departmentRepository.save(departmentEntity1);




        String password = "1234";
        StudentEntity studentEntity = StudentEntity.builder()
                .studentId("anthony")
                .password(passwordEncoder.encode(password))
                .memberName("안토니")
                .memberEmail("anthony@kakaoent.com")
                .phoneNumber("010-1234-5678")
                .age("27")
                .role("ROLE_ADMIN")
                .departmentEntity(departmentEntity)
                .build();
        studentRepository.save(studentEntity);

        StudentEntity studentEntity1 = StudentEntity.builder()
                .studentId("anthony1")
                .password(passwordEncoder.encode(password))
                .memberName("안토니")
                .memberEmail("anthony@kakaoent.com")
                .phoneNumber("010-1234-5678")
                .age("27")
                .role("ROLE_ADMIN")
                .departmentEntity(departmentEntity)
                .build();
        studentRepository.save(studentEntity1);

        StudentEntity studentEntity2 = StudentEntity.builder()
                .studentId("anthony2")
                .password(passwordEncoder.encode(password))
                .memberName("안토니")
                .memberEmail("anthony@kakaoent.com")
                .phoneNumber("010-1234-5678")
                .age("27")
                .role("ROLE_ADMIN")
                .departmentEntity(departmentEntity)
                .build();
        studentRepository.save(studentEntity2);


        StudentEntity studentEntity3 = StudentEntity.builder()
                .studentId("jisu")
                .password(passwordEncoder.encode(password))
                .memberName("지수")
                .memberEmail("jisu@kakaoent.com")
                .phoneNumber("010-1234-5678")
                .age("27")
                .role("ROLE_USER")
                .departmentEntity(departmentEntity1)
                .build();
        studentRepository.save(studentEntity3);

        StudentEntity studentEntity4 = StudentEntity.builder()
                .studentId("test")
                .password(passwordEncoder.encode(password))
                .memberName("테스트")
                .memberEmail("jisu@kakaoent.com")
                .phoneNumber("010-1234-5678")
                .age("27")
                .role("ROLE_USER")
                .departmentEntity(departmentEntity1)
                .build();
        studentRepository.save(studentEntity4);

        StudentEntity studentEntity5 = StudentEntity.builder()
                .studentId("test1")
                .password(passwordEncoder.encode(password))
                .memberName("테스트1")
                .memberEmail("jisu@kakaoent.com")
                .phoneNumber("010-1234-5678")
                .age("27")
                .role("ROLE_USER")
                .departmentEntity(departmentEntity1)
                .build();
        studentRepository.save(studentEntity5);

        StudentEntity studentEntity6 = StudentEntity.builder()
                .studentId("test2")
                .password(passwordEncoder.encode(password))
                .memberName("테스트2")
                .memberEmail("jisu@kakaoent.com")
                .phoneNumber("010-1234-5678")
                .age("27")
                .role("ROLE_USER")
                .departmentEntity(departmentEntity1)
                .build();
        studentRepository.save(studentEntity6);

        StudentEntity studentEntity7 = StudentEntity.builder()
                .studentId("test3")
                .password(passwordEncoder.encode(password))
                .memberName("테스트3")
                .memberEmail("jisu@kakaoent.com")
                .phoneNumber("010-1234-5678")
                .age("27")
                .role("ROLE_USER")
                .departmentEntity(departmentEntity1)
                .build();
        studentRepository.save(studentEntity7);

        StudentEntity studentEntity8 = StudentEntity.builder()
                .studentId("test4")
                .password(passwordEncoder.encode(password))
                .memberName("테스트4")
                .memberEmail("jisu@kakaoent.com")
                .phoneNumber("010-1234-5678")
                .age("27")
                .role("ROLE_USER")
                .departmentEntity(departmentEntity1)
                .build();
        studentRepository.save(studentEntity8);

        StudentEntity studentEntity9 = StudentEntity.builder()
                .studentId("test5")
                .password(passwordEncoder.encode(password))
                .memberName("테스트5")
                .memberEmail("jisu@kakaoent.com")
                .phoneNumber("010-1234-5678")
                .age("27")
                .role("ROLE_USER")
                .departmentEntity(departmentEntity1)
                .build();
        studentRepository.save(studentEntity9);

        StudentEntity studentEntity10 = StudentEntity.builder()
                .studentId("test6")
                .password(passwordEncoder.encode(password))
                .memberName("테스트6")
                .memberEmail("jisu@kakaoent.com")
                .phoneNumber("010-1234-5678")
                .age("27")
                .role("ROLE_USER")
                .departmentEntity(departmentEntity1)
                .build();
        studentRepository.save(studentEntity10);

        StudentEntity studentEntity11 = StudentEntity.builder()
                .studentId("test7")
                .password(passwordEncoder.encode(password))
                .memberName("테스트7")
                .memberEmail("jisu@kakaoent.com")
                .phoneNumber("010-1234-5678")
                .age("27")
                .role("ROLE_USER")
                .departmentEntity(departmentEntity1)
                .build();
        studentRepository.save(studentEntity11);


        DepartmentClassesEntity departmentClassesEntity1 = DepartmentClassesEntity.builder()
                .departmentClassName("자바")
                .studentEntity(studentEntity)
                .build();

        DepartmentClassesEntity departmentClassesEntity2 = DepartmentClassesEntity.builder()
                .departmentClassName("오라클")
                .studentEntity(studentEntity)
                .build();
        DepartmentClassesEntity departmentClassesEntity3 = DepartmentClassesEntity.builder()
                .departmentClassName("스프링")
                .studentEntity(studentEntity)
                .build();

        departmentClassesRepository.save(departmentClassesEntity1);
        departmentClassesRepository.save(departmentClassesEntity2);
        departmentClassesRepository.save(departmentClassesEntity3);

        User user = User.builder()
                .userId("test")
                .username("테스트")
                .age(27)
                .build();
        userRepository.save(user);
    }
}
