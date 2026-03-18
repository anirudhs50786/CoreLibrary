package com.motocart.library.common.filter;

import com.motocart.library.common.service.MDCService;
import com.motocart.library.common.types.MDCTypes;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * This Filter adds the request context and a correlation id to the MDC which will be used by for logging.
 */
@Component
public class MDCFilter extends OncePerRequestFilter {

    private final MDCService mdcService;

    public MDCFilter(MDCService mdcService) {
        this.mdcService = mdcService;
    }

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        try {
            String correlationId = mdcService.extractOrGenerateCorrelationId(request);
            MDC.put(MDCTypes.MDC_CORRELATION_ID.getKey(), correlationId);
            MDC.put(MDCTypes.MDC_REQUEST_METHOD.getKey(), request.getMethod());
            MDC.put(MDCTypes.MDC_REQUEST_PATH.getKey(), request.getRequestURI());
            filterChain.doFilter(request, response);
        } finally {
            MDC.clear();
        }
    }
}
