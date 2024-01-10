package com.student.lecture;

public class UserService {

    public void save () {
        UserDataBaseRepository userDataBaseRepository = new UserDataBaseRepository();
        userDataBaseRepository.createUser(new UserDto("user a", "password123", 20));
    }
}
