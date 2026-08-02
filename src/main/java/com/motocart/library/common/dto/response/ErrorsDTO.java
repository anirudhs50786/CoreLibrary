package com.motocart.library.common.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorsDTO {
    private List<ErrorDTO> errorDTO;
}
