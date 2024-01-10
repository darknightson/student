package com.student.service.student.response;

import com.student.domain.departmentClass.DepartmentClassesEntity;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.internal.engine.MethodValidationConfiguration;

@Data
@Builder
public class DepartmentClassesResponse {
    private String departmentClassesName;

    public static DepartmentClassesResponse toResponse(DepartmentClassesEntity departmentClassesEntity) {
        return DepartmentClassesResponse.builder()
                .departmentClassesName(departmentClassesEntity.getDepartmentClassName())
                .build();
    }
}
