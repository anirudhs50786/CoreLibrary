package com.motocart.library.common.dto;

import com.motocart.library.common.types.Profile;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
public class UserAddressDTO implements Serializable {

    private int userAddressId;
    private String addressLine;
    private String landmark;
    private String cityName;
    private String zipCode;
    private String state;
    private Profile.AddressType addressType;
    private Profile.Country country;
    private boolean isDefault;
    private Instant createdAt;
}