package com.student.service.student;

import com.student.exception.MemberNotFoundException;
import com.student.service.student.response.StudentResponse;
import com.student.service.student.response.StudentResponseClasses;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @DisplayName("유저가 없을경우에 MemberNotFoundException 이 발생한다.")
    @Test
    void findStudentThrowMemberNotFoundException() {

        // given
        String studentId = "user not found";

        // when & then
        assertThrows(MemberNotFoundException.class, () -> studentService.findByStudentId(studentId));
    }

    @DisplayName("")
    @Test
    void Test() {

        // given
        StudentResponseClasses anthony = studentService.findStudentClasses("anthony");

        // when

        // then
    }

    @Test
    void Test1() {

        studentService.findStudentFetch("anthony");
    }

}