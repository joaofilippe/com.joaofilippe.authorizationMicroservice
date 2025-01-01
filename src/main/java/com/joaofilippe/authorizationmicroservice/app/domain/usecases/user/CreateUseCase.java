package com.joaofilippe.authorizationmicroservice.app.domain.usecases.user;

import com.joaofilippe.authorizationmicroservice.app.domain.entities.User;
import com.joaofilippe.authorizationmicroservice.app.domain.repositories.IUseRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CreateUseCase extends UserUseCase {
    public CreateUseCase(IUseRepository userRepository) {
        super(userRepository);
    }

    public User execute(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        User createdUser = user.setPassword(hashPassword(user.getPassword()));

        super.userRepository.save(createdUser);

        return createdUser;
    }


    private String hashPassword(String password) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }
}
