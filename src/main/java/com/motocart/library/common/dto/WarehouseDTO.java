package com.motocart.library.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseDTO {
    private int warehouseId;
    private String warehouseName;
    private String location;
    private boolean isActive;
}
