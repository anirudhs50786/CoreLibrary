package com.motocart.library.common.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.Instant;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorDTO {
    private String code;
    private String value;
    private String message;
    private String details;
    private Instant timestamp;
}
