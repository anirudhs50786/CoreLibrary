package com.motocart.library.common.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StripeLineItemDTO {

    private int productId;
    private Long smallestUnitAmount;
    private Long quantity;
    private String name;
    private String currency;
}
