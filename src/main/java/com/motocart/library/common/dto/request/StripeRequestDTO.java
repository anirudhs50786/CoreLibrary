package com.motocart.library.common.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StripeRequestDTO {
    private String userId;
    private String orderId;
    private List<StripeLineItemDTO> lineItemDTOList;
    private String successUrl;
    private String cancelUrl;
}
