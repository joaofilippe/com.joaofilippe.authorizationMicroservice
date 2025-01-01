package com.joaofilippe.authorizationmicroservice.app.domain.repositories;

import com.joaofilippe.authorizationmicroservice.app.domain.entities.User;

import java.util.UUID;

public interface IUseRepository {
   void save(User user);
    void getById(UUID id);
}
