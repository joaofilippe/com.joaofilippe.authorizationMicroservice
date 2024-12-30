package com.joaofilippe.authorizationmicroservice.app.domain.usecases.user;

import com.joaofilippe.authorizationmicroservice.app.domain.entities.User;
import com.joaofilippe.authorizationmicroservice.app.domain.repositories.IUseRepository;

public class CreateUseCase {
    private final IUseRepository userRepository;

    public CreateUseCase(IUseRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        userRepository.save(user);
    }
}
