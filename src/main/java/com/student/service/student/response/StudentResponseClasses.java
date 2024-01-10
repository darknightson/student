package com.student.service.student.response;

import com.student.domain.student.StudentEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class StudentResponseClasses {
    private String studentId;
    private String memberName;
    private String memberEmail;
    private String age;
    private String departmentName;
    List<DepartmentClassesResponse> departmentClassesResponseList;

    public static StudentResponseClasses toResponse(StudentEntity studentEntity) {
        return StudentResponseClasses.builder()
                .studentId(studentEntity.getStudentId())
                .memberName(studentEntity.getMemberName())
                .memberEmail(studentEntity.getMemberEmail())
                .age(studentEntity.getAge())
                .departmentName(studentEntity.getDepartmentEntity().getDepartmentName())
                .departmentClassesResponseList(
                        studentEntity.getDepartmentClassesEntityList().stream()
                            .map(DepartmentClassesResponse::toResponse).collect(Collectors.toList()))
                .build();
    }
}
