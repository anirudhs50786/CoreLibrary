package com.motocart.library.common.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import feign.Request;
import feign.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ExceptionTransformerTest {

    private final ExceptionTransformer transformer = new ExceptionTransformer(new ObjectMapper());

    @Test
    void transform_shouldPreserveStatusAndDecodeErrorsDTO() {
        String payload = "{\"errorDTO\":[{\"code\":\"ORDER_NOT_FOUND\",\"message\":\"Order not found\"}]}";
        FeignException exception = feignException(404, payload);

        GlobalException transformed = transformer.transform(exception);

        assertEquals(404, transformed.getStatus());
        assertNotNull(transformed.getErrorsDTO());
        assertNotNull(transformed.getErrorsDTO().getErrorDTO());
        assertEquals(1, transformed.getErrorsDTO().getErrorDTO().size());
        assertEquals("ORDER_NOT_FOUND", transformed.getErrorsDTO().getErrorDTO().getFirst().getCode());
        assertEquals("Order not found", transformed.getErrorsDTO().getErrorDTO().getFirst().getMessage());
    }

    @Test
    void transform_shouldFallbackWhenPayloadCannotBeParsed() {
        FeignException exception = feignException(502, "not-json");

        GlobalException transformed = transformer.transform(exception);

        assertEquals(502, transformed.getStatus());
        assertNotNull(transformed.getErrorsDTO());
        assertEquals("DOWNSTREAM_SERVICE_ERROR", transformed.getErrorsDTO().getErrorDTO().getFirst().getCode());
    }

    @Test
    void globalException_shouldDefaultToBadRequestForLocalErrors() {
        GlobalException exception = new GlobalException("Validation failed");

        assertEquals(HttpStatus.BAD_REQUEST.value(), exception.getStatus());
    }

    private FeignException feignException(int status, String body) {
        Request request = Request.create(
                Request.HttpMethod.GET,
                "http://localhost/test",
                Map.of(),
                null,
                StandardCharsets.UTF_8,
                null
        );

        Response response = Response.builder()
                .status(status)
                .reason("Error")
                .request(request)
                .body(body, StandardCharsets.UTF_8)
                .build();

        return FeignException.errorStatus("client#method", response);
    }
}

