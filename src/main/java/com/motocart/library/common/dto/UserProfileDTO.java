package com.motocart.library.common.dto;

import com.motocart.library.common.types.Profile;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
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
public class UserProfileDTO implements Serializable {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Size(min = 6, max = 15, message = "Invalid phone number")
    private long phoneNumber;

    private Profile.Gender gender;

    @Past
    private Instant dateOfBirth;

    private String profileImageUrl;

    private List<UserAddressDTO> userAddressDTOList;
}
