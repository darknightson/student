package com.student.web.controller;

import com.student.service.student.StudentService;
import com.student.service.student.response.StudentResponse;
import com.student.web.constant.DepartmentEnums;
import com.student.web.controller.request.StudentModifyRequest;
import com.student.web.controller.request.StudentRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @ModelAttribute("departmentEnums")
    public DepartmentEnums[] departmentEnums() { return DepartmentEnums.values();}


    /**
     * 학생 등록 화면
     */
    @GetMapping("/admin/student/register")
    public String registerStudentForm (Model model) {
        model.addAttribute("studentRegisterRequest", new StudentRegisterRequest());
        return "student/studentRegisterForm";
    }

    /**
     * 학생 등록
     */
    @PostMapping("/admin/student/register")
    public String registerStudent(@Valid StudentRegisterRequest studentRegisterRequest, BindingResult bindingResult) {
        if ( bindingResult.hasErrors() ) {
            return "student/studentRegisterForm";
        }
        studentService.saveStudent(studentRegisterRequest);
        return "redirect:/";
    }

    /**
     * 학생 상세 회면
     */
    @GetMapping("/student/detail/{studentId}")
    public String detailStudent(@PathVariable("studentId") String studentId, Model model) {
        StudentResponse response = studentService.findByStudentId(studentId);
        model.addAttribute("student", response);
        return "student/studentDetail";
    }

    /**
     * 학생 수정 화면
     */
    @GetMapping("/admin/student/{studentId}")
    public String updateStudentForm (@PathVariable("studentId") String studentId, Model model) {
        StudentResponse response = studentService.findByStudentId(studentId);
        model.addAttribute("student", response);
        return "student/studentModifyForm";
    }

    /**
     * 학생 수정
     */
    @PostMapping("/admin/student/update")
    public String updateStudent(@Valid @ModelAttribute("student") StudentModifyRequest studentModifyRequest, BindingResult bindingResult,
                                Model model) {
        if ( bindingResult.hasErrors() ) {
            // 학과에 대한 데이터를 모델에 추가
            List<DepartmentEnums> departmentEnumsList = Arrays.asList(DepartmentEnums.values());
            model.addAttribute("departmentEnums", departmentEnumsList);

            return "student/studentModifyForm";
        }
        StudentResponse studentResponse = studentService.modifyStudent(studentModifyRequest);
        return "redirect:/student/detail/" + studentResponse.getStudentId();
    }

    @PostMapping("/admin/student/delete/{studentId}")
    public String deleteStudent(@PathVariable("studentId") String studentId) {
        studentService.deleteStudent(studentId);
        return "redirect:/";
    }

}
