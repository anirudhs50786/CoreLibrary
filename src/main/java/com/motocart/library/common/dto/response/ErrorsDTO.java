package com.motocart.library.common.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class ErrorsDTO {
    private List<ErrorDTO> errorDTO;
}
