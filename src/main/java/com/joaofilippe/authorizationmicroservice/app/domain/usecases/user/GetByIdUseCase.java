package com.joaofilippe.authorizationmicroservice.app.domain.usecases.user;

import com.joaofilippe.authorizationmicroservice.app.domain.repositories.IUseRepository;
import com.joaofilippe.authorizationmicroservice.app.utils.EmailValidator;

import java.util.UUID;

public class GetByIdUseCase extends UserUseCase {
    EmailValidator emailValidator;

    public GetByIdUseCase(
            IUseRepository userRepository,
            EmailValidator emailValidator
    ) {
        super(userRepository);
        this.emailValidator = emailValidator;
    }

    public void execute(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }

        super.userRepository.getById(id);
    }
}
