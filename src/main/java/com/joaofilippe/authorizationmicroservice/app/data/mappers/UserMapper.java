package com.joaofilippe.authorizationmicroservice.app.data.mappers;

import com.joaofilippe.authorizationmicroservice.app.data.entities.UserDbEntity;
import com.joaofilippe.authorizationmicroservice.app.domain.entities.User;

public class UserMapper {
    public static User fromDbEntity(UserDbEntity userDbEntity) {
        return new User(
                userDbEntity.getId(),
                userDbEntity.getUsername(),
                userDbEntity.getPassword(),
                userDbEntity.getEmail()
        );
    }

    public static UserDbEntity toDbEntity(User user) {
        return new UserDbEntity(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword()
        );
    }
}
