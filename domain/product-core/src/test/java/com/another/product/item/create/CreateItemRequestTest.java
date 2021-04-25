package com.another.product.item.create;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CreateItemRequestTest {

    @Test
    void givenNullName_whenCreateItemRequest_shouldThrowException() {
        Exception e = assertThrows(
            NullPointerException.class,
            () -> new CreateItemRequest(null, BigDecimal.ONE, null)
        );

        assertThat(e.getMessage()).isEqualTo("name is marked non-null but is null");
    }

    @Test
    void givenNullPrice_whenCreateItemRequest_shouldThrowException() {
        Exception e = assertThrows(
            NullPointerException.class,
            () -> new CreateItemRequest("dummy", null, null)
        );

        assertThat(e.getMessage()).isEqualTo("price is marked non-null but is null");
    }
}
