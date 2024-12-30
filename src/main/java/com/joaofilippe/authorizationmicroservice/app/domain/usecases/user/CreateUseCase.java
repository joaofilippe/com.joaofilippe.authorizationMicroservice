package com.joaofilippe.authorizationmicroservice.app.domain.usecases.user;

import com.joaofilippe.authorizationmicroservice.app.domain.entities.User;
import com.joaofilippe.authorizationmicroservice.app.domain.repositories.IUseRepository;

public class CreateUseCase extends UserUseCase {
    public CreateUseCase(IUseRepository userRepository) {
        super(userRepository);
    }

    public void execute(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        super.userRepository.save(user);
    }
}
