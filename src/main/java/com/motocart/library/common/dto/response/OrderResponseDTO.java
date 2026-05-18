package com.motocart.library.common.dto.response;

import com.motocart.library.common.types.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDTO {
    private List<OrderItemResponseDTO> itemsResponseDTO;
    private int orderId;
    private int userId;
    private OrderStatus orderStatus;
    private double totalAmount;
    private double discountAmount;
    private double platformFees;
    private double subTotal;
    private double deliveryCharges;
    private String deliveryAddressLine;
    private String deliveryLandmark;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZipCode;
    private String deliveryCountry;
    private Instant createdAt;
    private Instant updatedAt;
}
