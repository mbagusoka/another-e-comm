package com.another.user.core.user.create;

import com.another.user.core.user.entity.User;
import lombok.Value;

@Value
public class CreateUserResponse {

    Long id;

    String email;

    String name;

    String phone;

    String password;

    boolean isActive;

    public static CreateUserResponse valueOf(User createdUser) {
        return new CreateUserResponse(
            createdUser.getId(),
            createdUser.getEmail(),
            createdUser.getName(),
            createdUser.getPhone(),
            createdUser.getPassword(),
            createdUser.isActive()
        );
    }
}
