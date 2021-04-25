package com.another.product.item.create;

import com.another.product.gateway.ItemGateway;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateItemUseCase implements CreateItem {

    private final ItemGateway itemGateway;

    @Override
    public void create(@NonNull CreateItemRequest request, CreateItemPresenter presenter) {
        CreateItemResponse response = itemGateway.create(request);

        presenter.present(response);
    }
}
