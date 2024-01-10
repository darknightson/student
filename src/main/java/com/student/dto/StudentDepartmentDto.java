package com.student.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StudentDepartmentDto {

    private String studentId;
    private String memberName;
    private String memberEmail;
    private String departmentName;
    private String departmentCode;
    private LocalDateTime createdAt;
}
