package com.motocart.library.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockDTO {
    private int stockId;
    private int productId;
    private int warehouseId;
    private int quantity;
    private int reservedQuantity;
    private int availableQuantity;
}
