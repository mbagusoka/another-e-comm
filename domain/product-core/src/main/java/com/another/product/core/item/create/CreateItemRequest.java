package com.another.product.core.item.create;

import com.another.common.validator.ValidationAware;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Value
@EqualsAndHashCode(callSuper = false)
public class CreateItemRequest extends ValidationAware<CreateItemRequest> {

    @NotBlank(message = "Name cannot be empty")
    String name;

    @NotNull(message = "Price cannot be empty")
    BigDecimal price;

    String imageUrl;
}
