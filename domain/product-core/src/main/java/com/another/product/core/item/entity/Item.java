package com.another.product.core.item.entity;

import java.math.BigDecimal;

public interface Item {

    Long getId();

    String getName();

    BigDecimal getPrice();

    String getImageUrl();
}
