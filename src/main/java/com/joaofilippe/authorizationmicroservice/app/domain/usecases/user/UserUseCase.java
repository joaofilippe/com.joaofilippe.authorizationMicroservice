package com.joaofilippe.authorizationmicroservice.app.domain.usecases.user;

import com.joaofilippe.authorizationmicroservice.app.domain.irepositories.IUserRepository;

public abstract class UserUseCase {
    final IUserRepository userRepository;

    protected UserUseCase(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
