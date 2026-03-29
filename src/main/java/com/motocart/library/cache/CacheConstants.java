package com.motocart.library.cache;

import com.motocart.library.common.types.Servers;
import lombok.Getter;

@Getter
public enum CacheConstants {
    USER_ENTITLEMENT_CACHE(CacheNames.USER_ENTITLEMENT_CACHE, Servers.CIAAS);

    private final String cacheName;
    private final Servers owner;

    CacheConstants(String cacheName, Servers owner) {
        this.cacheName = cacheName;
        this.owner = owner;
    }
}
