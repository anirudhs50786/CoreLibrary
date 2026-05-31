package com.motocart.library.common.dto.response;

import com.motocart.library.common.dto.UserAddressDTO;
import com.motocart.library.common.types.Profile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserProfileResponseDTO implements Serializable {

    private int userId;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private long phoneNumber;
    private Profile.Gender gender;
    private Instant dateOfBirth;
    private String profileImageUrl;
    private List<UserAddressDTO> userAddressDTOList;
}
