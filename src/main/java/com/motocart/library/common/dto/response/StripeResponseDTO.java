package com.motocart.library.common.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StripeResponseDTO {
    private String sessionId;
    private String sessionUrl;
    private String message;
    private String status;
}
