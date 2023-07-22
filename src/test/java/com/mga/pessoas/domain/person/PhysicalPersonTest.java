package com.mga.pessoas.domain.person;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@ExtendWith(SpringExtension.class)
public class PhysicalPersonTest {

    private final String VALID_CPF = "22178476007";
    private final String INVALID_CPF = "22178476006";
    private final String NAME = "fake name";

    private final String VALID_EMAIL = "fake.email@email.com";

    @Test
    public void whenCpfIsValid_shouldCreatePhysicalPerson() {
        var physicalPerson = new PhysicalPerson(NAME, VALID_CPF, VALID_EMAIL, null);
        assertEquals(physicalPerson.getCpf(), VALID_CPF);
        assertEquals(physicalPerson.getName(), NAME);
    }

    @Test
    public void whenCpfIsNotValid_shouldThrow() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new PhysicalPerson(NAME, INVALID_CPF, VALID_EMAIL, null);
        });

        assertEquals(exception.getMessage(), "Invalid CPF: " + INVALID_CPF);
    }
}
