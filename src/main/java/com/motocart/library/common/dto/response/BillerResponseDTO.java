package com.motocart.library.common.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class BillerResponseDTO implements Serializable {
    private double subTotal;
    private double couponDiscount;
    private double offerDiscount;
    private double totalDiscount;
    private double deliveryCharges;
    private double platformFees;
    private double totalAmount;
}
