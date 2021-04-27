package com.another.product.core.item.create;

import com.another.product.core.item.entity.Item;
import com.another.product.core.item.gateway.ItemCommandGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateItemUseCase implements CreateItem {

    private final ItemCommandGateway itemCommandGateway;

    @Override
    public void create(CreateItemRequest request, CreateItemPresenter presenter) {
        validateRequest(request, presenter);

        doCreate(request, presenter);
    }

    private void doCreate(CreateItemRequest request, CreateItemPresenter presenter) {
        Item createdItem = itemCommandGateway.create(request);
        CreateItemResponse response = CreateItemResponse.valueOf(createdItem);

        presenter.present(response);
    }

    private void validateRequest(CreateItemRequest request, CreateItemPresenter presenter) {
        if (null == request) {
            throw new IllegalArgumentException("Request cannot be null");
        }

        if (null == presenter) {
            throw new IllegalArgumentException("Presenter cannot be null");
        }

        request.validate();
    }
}
