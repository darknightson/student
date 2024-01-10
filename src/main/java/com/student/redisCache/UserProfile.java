package com.student.redisCache;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserProfile implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private int age;

    public UserProfile(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
