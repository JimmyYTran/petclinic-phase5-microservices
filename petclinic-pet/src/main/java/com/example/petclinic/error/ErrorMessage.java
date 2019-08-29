package com.example.petclinic.error;

import org.springframework.http.HttpStatus;

public class ErrorMessage {

    private ErrorType errorType;
    private HttpStatus httpStatus;
    private String message;

    public ErrorMessage(ErrorType errorType, HttpStatus httpStatus, String message) {
        this.errorType = errorType;
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"errorType\" : \"").append(errorType).append("\"");
        sb.append("\"httpStatus\" : \"").append(httpStatus).append("\"");
        sb.append(", \"message\" : \"").append(message).append("\"");
        sb.append('}');
        return sb.toString();
    }
}
