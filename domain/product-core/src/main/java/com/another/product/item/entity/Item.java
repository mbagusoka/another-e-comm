package com.another.product.item.entity;

import java.math.BigDecimal;

public interface Item {

    Long getId();

    String getName();

    BigDecimal getPrice();

    String getImageUrl();
}
