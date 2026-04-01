package com.motocart.library.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class CartItemsDTO {

    private int cartItemId;

    private int productId;

    private String productName;

    private long productPrice;

    private String imageUrl;

    private int quantity;

    private Instant addedAt;
}
