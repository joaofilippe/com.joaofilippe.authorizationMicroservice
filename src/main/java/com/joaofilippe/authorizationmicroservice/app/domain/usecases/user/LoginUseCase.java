package com.joaofilippe.authorizationmicroservice.app.domain.usecases.user;

import com.joaofilippe.authorizationmicroservice.app.domain.entities.User;
import com.joaofilippe.authorizationmicroservice.app.domain.failures.UseCaseError;
import com.joaofilippe.authorizationmicroservice.app.domain.irepositories.IUserRepository;
import com.joaofilippe.authorizationmicroservice.app.utils.PasswordUtils;
import com.joaofilippe.authorizationmicroservice.app.utils.TokenUtils;
import com.panfutov.result.Result;
import lombok.NonNull;

public class LoginUseCase extends UserUseCase {
    private final TokenUtils tokenUtils;
    private final PasswordUtils passwordUtils;

    public LoginUseCase(IUserRepository userRepository, TokenUtils tokenUtils, PasswordUtils passwordUtils) {
        super(userRepository);
        this.tokenUtils = tokenUtils;
        this.passwordUtils = passwordUtils;
    }

    public Result<String> execute(@NonNull String email, @NonNull String password) {
        User user = userRepository.getByEmail(email);
        if (user == null || !user.getPassword().equals(password)) {
            return Result.failure(UseCaseError.invalidCredentials());
        }

        if (!passwordUtils.checkPassword(password, user.getPassword())) {
            return Result.failure(UseCaseError.invalidCredentials());
        }

        return tokenUtils.generateToken(user);
    }
}
