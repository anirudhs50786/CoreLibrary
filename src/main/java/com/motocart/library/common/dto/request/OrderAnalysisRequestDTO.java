package com.motocart.library.common.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class OrderAnalysisRequestDTO {
    private int userId;
    private LocalDate timelineFrom;
    private LocalDate timelineTo;
}
