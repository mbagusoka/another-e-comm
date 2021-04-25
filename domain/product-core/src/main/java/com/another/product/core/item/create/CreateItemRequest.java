package com.another.product.core.item.create;

import lombok.NonNull;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class CreateItemRequest {

    String name;

    BigDecimal price;

    String imageUrl;

    public CreateItemRequest(@NonNull String name, @NonNull BigDecimal price, String imageUrl) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }
}
