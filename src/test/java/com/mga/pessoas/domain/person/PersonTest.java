package com.mga.pessoas.domain.person;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(SpringExtension.class)
public class PersonTest {

    private final String VALID_CNPJ = "92501222000106";

    private final String COMPANY_NAME = "fake company name";

    private final String VALID_EMAIL = "fake.email@email.com";

    private final String INVALID_EMAIL = "fake.email.@email.com";


    @Test
    public void whenEmailIsValid_shouldCreateJuridicalPerson() {
        var juridicalPerson = new JuridicalPerson(COMPANY_NAME,VALID_CNPJ,VALID_EMAIL, null);
        assertEquals(juridicalPerson.getEmail(), VALID_EMAIL);
    }
}
