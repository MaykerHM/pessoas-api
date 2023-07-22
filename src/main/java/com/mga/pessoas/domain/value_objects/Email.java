package com.mga.pessoas.domain.value_objects;


import jakarta.validation.constraints.NotNull;

import java.util.regex.Pattern;

public class Email {

    private final String email;

    public Email(String email) {
        this.email = validate(email);
    }

    public String getEmail() {
        return email;
    }

    public static @NotNull String validate(@NotNull String email) {
        if (!isValid(email)) {
            throw new IllegalArgumentException("Invalid Email: " + email);
        }
        return email;
    }

    public static boolean isValid(@NotNull String email) {
        Pattern pattern = Pattern.compile("^[\\-!#$%&'*+/0-9=?A-Z^_a-z`{|}~](\\.?[\\-!#$%&'*+/0-9=?A-Z^_a-z`{|}~])*@[a-zA-Z0-9](-*\\.?[a-zA-Z0-9])*\\.[a-zA-Z](-?[a-zA-Z0-9])+$");
        return pattern.matcher(email).matches();
    }
}
