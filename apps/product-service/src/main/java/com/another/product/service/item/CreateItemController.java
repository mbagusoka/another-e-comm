package com.another.product.service.item;

import com.another.product.core.item.create.CreateItem;
import com.another.product.core.item.create.CreateItemPresenter;
import com.another.product.core.item.create.CreateItemRequest;
import com.another.product.core.item.create.CreateItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class CreateItemController {

    private final CreateItem createItem;

    @PostMapping("/item")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateItemRestResponse create(@RequestBody @Valid CreateItemRestRequest restRequest) {
        CreateItemRequest itemRequest = restRequest.getItemRequest();
        CreateItemRestPresenter restPresenter = new CreateItemRestPresenter();
        createItem.create(itemRequest, restPresenter);

        return restPresenter.getResponse();
    }

    private static class CreateItemRestPresenter implements CreateItemPresenter {

        private CreateItemRestResponse restResponse;

        @Override
        public void present(CreateItemResponse response) {
            restResponse = CreateItemRestResponse.valueOf(response);
        }

        public CreateItemRestResponse getResponse() {
            return restResponse;
        }
    }
}
