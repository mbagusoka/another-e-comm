package com.another.product.gateway;

import com.another.product.item.create.CreateItemRequest;
import com.another.product.item.create.CreateItemResponse;

public interface ItemGateway {

    CreateItemResponse create(CreateItemRequest request);
}
