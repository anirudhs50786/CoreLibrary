package com.motocart.library.common.dto.response;

import lombok.Data;

import java.time.Instant;

@Data
public class ErrorDTO {
    private String code;
    private String value;
    private String message;
    private String details;
    private Instant timestamp;
}
