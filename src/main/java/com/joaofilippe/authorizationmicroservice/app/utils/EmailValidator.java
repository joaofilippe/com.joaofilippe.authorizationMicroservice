package com.joaofilippe.authorizationmicroservice.app.utils;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class EmailValidator {
    private final String EMAIL_PATTERN =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    private final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}