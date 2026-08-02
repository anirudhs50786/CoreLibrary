package com.motocart.library.security.user.integration;

import com.motocart.library.common.dto.response.UserProfileResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ciaas-server", path = "/closedcart/profile", contextId = "profileServiceClient")
public interface ProfileServiceClient {

    // Endpoint to get profile for the authenticated user
    @GetMapping("/me")
    UserProfileResponseDTO getCurrentUserProfile();

    // Endpoint to get profile by user id
    @GetMapping("/{userId}")
    UserProfileResponseDTO getUserProfile(@PathVariable("userId") int userId);
}
