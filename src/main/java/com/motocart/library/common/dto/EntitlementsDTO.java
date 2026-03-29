package com.motocart.library.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class EntitlementsDTO implements Serializable {
    private int userId;
    private Set<String> roles;
    private Set<String> permissions;
}
