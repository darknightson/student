package com.student.web.controller.request;

import com.student.web.constant.DepartmentEnums;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
public class StudentModifyRequest {

    @NotBlank(message = "ID 는 필수값입니다.")
    private String studentId;

    @NotBlank(message = "이름은 필수값입니다.")
    private String memberName;

    @Email
    @NotBlank(message = "이메일은 필수값입니다.")
    private String memberEmail;

    @Pattern(regexp = "^[0-9]+$", message = "숫자만 입력 가능합니다.")
    private String age;


    @NotNull(message = "학과는 필수 값 입니다.")
    private DepartmentEnums departmentEnums;

    private String departmentName;
}
