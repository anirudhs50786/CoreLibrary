package com.motocart.library.common.event;

import com.motocart.library.common.types.AuditEntityType;
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

    private String auditLogId;
    private int entityId;
    private String action;
    private AuditEntityType entityType;
    private Map<String, FieldChangePair> changedFieldsPairMap;
    private int userId;
    private String sourceService;
    private Instant timeStamp;
    private List<Roles> userRoles;
    private String changeNote;
    private String correlationId;

    public static void addChange(
            Map<String, FieldChangePair> changedFieldsPairMap,
            String fieldName,
            Object oldValue,
            Object newValue
    ) {
        String oldVal = String.valueOf(oldValue);
        String newVal = String.valueOf(newValue);

        if (oldVal != null && oldVal.equalsIgnoreCase(newVal)) {
            return;
        }
        FieldChangePair values = new FieldChangePair(oldVal, newVal);
        changedFieldsPairMap.put(fieldName, values);
    }

    public record FieldChangePair(String oldValue, String newValue) {
    }
}
