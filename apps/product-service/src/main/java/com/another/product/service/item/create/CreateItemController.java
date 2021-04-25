package com.another.product.service.item.create;

import com.another.product.client.request.CreateItemRestRequest;
import com.another.product.client.response.CreateItemRestResponse;
import com.another.product.core.item.create.CreateItem;
import com.another.product.core.item.create.CreateItemRequest;
import com.another.product.service.constant.Routes;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreateItemController {

    private final CreateItem createItem;

    @PostMapping(Routes.ITEM)
    @ResponseStatus(HttpStatus.CREATED)
    public CreateItemRestResponse create(@RequestBody CreateItemRestRequest restRequest) {
        CreateItemRequest itemRequest = getItemRequest(restRequest);
        CreateItemRestPresenter restPresenter = new CreateItemRestPresenter();
        createItem.create(itemRequest, restPresenter);

        return restPresenter.getResponse();
    }

    private CreateItemRequest getItemRequest(CreateItemRestRequest restRequest) {
        return new CreateItemRequest(restRequest.getName(), restRequest.getPrice(), restRequest.getImageUrl());
    }

}
