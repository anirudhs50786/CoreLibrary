package com.motocart.library.common.event;

import com.motocart.library.common.types.InventoryActionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InventoryEvent {

    private int orderId;
    private InventoryActionType actionType;
    private List<ProductQuantityPair> productQuantityPairs;

    public record ProductQuantityPair(int productId, int quantity) {
    }
}
