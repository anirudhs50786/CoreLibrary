package com.motocart.library.security.user.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    private int userId;
    private String email;
    private String username;
    private String firstName;
    private String lastName;
}
