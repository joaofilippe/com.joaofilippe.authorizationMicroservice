package com.joaofilippe.authorizationmicroservice.app.domain.usecases.user;

import com.joaofilippe.authorizationmicroservice.app.domain.entities.User;
import com.joaofilippe.authorizationmicroservice.app.domain.failures.UseCaseError;
import com.joaofilippe.authorizationmicroservice.app.domain.repositories.IUserRepository;
import com.panfutov.result.Result;

import java.util.UUID;

public class GetByIdUseCase extends UserUseCase {
    public GetByIdUseCase(
            IUserRepository userRepository
    ) {
        super(userRepository);
    }

    public Result<User> execute(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }


        User user = super.userRepository.getById(id);
        if (user == null) {
            return Result.failure(UseCaseError.userIdNotFound());
        }

        return Result.success(user);
    }
}
