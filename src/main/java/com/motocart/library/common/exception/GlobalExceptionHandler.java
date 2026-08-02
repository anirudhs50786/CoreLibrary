package com.motocart.library.common.exception;

import com.motocart.library.common.dto.response.ErrorsDTO;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final ErrorTransformer errorTransformer;
    private final ExceptionTransformer exceptionTransformer;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorsDTO> handleValidationException(MethodArgumentNotValidException ex) {
        String errors = ex.getBindingResult().getFieldErrors().stream()
                .map(e -> e.getField() + ": " + e.getDefaultMessage())
                .collect(Collectors.joining(", "));
        ErrorsDTO errorsDTO = errorTransformer.transformValidationErrors(errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorsDTO);
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    public ResponseEntity<ErrorsDTO> handleMissingHeader(MissingRequestHeaderException ex) {
        ErrorsDTO errorsDTO = errorTransformer.getErrorsDTO(new GlobalException("Missing required header: " + ex.getHeaderName(), ex));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorsDTO);
    }

    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<ErrorsDTO> handleGlobalException(GlobalException ex) {
        ErrorsDTO errorsDTO = errorTransformer.getErrorsDTO(ex);
        if (ex.getStatus() >= HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            log.error("Global exception propagated with status {}", ex.getStatus(), ex);
        }
        return ResponseEntity.status(ex.getStatus()).body(errorsDTO);
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ErrorsDTO> handleFeignException(FeignException ex) {
        GlobalException transformed = exceptionTransformer.transform(ex);
        log.error("Downstream service error captured from Feign with status {}", transformed.getStatus(), ex);
        return ResponseEntity.status(transformed.getStatus()).body(errorTransformer.getErrorsDTO(transformed));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorsDTO> handleGenericException(Exception ex) {
        log.error("Unexpected error: {}", ex.getMessage(), ex);
        ErrorsDTO errorsDTO = errorTransformer.singleError("INTERNAL_SERVER_ERROR", "An unexpected error occurred", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorsDTO);
    }
}
