package com.joaofilippe.authorizationmicroservice.app.data.repositories;

import com.joaofilippe.authorizationmicroservice.app.data.mappers.UserMapper;
import com.joaofilippe.authorizationmicroservice.app.domain.entities.User;
import com.joaofilippe.authorizationmicroservice.app.domain.irepositories.IUserRepository;
import com.joaofilippe.authorizationmicroservice.infra.database.IUserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserRepository implements IUserRepository {
    @Autowired
    private IUserDatabase userDatabase;


    @Override
    public void save(User user) {
        userDatabase.save(UserMapper.toDbEntity(user));
    }

    @Override
    public User getById(UUID id) {
        return null;
    }

    @Override
    public User getByEmail(String email) {
        return null;
    }
}