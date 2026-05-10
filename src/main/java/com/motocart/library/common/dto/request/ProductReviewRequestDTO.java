package com.motocart.library.common.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class ProductReviewRequestDTO implements Serializable {
    private int productId;
    private int page;
    private int size;
    private String sortBy;
    private Sort.Direction direction;
}
