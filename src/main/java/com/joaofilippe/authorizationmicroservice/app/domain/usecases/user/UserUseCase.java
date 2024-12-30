package com.joaofilippe.authorizationmicroservice.app.domain.usecases.user;

import com.joaofilippe.authorizationmicroservice.app.domain.repositories.IUseRepository;

public abstract class UserUseCase {
    final IUseRepository userRepository;

    protected UserUseCase(IUseRepository userRepository) {
        this.userRepository = userRepository;
    }
}
