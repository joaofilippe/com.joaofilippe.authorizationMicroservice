package com.joaofilippe.authorizationmicroservice.app.domain.usecases.user;

import com.joaofilippe.authorizationmicroservice.app.domain.repositories.IUseRepository;

import java.util.UUID;

public class GetByIdUseCase extends UserUseCase{
    public GetByIdUseCase(IUseRepository userRepository) {
        super(userRepository);
    }

    public void execute(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }

        super.userRepository.getById(id);
    }
}
