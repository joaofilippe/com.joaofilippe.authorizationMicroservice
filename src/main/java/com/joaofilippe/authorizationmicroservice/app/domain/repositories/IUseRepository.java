package com.joaofilippe.authorizationmicroservice.app.domain.repositories;

import com.joaofilippe.authorizationmicroservice.app.domain.entities.User;

public interface IUseRepository {
   public void save(User user);
}
