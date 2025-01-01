package com.joaofilippe.authorizationmicroservice.app.domain.usecases.user;

import com.joaofilippe.authorizationmicroservice.app.domain.entities.User;
import com.joaofilippe.authorizationmicroservice.app.domain.repositories.IUseRepository;
import com.joaofilippe.authorizationmicroservice.app.utils.PasswordUtils;

public class CreateUseCase extends UserUseCase {
    PasswordUtils passwordUtils;

    public CreateUseCase(IUseRepository userRepository, PasswordUtils passwordUtils) {
        super(userRepository);
        this.passwordUtils = passwordUtils;
    }

    public User execute(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        String hashedPassword = this.passwordUtils.hashPassword(user.getPassword());

        User createdUser = user.setPassword(hashedPassword);

        super.userRepository.save(createdUser);

        return createdUser;
    }
}
