package com.student.repository.student.customQuery;

import com.student.dto.StudentDepartmentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentRepositoryCustom {
    Page<StudentDepartmentDto> findDepartmentStudents(String departmentName, String studentId, Pageable pageable);
}
