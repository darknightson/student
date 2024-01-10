package com.student.exception;

import lombok.Getter;

@Getter
public enum ErrorMessage {

    STUDENT_NOT_FOUND("학생 정보가 존재하지 않습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }
}
