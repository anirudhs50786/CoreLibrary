package com.motocart.library.common.dto;

import com.motocart.library.common.event.AuditEvent;
import com.motocart.library.common.types.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuditLogDTO {

    private String auditLogId;

    private int entityId;

    private Instant timeStamp;

    private String action;

    private String entityType;

    private Map<String, AuditEvent.FieldChangePair> changedFieldsPairMap;

    private int userId;

    private String sourceService;

    private List<Roles> userRoles;

    private String changeNote;

    private String correlationId;
}