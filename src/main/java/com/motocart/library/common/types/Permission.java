package com.motocart.library.common.types;

import lombok.Getter;

@Getter
public enum Permission {

    // CIAAS - User & Entitlement Management
    ENTITLEMENTS_VIEW("View Permissions"),
    ENTITLEMENTS_UPDATE("Update Permissions"),
    USERS_VIEW("View Users"),
    USERS_UPDATE("Update Users"),

    // Products
    PRODUCTS_VIEW("View Products"),
    PRODUCTS_CREATE("Create Products"),
    PRODUCTS_UPDATE("Update Products"),
    PRODUCTS_DELETE("Delete Products"),

    // Categories
    CATEGORIES_VIEW("View Categories"),
    CATEGORIES_CREATE("Create Categories"),
    CATEGORIES_UPDATE("Update Categories"),
    CATEGORIES_DELETE("Delete Categories"),

    // Inventory - Stock
    STOCK_VIEW("View Stock"),
    STOCK_CREATE("Add Stock"),
    STOCK_UPDATE("Update Stock"),

    // Inventory - Warehouse
    WAREHOUSE_VIEW("View Warehouses"),
    WAREHOUSE_CREATE("Add Warehouse"),
    WAREHOUSE_UPDATE("Update Warehouse"),
    WAREHOUSE_DELETE("Delete Warehouse"),

    // Billing
    BILLING_GENERATE("Generate Bill"),
    BILLING_VIEW("View Bills"),

    // Transactions
    TRANSACTIONS_VIEW("View Transactions");

    private final String displayName;

    Permission(String displayName) {
        this.displayName = displayName;
    }
}
