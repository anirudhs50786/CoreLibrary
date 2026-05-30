package com.motocart.library.common.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuditLogPreviewDTO {
    private String auditLogId;
    private int entityId;
    private Instant timeStamp;
    private String action;
    private String entityType;
    private int userId;
    private String sourceService;
}
