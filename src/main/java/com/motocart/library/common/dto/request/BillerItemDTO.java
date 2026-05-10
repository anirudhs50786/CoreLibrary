package com.motocart.library.common.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class BillerItemDTO implements Serializable {
    private int productId;
    private int quantity;
    private double productPrice;
}
