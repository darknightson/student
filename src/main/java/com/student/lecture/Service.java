package com.student.lecture;

import com.student.domain.department.DepartmentEntity;
import com.student.domain.student.StudentEntity;
import com.student.repository.department.DepartmentRepository;
import com.student.repository.student.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.util.StringUtils;

import java.io.File;

@RequiredArgsConstructor
public class Service {

    public void method(ParentClass parentClass) {
        parentClass.method(-1);
    }

//
//
//    private final UserDataBaseRepository userDataBaseRepository;
//    private final UserMemoryRepository userMemoryRepository;
//    private final FileRepository fileRepository;
//
//    public void createStudent(String routingKey, UserDto userDto) {
//        if (StringUtils.hasText(routingKey)) {
//            if (routingKey.equals("database")) {
//                userDataBaseRepository.createUser(userDto);
//            } else if (routingKey.equals("memory")) {
//                userMemoryRepository.createUser(userDto);
//            } else if (routingKey.equals("file")) {
//                fileRepository.createUser(userDto);
//            }
//        }
//    }
//
//    public void createDepartment() {}
//    public DepartmentEntity findDepartment() { return null; }



}
