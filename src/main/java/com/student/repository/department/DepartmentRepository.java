package com.student.repository.department;

import com.student.domain.department.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {

    DepartmentEntity findByDepartmentCode(String departmentCode);
}
