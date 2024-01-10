package com.student.service.student;

import com.student.api.controller.student.request.StudentQueryRequest;
import com.student.domain.department.DepartmentEntity;
import com.student.domain.student.StudentEntity;
import com.student.dto.StudentDepartmentDto;
import com.student.exception.ErrorMessage;
import com.student.exception.MemberNotFoundException;
import com.student.repository.department.DepartmentRepository;
import com.student.repository.student.StudentRepository;
import com.student.service.student.response.StudentResponse;
import com.student.service.student.response.StudentResponseClasses;
import com.student.web.controller.request.StudentModifyRequest;
import com.student.web.controller.request.StudentRegisterRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentService {

    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;
    private final PasswordEncoder passwordEncoder;

    public StudentResponse findByStudentId(String studentId) {
        StudentEntity studentEntity = studentRepository.findByStudentId(studentId).orElseThrow(
                () -> new MemberNotFoundException(ErrorMessage.STUDENT_NOT_FOUND.getMessage()));
        return StudentResponse.toResponse(studentEntity);
    }

    public Page<StudentDepartmentDto> findStudents(StudentQueryRequest studentQueryRequest, Pageable pageable) {
        return studentRepository.findDepartmentStudents(studentQueryRequest.getDepartmentName(),
                studentQueryRequest.getMemberName(), pageable);
    }

    @Transactional
    public StudentResponse saveStudent(StudentRegisterRequest studentRegisterRequest) {
        String departmentCode = studentRegisterRequest.getDepartmentEnums().name();
        DepartmentEntity departmentEntity = departmentRepository.findByDepartmentCode(departmentCode);
        StudentEntity studentEntity = StudentEntity.toEntity(studentRegisterRequest, departmentEntity, passwordEncoder);
        StudentEntity createStudentEntity = studentRepository.save(studentEntity);
        StudentEntity findStudent = studentRepository.findByStudentId(createStudentEntity.getStudentId()).orElseThrow();
        return StudentResponse.toResponse(findStudent);
    }

    @Transactional
    public StudentResponse modifyStudent(StudentModifyRequest studentModifyRequest) {
        StudentEntity studentEntity = studentRepository.findByStudentId(studentModifyRequest.getStudentId()).orElseThrow(
                () -> new MemberNotFoundException(ErrorMessage.STUDENT_NOT_FOUND.getMessage()));
        DepartmentEntity departmentEntity = departmentRepository.findByDepartmentCode(studentModifyRequest.getDepartmentEnums().name());
        // 변경 감지
        studentEntity.updateStudent(studentModifyRequest, departmentEntity);
        return StudentResponse.toResponse(studentEntity);
    }

    @Transactional
    public void deleteStudent(String studentId) {
        StudentEntity studentEntity = studentRepository.findByStudentId(studentId).orElseThrow(
                () -> new MemberNotFoundException(ErrorMessage.STUDENT_NOT_FOUND.getMessage()));
        studentRepository.delete(studentEntity);
    }

    public StudentResponseClasses findStudentClasses(String studentId) {
        Optional<StudentEntity> studentEntity = studentRepository.findByStudentId(studentId);
        if (studentEntity.isEmpty()) {
            throw new MemberNotFoundException(ErrorMessage.STUDENT_NOT_FOUND.getMessage());
        }
        return StudentResponseClasses.toResponse(studentEntity.get());
    }

    public void findStudentFetch(String studentId) {
        List<StudentEntity> studentFetch = studentRepository.findStudentFetch(studentId);
        System.out.println("studentFetch = " + studentFetch);
    }
}
