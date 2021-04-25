package com.another.product.service.item;

import com.another.product.core.item.create.CreateItemResponse;
import lombok.Value;

@Value
public class CreateItemRestResponse {

    Long id;

    public static CreateItemRestResponse valueOf(CreateItemResponse response) {
        return new CreateItemRestResponse(response.getId());
    }
}
