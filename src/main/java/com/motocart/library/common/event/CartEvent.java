package com.motocart.library.common.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartEvent {

    private int userId;

    private int productId;

    private String productName;

    private long productPrice;

    private String imageUrl;

    private int quantity;

}
