package com.motocart.library.common.exception;

import com.motocart.library.common.dto.response.ErrorDTO;
import com.motocart.library.common.dto.response.ErrorsDTO;
import lombok.Getter;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

@Getter
public class GlobalException extends RuntimeException {

    private final List<Error> errorList = new ArrayList<>();
    private final int status;
    private final ErrorsDTO errorsDTO;

    public GlobalException(String message) {
        this(message, null);
    }

    public GlobalException(String message, String code, String details, Throwable cause) {
        this(message, code, details, cause, HttpStatus.BAD_REQUEST.value(), null);
    }

    public GlobalException(String message, @Nullable Throwable cause) {
        this(message, null, cause != null ? ExceptionUtils.getStackTrace(cause) : null, cause);
    }

    public GlobalException(String message, Throwable cause, String code) {
        this(message, code, cause != null ? ExceptionUtils.getStackTrace(cause) : null, cause);
    }

    private GlobalException(String message, String code, String details, Throwable cause, int status, ErrorsDTO errorsDTO) {
        super(message, cause);
        this.status = status;
        this.errorsDTO = errorsDTO;

        if (errorsDTO != null && errorsDTO.getErrorDTO() != null && !errorsDTO.getErrorDTO().isEmpty()) {
            for (ErrorDTO errorDTO : errorsDTO.getErrorDTO()) {
                errorList.add(Error.builder()
                        .code(errorDTO.getCode())
                        .stacktrace(errorDTO.getDetails())
                        .message(errorDTO.getMessage())
                        .cause(cause)
                        .build());
            }
            return;
        }
        if (details == null && cause != null) {
            details = ExceptionUtils.getStackTrace(cause);
        }
        errorList.add(Error.builder().code(code).stacktrace(details).message(message).cause(cause).build());
    }

    public static GlobalException downstream(int status, ErrorsDTO errorsDTO, String message, Throwable cause) {
        return new GlobalException(message, null, null, cause, status, errorsDTO);
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