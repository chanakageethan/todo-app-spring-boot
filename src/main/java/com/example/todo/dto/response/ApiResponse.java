package com.example.todo.dto.response;

import com.example.todo.enums.ResponseMessageEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private boolean success = false;
    private String title;
    private String code;
    private String message;
    private T data;
    private long timestamp;
    private String requestId;
    private HttpStatus httpStatus;


    public ApiResponse(boolean success, ResponseMessageEnum message, T data) {
        this.success = success;
        this.message = message.getMessage();
        this.data = data;
        this.timestamp = new Date().getTime();
        this.httpStatus = HttpStatus.ACCEPTED;
    }

    public ApiResponse(boolean success, String message, T data, HttpStatus httpStatus) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.timestamp = new Date().getTime();
        this.httpStatus = httpStatus;
    }

    public ApiResponse(boolean success, ResponseMessageEnum message, T data, HttpStatus httpStatus) {
        this.success = success;
        this.message = message.getMessage();
        this.data = data;
        this.timestamp = new Date().getTime();
        this.httpStatus = httpStatus;
    }

    public ApiResponse(boolean success, String invalidJsonFormat, Object data) {
    }

}
