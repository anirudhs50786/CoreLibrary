package com.motocart.library.common.types;

import lombok.Getter;

@Getter
public enum Permission {

    /**
     * Admin only privileges
     */
    ENTITLEMENTS_VIEW("View Permissions"),
    ENTITLEMENTS_UPDATE("Update Permissions"),
    USERS_VIEW("View Users"),
    USERS_UPDATE("Update Users");

    private final String displayName;

    Permission(String displayName) {
        this.displayName = displayName;
    }
}
