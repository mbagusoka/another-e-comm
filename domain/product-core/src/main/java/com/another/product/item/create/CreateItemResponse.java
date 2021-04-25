package com.another.product.item.create;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class CreateItemResponse {

    Long id;

    String name;

    BigDecimal price;

    String imageUrl;
}
