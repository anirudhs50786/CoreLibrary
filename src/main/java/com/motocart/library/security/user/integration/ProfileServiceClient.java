package com.motocart.library.security.user.integration;

import com.motocart.library.common.dto.response.UserProfileResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ciaas-server", path = "/closedcart/profile", contextId = "profileServiceClient")
public interface ProfileServiceClient {

    @GetMapping
    UserProfileResponseDTO getUserProfile();

    @GetMapping
    UserProfileResponseDTO getUserProfile(int userId);
}
