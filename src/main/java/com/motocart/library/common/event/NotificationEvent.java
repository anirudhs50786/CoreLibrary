package com.motocart.library.common.event;

import com.motocart.library.common.types.NotificationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Nullable;
import java.io.Serializable;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class NotificationEvent implements Serializable {

    private NotificationType notificationType;
    @Nullable
    private String recipientEmail;
    @Nullable
    private String recipientName;
    private int userId;
    private String subject;
    private Map<String, Object> payload;

}
