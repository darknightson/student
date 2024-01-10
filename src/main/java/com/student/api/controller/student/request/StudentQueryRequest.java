package com.student.api.controller.student.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentQueryRequest {

    private String memberName;
    private String departmentName;
}
