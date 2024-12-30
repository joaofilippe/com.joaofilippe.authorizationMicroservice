package com.joaofilippe.authorizationmicroservice.app.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.UUID;

@Data
@AllArgsConstructor
public class User {
    private UUID id;
    private String username;
    private String password;
    private String email;
}
