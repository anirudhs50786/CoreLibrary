package com.motocart.library.common.dto;

import com.motocart.library.common.types.Profile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailDTO implements Serializable {

    private int userId;
    private String username;
    private String email;
    private int accountStatus;
    private Instant createdOn;
    private String firstName;
    private String lastName;
    private long phoneNumber;
    private Profile.Gender gender;
    private Instant dateOfBirth;
    private String profileImageUrl;
    private List<UserAddressDTO> deliveryAddresses;
}
