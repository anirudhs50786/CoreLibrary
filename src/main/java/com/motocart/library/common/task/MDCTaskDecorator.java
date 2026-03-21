package com.motocart.library.common.task;

import org.slf4j.MDC;
import org.springframework.core.task.TaskDecorator;
import org.springframework.lang.NonNull;

import java.util.Collections;
import java.util.Map;

/**
 * Task Decorator for Mapped Diagnostic Context. As the MDC is thread local in async systems this context is
 * not passed to the child threads. Use this when setting up the Task Executor Service
 */
public class MDCTaskDecorator implements TaskDecorator {

    @Override
    @NonNull
    public Runnable decorate(@NonNull Runnable runnable) {
        Map<String, String> mdcContext = MDC.getCopyOfContextMap();
        return () -> {
            try {
                MDC.setContextMap(mdcContext != null ? mdcContext : Collections.emptyMap());
                runnable.run();
            } finally {
                MDC.clear();
            }
        };
    }
}
