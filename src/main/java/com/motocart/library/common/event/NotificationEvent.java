package com.motocart.library.common.event;

import com.motocart.library.common.types.NotificationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class NotificationEvent implements Serializable {

    private NotificationType notificationType;
    private String recipientEmail;
    private String recipientName;
    private String subject;
    private Map<String, Object> payload;

}
