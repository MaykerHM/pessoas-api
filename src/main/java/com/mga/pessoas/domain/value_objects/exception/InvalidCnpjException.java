package com.mga.pessoas.domain.value_objects.exception;

public class InvalidCnpjException extends IllegalArgumentException {
    public InvalidCnpjException(String cnpj) {
        super("Invalid CNPJ: " + cnpj);
    }
}
