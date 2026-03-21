package com.motocart.library.common.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WarehouseDTO {
    private int warehouseId;
    private String warehouseName;
    private String location;
    private boolean isActive;
}
