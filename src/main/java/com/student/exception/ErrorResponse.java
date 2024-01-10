package com.student.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ErrorResponse {

    private LocalDateTime timestamp;
    private String message;
    private String detail;
    private HttpStatus statusCode;

    public ErrorResponse(LocalDateTime timestamp, String message, String detail, HttpStatus statusCode) {
        this.timestamp = timestamp;
        this.message = message;
        this.detail = detail;
        this.statusCode = statusCode;
    }

    public static ErrorResponse of(LocalDateTime timestamp, String message, String detail, HttpStatus statusCode) {
        return new ErrorResponse(timestamp, message, detail, statusCode);
    }
}
