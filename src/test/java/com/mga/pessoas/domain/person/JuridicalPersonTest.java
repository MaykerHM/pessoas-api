package com.mga.pessoas.domain.person;

import com.mga.pessoas.domain.value_objects.Cnpj;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
public class JuridicalPersonTest {

    private final String VALID_CNPJ = "92501222000106";
    private final String INVALID_CNPJ = "92501222000105";
    private final String COMPANY_NAME = "fake company name";

    @Test
    public void whenCnpjIsValid_shouldCreateJuridicalPerson() {
        var validCnpj = new Cnpj(VALID_CNPJ);
        var juridicalPerson = new JuridicalPerson(COMPANY_NAME,validCnpj);
        assertEquals(juridicalPerson.getCnpj(), VALID_CNPJ);
        assertEquals(juridicalPerson.getCompanyName(), COMPANY_NAME);
    }
}
