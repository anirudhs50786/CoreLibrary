package com.motocart.library.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO implements Serializable {

    private int productId;
    private String productName;
    private String productCode;
    private String firmName;
    private String productDescription;
    private BigDecimal productPrice;
    private String imageUrl;
    private String imageId;
}
