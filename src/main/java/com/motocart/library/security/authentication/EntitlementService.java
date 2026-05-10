package com.motocart.library.security.authentication;

import com.motocart.library.cache.CacheNames;
import com.motocart.library.cache.RedisCacheService;
import com.motocart.library.common.dto.EntitlementsDTO;
import com.motocart.library.common.types.Permission;
import com.motocart.library.security.Principal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
@Slf4j
public class EntitlementService {

    private final EntitlementServiceClient entitlementServiceClient;
    private final RedisCacheService cacheService;

    public EntitlementService(EntitlementServiceClient entitlementServiceClient, RedisCacheService cacheService,
                              RedisTemplate<String, EntitlementsDTO> redisTemplate) {
        this.entitlementServiceClient = entitlementServiceClient;
        this.cacheService = cacheService;
    }

    public EntitlementsDTO getEntitlements(int userId) {
        String cacheKey = CacheNames.USER_ENTITLEMENT_CACHE + ":" + userId;
        EntitlementsDTO cached = cacheService.get(cacheKey, EntitlementsDTO.class);
        if (cached != null) {
            log.debug("Cache hit for userId: {}", userId);
            return cached;
        }
        log.debug("Cache miss - fetching entitlements from CIAAS for userId: {}", userId);
        EntitlementsDTO entitlements = entitlementServiceClient.getEntitlementsForLoggedInUser();
        cacheService.put(cacheKey, entitlements, Duration.ofMinutes(60));
        return entitlements;
    }

    public void canAccess(Permission permission) {
        Principal principal = (Principal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        EntitlementsDTO entitlements = getEntitlements(principal.userId());
        if (!entitlements.getPermissions().contains(permission.name())) {
            log.warn("Access denied for permission: {}", permission);
            throw new AccessDeniedException("User is not authorized to access " + permission);
        }
    }
}
