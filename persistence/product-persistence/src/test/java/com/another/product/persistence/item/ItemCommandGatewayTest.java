package com.another.product.persistence.item;

import com.another.product.core.item.create.CreateItemRequest;
import com.another.product.core.item.entity.Item;
import com.another.product.persistence.common.Randomizer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ItemCommandGatewayTest {

    private final CreateItemRequest createItemRequest = Randomizer.get(CreateItemRequest.class);

    @InjectMocks
    private DefaultItemCommandGateway itemGateway;

    @Mock
    private ItemRepository itemRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void givenRequest_whenCreate_shouldCallItemRepository() {
        prepareAndExecuteRequest();

        ArgumentCaptor<ItemEntity> captor = ArgumentCaptor.forClass(ItemEntity.class);
        verify(itemRepository).save(captor.capture());
        ItemEntity actual = captor.getValue();

        assertThat(actual.getName()).isEqualTo(createItemRequest.getName());
        assertThat(actual.getPrice()).isEqualTo(createItemRequest.getPrice());
        assertThat(actual.getImageUrl()).isEqualTo(createItemRequest.getImageUrl());
    }

    @Test
    void givenRequest_whenCreate_shouldReturnCorrectResult() {
        Item actual = prepareAndExecuteRequest();

        assertThat(actual.getId()).isNotNull();
        assertThat(actual.getName()).isEqualTo(createItemRequest.getName());
        assertThat(actual.getPrice()).isEqualTo(createItemRequest.getPrice());
        assertThat(actual.getImageUrl()).isEqualTo(createItemRequest.getImageUrl());
    }

    private Item prepareAndExecuteRequest() {
        stubSavedEntity();

        return itemGateway.create(createItemRequest);
    }

    private void stubSavedEntity() {
        ItemEntity saved = ItemEntity.valueOf(createItemRequest);
        saved.setId(1L);

        when(itemRepository.save(any())).thenReturn(saved);
    }
}
