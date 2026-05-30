package com.motocart.library.common.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CleanUpResponse {
    private long deletedCount;
    private String message;
    private Instant executedAt;
}