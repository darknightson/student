package com.student.security.service;

import com.student.domain.student.StudentEntity;
import com.student.repository.student.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String studentId) throws UsernameNotFoundException {
        StudentEntity studentEntity = studentRepository.findByStudentId(studentId).orElseThrow(() -> new BadCredentialsException(studentId));
        return new AccountContext(studentEntity, List.of(new SimpleGrantedAuthority(studentEntity.getRole())));
    }
}
