package com.joaofilippe.authorizationmicroservice.app.domain.usecases.user;

import com.joaofilippe.authorizationmicroservice.app.domain.entities.User;
import com.joaofilippe.authorizationmicroservice.app.domain.repositories.IUserRepository;
import com.joaofilippe.authorizationmicroservice.app.utils.PasswordUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.Objects;

import static org.mockito.Mockito.verify;

public class CreateUseCaseTest {
    private IUserRepository userRepository;
    private CreateUseCase createUseCase;
    final PasswordUtils passwordUtils = new PasswordUtils();

    @BeforeEach
    void setUp() {
        userRepository = Mockito.mock(IUserRepository.class);
        createUseCase = new CreateUseCase(userRepository, passwordUtils);
    }

    @Test
    @DisplayName("Should save user when user is valid")
    public void execute_ShouldSaveUser_WhenUserIsValid() {
        User user = new User(
                "username",
                "password",
                "email");
        createUseCase.execute(user);

        verify(userRepository).save(ArgumentMatchers.isA(User.class));
    }

    @Test
    @DisplayName("Should hash the password")
    public void execute_ShouldHashPassword() {
        User user = new User(
                "username",
                "password",
                "email");

        user.setPassword("password");
        User createdUser = createUseCase.execute(user);

        verify(userRepository).save(ArgumentMatchers.isA(User.class));

        assert createdUser.getPassword() != null;
        assert !Objects.equals(user.getPassword(), createdUser.getPassword());
    }
}