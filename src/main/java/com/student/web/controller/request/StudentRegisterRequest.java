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
public class StudentRegisterRequest {

    @NotBlank(message = "ID 는 필수값입니다.")
    private String memberId;

    @NotBlank(message = "이름은 필수값입니다.")
    private String memberName;

    @NotBlank(message = "비밀번호는 필수값입니다.")
    private String password;

    @Email
    @NotBlank(message = "이메일은 필수값입니다.")
    private String memberEmail;

    @Pattern(regexp = "^[0-9]+$", message = "숫자만 입력 가능합니다.")
    private String age;


    @NotNull(message = "학과는 필수 값 입니다.")
    private DepartmentEnums departmentEnums;

    //@Pattern(regexp = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$", message = "올바른 핸드폰 번호 형식이 아닙니다.")
    //private String phoneNumber;
}
