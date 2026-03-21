package com.motocart.library.common.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StockDTO {
    private int stockId;
    private int productId;
    private int warehouseId;
    private int quantity;
    private int reservedQuantity;
    private int availableQuantity;
}
