package com.motocart.library.security.authentication;

import com.motocart.library.common.dto.EntitlementsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ciaas-server", path = "/closedcart/entitlements", contextId = "entitlementServiceClient")
public interface EntitlementServiceClient {

    @GetMapping
    EntitlementsDTO getEntitlementsForLoggedInUser();

    @GetMapping("/{userId}")
    EntitlementsDTO getEntitlements(@PathVariable int userId);
}
