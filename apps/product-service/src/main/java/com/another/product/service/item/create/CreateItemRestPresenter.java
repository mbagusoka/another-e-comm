package com.another.product.service.item.create;

import com.another.product.client.response.CreateItemRestResponse;
import com.another.product.core.item.create.CreateItemPresenter;
import com.another.product.core.item.create.CreateItemResponse;

class CreateItemRestPresenter implements CreateItemPresenter {

    private CreateItemRestResponse restResponse;

    @Override
    public void present(CreateItemResponse response) {
        restResponse = new CreateItemRestResponse(response.getId());
    }

    public CreateItemRestResponse getResponse() {
        return restResponse;
    }
}
