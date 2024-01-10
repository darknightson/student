package com.student.redisCache;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String userId;

    private String username;
    private int age;

    @Builder
    private User(String userId, String username, int age) {
        this.userId = userId;
        this.username = username;
        this.age = age;
    }

    public static User toEntity(String userId, String username, int age) {
        return User.builder()
                .userId(userId)
                .username(username)
                .age(age)
                .build();
    }
}
