package com.motocart.library.common.service;

import com.motocart.library.common.types.HttpConstants;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MDCService {

    public String extractOrGenerateCorrelationId(HttpServletRequest request) {
        // Try to get from header first from Gatekeeper service or other upstream service
        String correlationId = request.getHeader(HttpConstants.CORRELATION_ID_HEADER);

        if (correlationId == null || correlationId.trim().isEmpty()) {
            // Generate new one if not found
            correlationId = generateCorrelationId();
        }
        return correlationId;
    }

    private String generateCorrelationId() {
        return "req-" + UUID.randomUUID().toString().replace("-", "").substring(0, 12);
    }
}
