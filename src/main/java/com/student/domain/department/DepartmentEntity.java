package com.student.domain.department;

import com.student.domain.base.BaseEntity;
import com.student.domain.student.StudentEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DepartmentEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long id;

    private String departmentName;

    private String departmentCode;

    @OneToMany(mappedBy = "departmentEntity")
    private List<StudentEntity> studentEntityList = new ArrayList<>();

    @Builder
    private DepartmentEntity(String departmentName, String departmentCode, List<StudentEntity> studentEntityList) {
        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
        //this.studentEntityList = studentEntityList;
        this.studentEntityList = studentEntityList != null ? studentEntityList : new ArrayList<>();
    }

    public static DepartmentEntity createDepartment(String departmentName, String departmentCode, List<StudentEntity> studentEntityList) {
        return DepartmentEntity.builder()
                .departmentName(departmentName)
                .departmentCode(departmentCode)
                .studentEntityList(studentEntityList)
                .build();
    }
}
