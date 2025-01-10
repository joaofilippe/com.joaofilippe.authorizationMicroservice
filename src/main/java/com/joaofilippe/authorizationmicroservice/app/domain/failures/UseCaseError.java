package com.joaofilippe.authorizationmicroservice.app.domain.failures;

import com.panfutov.result.GenericError;

import java.util.Map;
import java.util.Optional;

public class UseCaseError implements GenericError {
    private final String message;
    private final Throwable throwable;

    public UseCaseError(String message, Throwable throwable) {
        this.message = message;
        this.throwable = throwable;
    }

    public UseCaseError(String message) {
        this.message = message;
        this.throwable = null;
    }

    static public UseCaseError userIdNotFound() {
        return new UseCaseError("User not found");
    }

    static public UseCaseError invalidCredentials() {
        return new UseCaseError("Email or password incorrect");
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Optional<Throwable> getThrowable() {
        return Optional.ofNullable(throwable);
    }

    @Override
    public Optional<Map<String, ?>> getMetadata() {
        return Optional.empty();
    }
}
