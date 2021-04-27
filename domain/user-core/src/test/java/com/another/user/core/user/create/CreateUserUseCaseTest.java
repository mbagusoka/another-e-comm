package com.another.user.core.user.create;

import com.another.user.core.common.Randomizer;
import com.another.user.core.user.entity.User;
import com.another.user.core.user.gateway.UserCommandGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.validation.ConstraintViolationException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CreateUserUseCaseTest {

    private final CreateUserRequest request = Randomizer.get(CreateUserRequest.class);

    @InjectMocks
    private CreateUserUseCase useCase;

    @Mock
    private UserCommandGateway userCommandGateway;

    @Mock
    private CreateUserPresenter presenter;

    @Mock
    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void givenNullRequest_whenCreate_shouldThrowException() {
        Executable task = () -> useCase.create(null, presenter);

        Exception e = assertThrows(IllegalArgumentException.class, task);

        assertThat(e.getMessage()).isEqualTo("Request cannot be null");
    }

    @Test
    void givenNullPresenter_whenCreate_shouldThrowException() {
        Executable task = () -> useCase.create(request, null);

        Exception e = assertThrows(IllegalArgumentException.class, task);

        assertThat(e.getMessage()).isEqualTo("Presenter cannot be null");
    }

    @Test
    void givenNullEmail_whenCreate_shouldThrowException() {
        CreateUserRequest userRequest = new CreateUserRequest(null, "dummy", "123", "dummy");
        Executable task = () -> useCase.create(userRequest, presenter);

        Exception e = assertThrows(ConstraintViolationException.class, task);

        assertThat(e.getMessage()).isEqualTo("email: Email cannot be empty");
    }

    @Test
    void givenRequest_whenCreate_shouldCallUserGateway() {
        prepareAndExecute();

        verify(userCommandGateway).save(request);
    }

    @Test
    void givenRequest_whenCreate_shouldCallPresenter() {
        prepareAndExecute();

        verify(presenter).present(any());
    }

    @Test
    void givenRequest_whenCreate_shouldCallPresenterWithCorrectResponse() {
        prepareAndExecute();

        ArgumentCaptor<CreateUserResponse> captor = ArgumentCaptor.forClass(CreateUserResponse.class);
        verify(presenter).present(captor.capture());
        CreateUserResponse actual = captor.getValue();

        assertThat(actual).isNotNull();
    }

    private void prepareAndExecute() {
        stubUser();

        useCase.create(request, presenter);
    }

    private void stubUser() {
        when(user.getId()).thenReturn(1L);
        when(user.getEmail()).thenReturn("du@m.my");
        when(user.getName()).thenReturn("dummy");
        when(user.getPhone()).thenReturn("123");
        when(user.getPassword()).thenReturn("dummy");

        when(userCommandGateway.save(any())).thenReturn(user);
    }
}
