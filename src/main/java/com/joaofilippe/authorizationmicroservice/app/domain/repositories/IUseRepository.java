package com.joaofilippe.authorizationmicroservice.app.domain.repositories;

import com.joaofilippe.authorizationmicroservice.app.domain.entities.User;

import java.util.UUID;

public interface IUseRepository {
   public User save(User user);
    public User getById(UUID id);
}
