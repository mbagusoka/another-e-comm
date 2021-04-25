package com.another.product.item.create;

import com.another.product.common.Randomizer;
import com.another.product.gateway.ItemGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CreateItemUseCaseTest {

    private final CreateItemRequest request = Randomizer.get(CreateItemRequest.class);

    @InjectMocks
    private CreateItemUseCase useCase;

    @Mock
    private ItemGateway itemGateway;

    @Mock
    private CreateItemPresenter presenter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void givenNullRequest_whenCreate_shouldThrowException() {
        Executable task = () -> useCase.create(null, presenter);

        Exception e = assertThrows(NullPointerException.class, task);

        assertThat(e.getMessage()).isEqualTo("request is marked non-null but is null");
    }

    @Test
    void givenRequest_whenCreate_shouldCallItemGateway() {
        prepareAndExecute();

        verify(itemGateway).create(request);
    }

    @Test
    void givenRequest_whenCreate_shouldCallPresenter() {
        prepareAndExecute();

        verify(presenter).present(any());
    }

    @Test
    void givenRequest_whenCreate_shouldCallPresenterWithCorrectResponse() {
        prepareAndExecute();

        ArgumentCaptor<CreateItemResponse> captor = ArgumentCaptor.forClass(CreateItemResponse.class);
        verify(presenter).present(captor.capture());
        CreateItemResponse actual = captor.getValue();

        assertThat(actual).isNotNull();
    }

    private void prepareAndExecute() {
        stubItem();

        useCase.create(request, presenter);
    }

    private void stubItem() {
        CreateItemResponse response = Randomizer.get(CreateItemResponse.class);

        when(itemGateway.create(any())).thenReturn(response);
    }
}
