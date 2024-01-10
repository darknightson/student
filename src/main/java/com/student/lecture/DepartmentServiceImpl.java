package com.student.lecture;

import com.student.domain.department.DepartmentEntity;
import com.student.repository.department.DepartmentRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DepartmentServiceImpl {

    private final DepartmentRepository departmentRepository;

    public void createDepartment() {}
    public DepartmentEntity findDepartment() { return null; }
}
