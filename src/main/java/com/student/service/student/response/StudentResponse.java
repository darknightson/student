package com.student.service.student.response;

import com.student.domain.student.StudentEntity;
import com.student.web.constant.DepartmentEnums;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class StudentResponse {

    private String studentId;
    private String memberName;
    private String memberEmail;
    private String age;
    private String departmentName;
    private DepartmentEnums departmentEnums;

    @Builder
    public StudentResponse(String studentId, String memberName, String memberEmail, String age,
                           String departmentName, DepartmentEnums departmentEnums) {
        this.studentId = studentId;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.departmentName = departmentName;
        this.age = age;
        this.departmentEnums = departmentEnums;
    }

    public static StudentResponse toResponse(StudentEntity studentEntity) {
        DepartmentEnums departmentEnumValue = DepartmentEnums.find(studentEntity.getDepartmentEntity().getDepartmentName());
        return StudentResponse.builder()
                .studentId(studentEntity.getStudentId())
                .memberName(studentEntity.getMemberName())
                .memberEmail(studentEntity.getMemberEmail())
                .age(studentEntity.getAge())
                .departmentName(studentEntity.getDepartmentEntity().getDepartmentName())
                .departmentEnums(departmentEnumValue)
                .build();
    }
}
