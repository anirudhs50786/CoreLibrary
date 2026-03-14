package com.motocart.library.common.dto;

import jakarta.annotation.Nullable;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CategoriesDTO implements Serializable {

    private int categoryId;

    private String categoryName;

    private String categoryDesc;

    @Nullable
    private List<ProductDTO> productDTO;
}
