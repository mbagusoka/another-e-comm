package com.another.product.persistence.item;

import com.another.product.core.item.gateway.ItemCommandGateway;
import com.another.product.core.item.create.CreateItemRequest;
import com.another.product.core.item.entity.Item;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultItemCommandGateway implements ItemCommandGateway {

    private final ItemRepository itemRepository;

    @Override
    public Item create(CreateItemRequest request) {
        ItemEntity entity = ItemEntity.valueOf(request);

        return itemRepository.save(entity);
    }
}
