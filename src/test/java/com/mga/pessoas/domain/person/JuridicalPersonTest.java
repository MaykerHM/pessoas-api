package com.mga.pessoas.domain.person;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(SpringExtension.class)
public class JuridicalPersonTest {

    private final String VALID_CNPJ = "92501222000106";

    private final String INVALID_CNPJ = "92501222000105";
    private final String COMPANY_NAME = "fake company name";

    private final String VALID_EMAIL = "fake.email@email.com";

    private final String INVALID_EMAIL = "92501222000106";

    @Test
    public void whenCnpjIsValid_shouldCreateJuridicalPerson() {
        var juridicalPerson = new JuridicalPerson(COMPANY_NAME,VALID_CNPJ,VALID_EMAIL, null);
        assertEquals(juridicalPerson.getCnpj(), VALID_CNPJ);
        assertEquals(juridicalPerson.getCompanyName(), COMPANY_NAME);
    }

    @Test
    public void whenCnpjIsNotValid_shouldThrow() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new JuridicalPerson(COMPANY_NAME,INVALID_CNPJ, VALID_EMAIL, null);
        });

        assertEquals(exception.getMessage(), "Invalid CNPJ: " + INVALID_CNPJ);
    }
}
