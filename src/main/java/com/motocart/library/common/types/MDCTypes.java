package com.motocart.library.common.types;

import lombok.Getter;

@Getter
public enum MDCTypes {
    MDC_CORRELATION_ID("correlationId"),
    MDC_REQUEST_METHOD("requestMethod"),
    MDC_REQUEST_PATH("requestPath");

    private final String key;

    MDCTypes(String key) {
        this.key = key;
    }
}
