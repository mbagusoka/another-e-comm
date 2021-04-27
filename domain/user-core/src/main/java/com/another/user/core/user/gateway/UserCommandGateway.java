package com.another.user.core.user.gateway;

import com.another.user.core.user.create.CreateUserRequest;
import com.another.user.core.user.entity.User;

public interface UserCommandGateway {

    User save(CreateUserRequest request);
}
