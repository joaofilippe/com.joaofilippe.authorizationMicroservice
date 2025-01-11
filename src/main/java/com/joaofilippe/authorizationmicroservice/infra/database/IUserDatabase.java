package com.joaofilippe.authorizationmicroservice.infra.database;

import com.joaofilippe.authorizationmicroservice.app.data.entities.UserDbEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public interface IUserDatabase extends JpaRepository<UserDbEntity, UUID> {
}
