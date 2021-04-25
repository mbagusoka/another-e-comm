package com.another.product.service.item;

import com.another.product.core.item.create.CreateItemRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Value
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
public class CreateItemRestRequest {

    @NotBlank(message = "Name cannot be empty")
    String name;

    @NotNull(message = "Price cannot be empty")
    BigDecimal price;

    String imageUrl;

    public CreateItemRequest getItemRequest() {
        return new CreateItemRequest(name, price, imageUrl);
    }
}
