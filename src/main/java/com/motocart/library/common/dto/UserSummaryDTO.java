package com.motocart.library.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSummaryDTO implements Serializable {

    private int userId;
    private String username;
    private String email;
    private int accountStatus;
    private Instant createdOn;
}
