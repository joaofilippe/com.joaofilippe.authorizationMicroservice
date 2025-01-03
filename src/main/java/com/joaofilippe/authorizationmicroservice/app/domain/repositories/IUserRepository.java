package com.joaofilippe.authorizationmicroservice.app.domain.repositories;

import com.joaofilippe.authorizationmicroservice.app.domain.entities.User;

import java.util.UUID;

public interface IUserRepository {
    void save(User user);

    User getById(UUID id);
}
