package com.another.user.core.user.create;

import com.another.common.validator.ValidationAware;
import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Value
@EqualsAndHashCode(callSuper = false)
public class CreateUserRequest extends ValidationAware<CreateUserRequest> {

    @NotNull(message = "Email cannot be empty")
    @Email(message = "Email format not valid")
    String email;

    @NotBlank(message = "Name cannot be empty")
    String name;

    @NotBlank(message = "Phone cannot be empty")
    String phone;

    @NotBlank(message = "Password cannot be empty")
    String password;
}
