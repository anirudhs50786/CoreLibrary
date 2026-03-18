package com.motocart.library.common.event;

import com.motocart.library.common.types.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuditEvent implements Serializable {

    private int auditLogId;
    private int entityId;
    private String action;
    private String entityType;
    private Map<String, Object> changedFields;
    private int userId;
    private String sourceService;
    private Instant timeStamp;
    private List<Roles> userRoles;
    private String changeNote;
    private String correlationId;
}
