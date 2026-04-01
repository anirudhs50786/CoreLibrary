package com.motocart.library.common.event;

import com.motocart.library.common.types.OrderStatus;
import com.motocart.library.common.types.PaymentMethod;
import com.motocart.library.common.types.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderEvent {
    private int userId;
    private int orderId;
    private OrderStatus orderStatus;
    private double totalAmount;
    private PaymentStatus paymentStatus;
    private PaymentMethod paymentMethod;
    private String trackingId;
    private Instant estimatedDeliveryDate;
    private Instant createdAt;
    private Instant updatedAt;
}
