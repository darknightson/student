package com.student.api.controller.department;

import com.student.domain.department.DepartmentEntity;
import com.student.service.department.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/api/v1/department")
    public DepartmentEntity getDepartment() {

        DepartmentEntity department = departmentService.getDepartment(1L);

        department.getStudentEntityList().forEach(studentEntity -> {
            System.out.println("studentEntity = " + studentEntity);
        });

        return department;
    }
}
