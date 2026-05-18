package com.motocart.library.common.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemResponseDTO {
    private int orderItemId;
    private int productId;
    private String productName;
    private long productPrice;
    private String imageUrl;
    private int quantity;
    private long lineTotal;

}
