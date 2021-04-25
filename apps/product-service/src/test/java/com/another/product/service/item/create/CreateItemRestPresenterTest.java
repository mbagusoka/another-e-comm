package com.another.product.service.item.create;

import com.another.product.client.response.CreateItemRestResponse;
import com.another.product.core.item.create.CreateItemResponse;
import com.another.product.service.common.Randomizer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CreateItemRestPresenterTest {

    private final CreateItemRestPresenter restPresenter = new CreateItemRestPresenter();

    @Test
    void givenRequest_whenPresent_shouldReturnCorrectResult() {
        CreateItemResponse response = Randomizer.get(CreateItemResponse.class);

        restPresenter.present(response);
        CreateItemRestResponse restResponse = restPresenter.getResponse();

        assertThat(restResponse.getId()).isEqualTo(response.getId());
    }
}
