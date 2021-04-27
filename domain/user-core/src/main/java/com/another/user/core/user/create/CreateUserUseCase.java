package com.another.user.core.user.create;

import com.another.user.core.user.entity.User;
import com.another.user.core.user.gateway.UserCommandGateway;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateUserUseCase implements CreateUser {

    private final UserCommandGateway userCommandGateway;

    @Override
    public void create(CreateUserRequest request, CreateUserPresenter presenter) {
        validateRequest(request, presenter);

        doCreate(request, presenter);
    }

    private void doCreate(CreateUserRequest request, CreateUserPresenter presenter) {
        User createdUser = userCommandGateway.save(request);
        CreateUserResponse response = CreateUserResponse.valueOf(createdUser);

        presenter.present(response);
    }

    private void validateRequest(CreateUserRequest request, CreateUserPresenter presenter) {
        if (null == request) {
            throw new IllegalArgumentException("Request cannot be null");
        }

        if (null == presenter) {
            throw new IllegalArgumentException("Presenter cannot be null");
        }

        request.validate();
    }
}
