package com.another.product.core.gateway;

import com.another.product.core.item.create.CreateItemRequest;
import com.another.product.core.item.entity.Item;

public interface ItemCommandGateway {

    Item create(CreateItemRequest request);
}
