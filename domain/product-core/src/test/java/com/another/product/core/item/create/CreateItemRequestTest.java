package com.another.product.core.item.create;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CreateItemRequestTest {

    @Test
    void givenNullName_whenCreateItemRequest_shouldThrowException() {
        CreateItemRequest request = new CreateItemRequest(null, BigDecimal.ONE, null);

        Exception e = assertThrows(ConstraintViolationException.class, request::validate);

        assertThat(e.getMessage()).isEqualTo("name: Name cannot be empty");
    }

    @Test
    void givenNullPrice_whenCreateItemRequest_shouldThrowException() {
        CreateItemRequest request = new CreateItemRequest("dummy", null, null);

        Exception e = assertThrows(ConstraintViolationException.class, request::validate);

        assertThat(e.getMessage()).isEqualTo("price: Price cannot be empty");
    }
}
