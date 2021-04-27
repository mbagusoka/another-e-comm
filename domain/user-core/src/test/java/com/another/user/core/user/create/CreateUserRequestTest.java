package com.another.user.core.user.create;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CreateUserRequestTest {

    @Test
    void givenNullEmail_whenCreateUserRequest_shouldThrowException() {
        CreateUserRequest request = new CreateUserRequest(null, "dummy", "0123", "dummy");

        Exception e = assertThrows(ConstraintViolationException.class, request::validate);

        assertThat(e.getMessage()).isEqualTo("email: Email cannot be empty");
    }

    @Test
    void givenEmailFormatInvalid_whenCreateUserRequest_shouldThrowException() {
        CreateUserRequest request = new CreateUserRequest("dummy", "dummy", "0123", "dummy");

        Exception e = assertThrows(ConstraintViolationException.class, request::validate);

        assertThat(e.getMessage()).isEqualTo("email: Email format not valid");
    }

    @Test
    void givenNullName_whenCreateUserRequest_shouldThrowException() {
        CreateUserRequest request = new CreateUserRequest("du@m.y", null, "0123", "dummy");

        Exception e = assertThrows(ConstraintViolationException.class, request::validate);

        assertThat(e.getMessage()).isEqualTo("name: Name cannot be empty");
    }

    @Test
    void givenNullPhone_whenCreateUserRequest_shouldThrowException() {
        CreateUserRequest request = new CreateUserRequest("du@m.y", "dummy", null, "dummy");

        Exception e = assertThrows(ConstraintViolationException.class, request::validate);

        assertThat(e.getMessage()).isEqualTo("phone: Phone cannot be empty");
    }

    @Test
    void givenNullPassword_whenCreateUserRequest_shouldThrowException() {
        CreateUserRequest request = new CreateUserRequest("du@m.y", "dummy", "0123", null);

        Exception e = assertThrows(ConstraintViolationException.class, request::validate);

        assertThat(e.getMessage()).isEqualTo("password: Password cannot be empty");
    }
}
