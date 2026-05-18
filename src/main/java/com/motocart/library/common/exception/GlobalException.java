package com.motocart.library.common.exception;

import lombok.Getter;
import org.apache.commons.lang.exception.ExceptionUtils;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GlobalException extends RuntimeException {

    private final List<Error> errorList = new ArrayList<>();

    public GlobalException(String message) {
        this(message, null);
    }

    public GlobalException(String message, String code, String details, Throwable cause) {
        super(message);
        errorList.add(Error.builder().code(code).stacktrace(details).message(message).cause(cause).build());
    }

    public GlobalException(String message, Throwable cause) {
        this(message, null, ExceptionUtils.getStackTrace(cause), cause);
    }

    public GlobalException(String message, Throwable cause, String code) {
        this(message, code, ExceptionUtils.getStackTrace(cause), cause);
    }

    public Error getError() {
        return errorList.getFirst();
    }

    public void addError(String message, String code, String details, Throwable cause) {
        errorList.add(Error.builder()
                .code(code)
                .stacktrace(details)
                .message(message)
                .cause(cause)
                .build());
    }
}