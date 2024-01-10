package com.student.api.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class ApiResponse<T> {

    private int code;
    private HttpStatus httpStatus;
    private String message;
    private int draw;
    private long recordsTotal;
    private long recordsFiltered;
    private T data;

    public ApiResponse(HttpStatus httpStatus, int draw, long recordsTotal, long recordsFiltered, T data) {
        this.code = httpStatus.value();
        this.httpStatus = httpStatus;
        this.draw = draw;
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsFiltered;
        this.data = data;
    }

    public ApiResponse(HttpStatus httpStatus, T data) {
        this.code = httpStatus.value();
        this.httpStatus = httpStatus;
        this.data = data;
    }

    public ApiResponse(HttpStatus httpStatus, String message, T data)
    {
        this.code = httpStatus.value();
        this.httpStatus = httpStatus;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResponse<T> of(HttpStatus httpStatus, int draw, long recordsTotal, long recordsFiltered, T data) {
        return new ApiResponse<>(httpStatus, draw, recordsTotal, recordsFiltered, data);
    }

    public static <T> ApiResponse<T> of(HttpStatus httpStatus, T data) {
        return new ApiResponse<>(httpStatus, data);
    }

    public static <T> ApiResponse<T> bindError(String message, T data) {
        return new ApiResponse<>(HttpStatus.BAD_REQUEST, message, data);
    }

}
