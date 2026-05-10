package com.motocart.library.common.types;

public enum InventoryActionType {
    RESERVE,   // lock stock temporarily
    RELEASE,   // unlock if payment fails
    DEDUCT     // permanently deduct after payment success
}
