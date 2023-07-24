package com.mga.pessoas.domain.value_objects.exception;

public class InvalidEmailException extends IllegalArgumentException {
    public InvalidEmailException(String email) {
        super("Invalid Email: " + email);
    }
}
