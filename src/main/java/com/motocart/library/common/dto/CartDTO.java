package com.motocart.library.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class CartDTO {

    private int cartId;

    private Instant createdAt;

    private Instant updatedAt;

    private List<CartItemsDTO> cartItems;
}
