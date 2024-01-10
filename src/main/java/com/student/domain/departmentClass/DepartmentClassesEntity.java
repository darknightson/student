package com.student.domain.departmentClass;

import com.student.domain.base.BaseEntity;
import com.student.domain.student.StudentEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "department_class")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DepartmentClassesEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_class_id")
    private Long id;

    private String departmentClassName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private StudentEntity studentEntity;

    @Builder
    private DepartmentClassesEntity(String departmentClassName, StudentEntity studentEntity) {
        this.departmentClassName = departmentClassName;
        this.studentEntity = studentEntity;
    }

    public static DepartmentClassesEntity createDepartmentClassesEntity(String departmentClassName, StudentEntity studentEntity) {
        return DepartmentClassesEntity.builder()
                .departmentClassName(departmentClassName)
                .studentEntity(studentEntity)
                .build();
    }
}
