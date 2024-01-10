package com.student.security.service;

import com.student.domain.student.StudentEntity;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
public class AccountContext extends User {

    private final StudentEntity studentEntity;

    public AccountContext(StudentEntity studentEntity, Collection<? extends GrantedAuthority> authorities) {
        super(studentEntity.getStudentId(), studentEntity.getPassword(), authorities);
         this.studentEntity = studentEntity;
    }
}

