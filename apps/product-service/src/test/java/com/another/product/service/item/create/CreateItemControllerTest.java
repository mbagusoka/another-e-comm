package com.another.product.service.item.create;

import com.another.product.client.request.CreateItemRestRequest;
import com.another.product.client.response.CreateItemRestResponse;
import com.another.product.core.item.create.CreateItem;
import com.another.product.core.item.create.CreateItemPresenter;
import com.another.product.core.item.create.CreateItemRequest;
import com.another.product.core.item.create.CreateItemResponse;
import com.another.product.service.common.Randomizer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;

class CreateItemControllerTest {

    private final CreateItemRestRequest restRequest = Randomizer.get(CreateItemRestRequest.class);

    @InjectMocks
    private CreateItemController controller;

    @Mock
    private CreateItem createItem;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void givenRequest_whenCreate_shouldCallCreateItem() {
        controller.create(restRequest);

        verify(createItem).create(any(), any());
    }

    @Test
    void givenRequest_whenCreate_shouldCallCreateItemWithCorrectRequest() {
        controller.create(restRequest);

        ArgumentCaptor<CreateItemRequest> captor = ArgumentCaptor.forClass(CreateItemRequest.class);
        verify(createItem).create(captor.capture(), any());
        CreateItemRequest actual = captor.getValue();

        assertThat(actual.getName()).isEqualTo(restRequest.getName());
        assertThat(actual.getPrice()).isEqualTo(restRequest.getPrice());
        assertThat(actual.getImageUrl()).isEqualTo(restRequest.getImageUrl());
    }

    @Test
    void givenRequest_whenCreate_shouldCallCreateItemWithCorrectPresenter() {
        controller.create(restRequest);

        ArgumentCaptor<CreateItemPresenter> captor = ArgumentCaptor.forClass(CreateItemPresenter.class);
        verify(createItem).create(any(), captor.capture());
        CreateItemPresenter actual = captor.getValue();

        assertThat(actual).isInstanceOf(CreateItemRestPresenter.class);
    }

    @Test
    void givenRequest_whenCreate_shouldReturnCorrectResult() {
        stubResponse();

        Object actual = controller.create(restRequest);

        assertThat(actual)
            .isNotNull()
            .isInstanceOf(CreateItemRestResponse.class);
    }

    private void stubResponse() {
        doAnswer(this::getResponseAnswer).when(createItem).create(any(), any());
    }

    private Void getResponseAnswer(InvocationOnMock invocation) {
        CreateItemRestPresenter restPresenter = invocation.getArgument(1);
        CreateItemResponse response = Randomizer.get(CreateItemResponse.class);

        restPresenter.present(response);

        return null;
    }
}
