package com.mga.pessoas.domain.value_objects;

import com.mga.pessoas.domain.value_objects.exception.InvalidCpfException;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

import static java.lang.Integer.parseInt;

public class Cpf {

    private final String cpf;

    public Cpf(String cpf) {
        this.cpf = validate(cpf);
    }

    public String getCpf() {
        return cpf;
    }

    public static @NotNull String validate(@NotNull String cpf) {
        if (!isValid(cpf)) {
            throw new InvalidCpfException(cpf);
        }
        return cpf;
    }

    public static boolean isValid(@NotNull String cpf) {
        if (cpf.length() != 11) {
            return  false;
        }

        var sum = 0;
        if (Objects.equals(cpf, "00000000000")) {
            return false;
        }

        for (int i = 1; i <= 9; i++) {
            sum = sum + parseInt(cpf.substring(i - 1, i)) * (11 - i);
        }

        var remainder = (sum * 10) % 11;
        if (remainder == 10) {
            remainder = 0;
        }

        if (remainder != parseInt(cpf.substring(9, 10))) {
            return false;
        }

        sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum = sum + parseInt(cpf.substring(i - 1, i)) * (12 - i);
        }

        remainder = (sum * 10) % 11;
        if (remainder == 10) {
            remainder = 0;
        }

        return remainder == parseInt(cpf.substring(10, 11));
    }
}
