package com.joaofilippe.authorizationmicroservice.app.domain.entities;


import lombok.*;

import java.util.Map;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class User {
    private UUID id;
    private String username;
    private String password;
    private String email;

    public static User fromMap(Map<String, Object> map) {
        UUID id = UUID.fromString((String) map.get("id"));
        String username = (String) map.get("username");
        String password = (String) map.get("password");
        String email = (String) map.get("email");

        return new User(id, username, password, email);
    }

    public User(@NonNull String username, @NonNull String password, @NonNull String email) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User copyWith(String username, String password, String email) {
        return new User(
                username != null ? username : this.username,
                password != null ? password : this.password,
                email != null ? email : this.email
        );
    }

    public User setPassword(String password) {
        return copyWith(null, password, null);
    }
}
