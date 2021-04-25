package com.another.product.core.item.create;

import com.another.product.core.gateway.ItemGateway;
import com.another.product.core.item.entity.Item;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateItemUseCase implements CreateItem {

    private final ItemGateway itemGateway;

    @Override
    public void create(@NonNull CreateItemRequest request, CreateItemPresenter presenter) {
        Item createdItem = itemGateway.create(request);
        CreateItemResponse response = CreateItemResponse.valueOf(createdItem);

        presenter.present(response);
    }
}
