package com.motocart.library.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO implements Serializable {

    private int productId;
    private int categoryId;
    private String productName;
    private String productCode;
    private String firmName;
    private String productDescription;
    private BigDecimal productPrice;
    private List<ProductImageDTO> images;
}
