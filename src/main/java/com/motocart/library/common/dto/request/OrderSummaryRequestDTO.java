package com.motocart.library.common.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class OrderSummaryRequestDTO {
    private int orderId;
    private int userId;
}
