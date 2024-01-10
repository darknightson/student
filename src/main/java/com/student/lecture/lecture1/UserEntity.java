package com.student.lecture.lecture1;

import com.student.lecture.UserDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String username;

    private int age;

    @Builder
    private UserEntity(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public static UserEntity createUser(UserDto userDto) {
        return UserEntity.builder()
                .username(userDto.getUsername())
                .age(userDto.getAge())
                .build();
    }

    public void update(UserDto userDto) {
        this.username = userDto.getUsername();
        this.age = userDto.getAge();
    }
}
