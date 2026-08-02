package com.motocart.library.common.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.motocart.library.common.dto.response.ErrorDTO;
import com.motocart.library.common.dto.response.ErrorsDTO;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ExceptionTransformer {

    private final ObjectMapper objectMapper;

    public GlobalException transform(FeignException exception) {
        int status = exception.status() > 0 ? exception.status() : HttpStatus.BAD_GATEWAY.value();
        String rawBody = exception.contentUTF8();

        ErrorsDTO errors = parseErrors(rawBody);
        if (errors == null || errors.getErrorDTO() == null || errors.getErrorDTO().isEmpty()) {
            errors = fallbackErrors(exception.getMessage(), rawBody);
        }

        return GlobalException.downstream(status, errors, exception.getMessage(), exception);
    }

    private ErrorsDTO parseErrors(String rawBody) {
        if (rawBody == null || rawBody.isBlank()) {
            return null;
        }

        try {
            return objectMapper.readValue(rawBody.getBytes(StandardCharsets.UTF_8), ErrorsDTO.class);
        } catch (Exception ignored) {
            return null;
        }
    }

    private ErrorsDTO fallbackErrors(String message, String rawBody) {
        ErrorDTO error = new ErrorDTO();
        error.setCode("DOWNSTREAM_SERVICE_ERROR");
        error.setMessage(message != null ? message : "Downstream service error");
        error.setDetails(rawBody);
        error.setTimestamp(Instant.now());

        ErrorsDTO errors = new ErrorsDTO();
        errors.setErrorDTO(List.of(error));
        return errors;
    }
}

