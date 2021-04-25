package com.another.product.core.item.create;

import com.another.product.core.gateway.ItemCommandGateway;
import com.another.product.core.item.entity.Item;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateItemUseCase implements CreateItem {

    private final ItemCommandGateway itemCommandGateway;

    @Override
    public void create(@NonNull CreateItemRequest request, CreateItemPresenter presenter) {
        Item createdItem = itemCommandGateway.create(request);
        CreateItemResponse response = CreateItemResponse.valueOf(createdItem);

        presenter.present(response);
    }
}
