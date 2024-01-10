package com.student.api.controller.student;

import com.student.api.controller.student.request.StudentQueryRequest;
import com.student.api.response.ApiResponse;
import com.student.config.aop.AutoValidator;
import com.student.dto.StudentDepartmentDto;
import com.student.service.student.StudentService;
import com.student.service.student.response.StudentResponse;
import com.student.web.controller.request.StudentModifyRequest;
import com.student.web.controller.request.StudentRegisterRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentApiController {

    private final StudentService studentService;

    /**
     * 학생 목록 조회
     */
    @GetMapping
    public ResponseEntity<ApiResponse> findStudents(@ModelAttribute StudentQueryRequest studentQueryRequest,
                                          @RequestParam("draw") int draw, Pageable pageable) {
        Page<StudentDepartmentDto> students = studentService.findStudents(studentQueryRequest, pageable);
        return ResponseEntity.ok(ApiResponse.of(HttpStatus.OK, draw, students.getTotalElements(), students.getTotalElements(), students.getContent()));
    }

    /**
     * 학생등록
     */
    @AutoValidator
    @PostMapping
    public ResponseEntity<ApiResponse> createStudent(@RequestBody @Valid StudentRegisterRequest studentRegisterRequest, BindingResult bindingResult) {
        StudentResponse response = studentService.saveStudent(studentRegisterRequest);
        return ResponseEntity.ok(ApiResponse.of(HttpStatus.CREATED, response));
    }

    /**
     * 학생정보 수정
     */

    @PutMapping("/{studentId}")
    public ResponseEntity<ApiResponse> updateStudent(@PathVariable("studentId") String studentId,
                                                                      @RequestBody @Valid StudentModifyRequest studentModifyRequest,
                                                                      BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(ApiResponse.bindError("수정에 실패하였습니다.", bindingResult));
        }
        studentModifyRequest.setStudentId(studentId);
        StudentResponse studentResponse = studentService.modifyStudent(studentModifyRequest);
        return ResponseEntity.ok(ApiResponse.of(HttpStatus.OK, studentResponse));
    }

    /**
     * 학생정보 삭제
     */
    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("studentId") String studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok().build();
    }
}
