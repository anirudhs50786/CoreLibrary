package com.motocart.library.common.dto;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoriesDTO implements Serializable {

    private int categoryId;

    private String categoryName;

    private String categoryDesc;

    @Nullable
    private List<ProductDTO> productDTO;
}
