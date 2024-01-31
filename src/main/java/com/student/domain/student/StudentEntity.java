package com.student.domain.student;

import com.student.domain.base.BaseEntity;
import com.student.domain.department.DepartmentEntity;
import com.student.domain.departmentClass.DepartmentClassesEntity;
import com.student.web.controller.request.StudentModifyRequest;
import com.student.web.controller.request.StudentRegisterRequest;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "student")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class  StudentEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memberId")
    private Long id;

    @Column(unique = true)
    private String studentId;

    private String password;

    private String memberName;

    private String memberEmail;

    private String age;

    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private DepartmentEntity departmentEntity;

    @OneToMany(mappedBy = "studentEntity")
    private List<DepartmentClassesEntity> departmentClassesEntityList = new ArrayList<>();

    private String role;

    @Builder
    private StudentEntity(String studentId, String memberName, String memberEmail, String age,
                          String phoneNumber, String password, String role, DepartmentEntity departmentEntity) {
        this.studentId = studentId;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.password = password;
        this.departmentEntity = departmentEntity;
        // 연관관계 메서드
        // departmentEntity.getStudentEntityList().add(this);
    }

    public static StudentEntity createStudent(String studentId, String memberName, String memberEmail, String age,
                                              String phoneNumber, String password,String role, DepartmentEntity departmentEntity) {
        return StudentEntity.builder()
                .studentId(studentId)
                .memberName(memberName)
                .memberEmail(memberEmail)
                .age(age)
                .phoneNumber(phoneNumber)
                .password(password)
                .role(role)
                .departmentEntity(departmentEntity)
                .build();
    }

    public static StudentEntity toEntity(StudentRegisterRequest studentRegisterRequest
            , DepartmentEntity departmentEntity
            , PasswordEncoder passwordEncoder) {
        return StudentEntity.builder()
                .studentId(studentRegisterRequest.getMemberId())
                .memberName(studentRegisterRequest.getMemberName())
                .memberEmail(studentRegisterRequest.getMemberEmail())
                .age(studentRegisterRequest.getAge())
                .password(passwordEncoder.encode(studentRegisterRequest.getPassword()))
                .departmentEntity(departmentEntity)
                .role("ROLE_STUDENT")
                .build();
    }

    public void updateStudent(StudentModifyRequest studentModifyRequest, DepartmentEntity departmentEntity) {
        this.memberName = studentModifyRequest.getMemberName();
        this.memberEmail = studentModifyRequest.getMemberEmail();
        this.age = studentModifyRequest.getAge();
        this.departmentEntity = departmentEntity;
    }
}
