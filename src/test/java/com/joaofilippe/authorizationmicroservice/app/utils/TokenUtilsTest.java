package com.joaofilippe.authorizationmicroservice.app.utils;

import com.joaofilippe.authorizationmicroservice.app.domain.entities.User;
import com.panfutov.result.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TokenUtilsTest {
    private TokenUtils tokenUtils;

    @BeforeEach
    void setUp() {
        tokenUtils = new TokenUtils();
        ReflectionTestUtils.setField(tokenUtils, "secretKey", "your-secret-key");
        ReflectionTestUtils.setField(tokenUtils, "expirationTime", 864_000_000L); // 10 days in milliseconds
    }

    @Test
    @DisplayName("Should generate a token")
    public void generateToken_ShouldGenerateToken() {
        User object = new User("username", "password", "email");

        Result token = tokenUtils.generateToken(object);

        assertNotNull(token);
    }

    @Test
    @DisplayName("Should parse a token")
    void parseToken() {
        User object = new User("username_test", "password_test", "email_test");

        Result tokenResult = tokenUtils.generateToken(object);

        String token = (String) tokenResult.getObject();

        User user = tokenUtils.parseToken(token);

        assertNotNull(user);
    }
}