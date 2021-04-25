package com.another.product.core.item.create;

import com.another.product.core.item.entity.Item;
import lombok.Value;

import java.math.BigDecimal;

@Value
public class CreateItemResponse {

    Long id;

    String name;

    BigDecimal price;

    String imageUrl;

    public static CreateItemResponse valueOf(Item createdItem) {
        return new CreateItemResponse(
            createdItem.getId(),
            createdItem.getName(),
            createdItem.getPrice(),
            createdItem.getImageUrl()
        );
    }
}
