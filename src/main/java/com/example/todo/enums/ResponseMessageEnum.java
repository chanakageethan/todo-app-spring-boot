package com.example.todo.enums;

public enum ResponseMessageEnum {
    SUCCESS("Request was successful"),
    CREATED("Resource created successfully"),
    UPDATED("Resource updated successfully"),
    DELETED("Resource deleted successfully"),


    BAD_REQUEST("Bad request"),
    UNAUTHORIZED("Unauthorized access"),


    NO_ACCESS("No Access for the resource"),
    NOT_FOUND("Resource not found"),

    EXIST("Resource is already Exist"),
    INTERNAL_SERVER_ERROR("Internal server error"),
    OPERATION_FAILED("Operation could not be completed"),

    DATABASE_ERROR("Database Error");


    private final String message;

    ResponseMessageEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
