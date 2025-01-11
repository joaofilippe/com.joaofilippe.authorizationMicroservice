package com.joaofilippe.authorizationmicroservice.app.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.joaofilippe.authorizationmicroservice.app.domain.entities.User;
import com.panfutov.result.Result;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TokenUtils {
    @Value("${SECRET_KEY}")
    private String secretKey;
    @Value("${EXPIRATION_TIME}")
    private long expirationTime;

    public Result<String> generateToken(Object object) {
        try {
            String claim = new ObjectMapper().writeValueAsString(object);

            if (expirationTime == 0) {
                expirationTime = TimeUnit.HOURS.toMillis(72);
            }

            Date now = new Date(System.currentTimeMillis());

            String token = JWT.create()
                    .withClaim("claim", claim)
                    .withIssuedAt(now)
                    .withExpiresAt(new Date(now.getTime() + expirationTime))
                    .sign(Algorithm.HMAC512(secretKey.getBytes()));

            return Result.success(token);
        } catch (Exception e) {
            return Result.failure("Error generating token", e);
        }
    }

    public User parseToken(String token) {
        try {
            String claimJSON = JWT.decode(token).getClaim("claim").asString();
            Map<String, Object> claim = new ObjectMapper().readValue(claimJSON, Map.class);
            return User.fromMap(claim);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Error parsing token:\nError: %s", e));
        }
    }
}
