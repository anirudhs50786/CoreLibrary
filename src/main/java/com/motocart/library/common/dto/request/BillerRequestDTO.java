package com.motocart.library.common.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class BillerRequestDTO implements Serializable {
    private int userId;
    private List<BillerItemDTO> items;
    private String couponCode;
}
