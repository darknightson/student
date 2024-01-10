package com.student.repository;

import com.student.domain.departmentClass.DepartmentClassesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentClassesRepository extends JpaRepository<DepartmentClassesEntity, Long> {
}
