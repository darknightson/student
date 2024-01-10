package com.student.lecture;

import com.student.domain.student.StudentEntity;
import com.student.repository.student.StudentRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StudentServiceImpl {

    private final StudentRepository studentRepository;

    public void createStudent() {}
    public StudentEntity findStudent() { return null; }
}
