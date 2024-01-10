package com.student.domain.student;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public enum StudentEnums {

    CURRENT_STUDENT("재학생"),
    STUDENT_ON_LEAVE("휴학생");

    private final String text;

    public static List<StudentEnums> forDisplay() {
        return List.of(CURRENT_STUDENT, STUDENT_ON_LEAVE);
    }

}
