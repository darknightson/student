package com.student.service.department;

import com.student.domain.department.DepartmentEntity;
import com.student.repository.department.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentEntity getDepartment(Long departmentId) {
        return departmentRepository.findById(departmentId).orElseThrow();
    }
}
