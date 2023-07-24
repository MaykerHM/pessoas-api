package com.mga.pessoas.domain.value_objects.exception;

public class InvalidCpfException extends IllegalArgumentException {
    public InvalidCpfException(String cpf) {
        super("Invalid CPF: " + cpf);
    }
}
