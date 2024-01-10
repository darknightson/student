package com.student.lecture;

import lombok.Data;
import lombok.Getter;

@Data
public class UserDto {

    String username;
    String password;
    int age;

    public UserDto(String username, String password, int age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }
}
