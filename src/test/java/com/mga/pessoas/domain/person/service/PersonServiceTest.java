package com.mga.pessoas.domain.person.service;

import com.mga.pessoas.domain.person.JuridicalPerson;
import com.mga.pessoas.domain.person.Person;
import com.mga.pessoas.domain.person.exception.PersonNotFoundByIdException;
import com.mga.pessoas.domain.person.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(SpringExtension.class)
public class PersonServiceTest {

    @InjectMocks
    private PersonService personService;

    @Mock
    private PersonRepository personRepository;

    private final String VALID_CNPJ = "92501222000106";

    private final String COMPANY_NAME = "fake company name";

    private final String VALID_EMAIL = "fake.valid@email.com";

    Person juridicalPerson = new JuridicalPerson(COMPANY_NAME, VALID_CNPJ, VALID_EMAIL, null);


    @Test
    public void findById_whenOk_shouldReturnPerson() {
        when(personRepository.findById(any(Long.class))).thenReturn(Optional.of(juridicalPerson));
        personService.findById(1L);

        verify(personRepository, times(1)).findById(any(Long.class));
    }

    @Test
    public void findById_whenNotExistsPerson_shouldThrow() {
        when(personRepository.findById(any(Long.class))).thenReturn(Optional.empty());

        Exception exception = assertThrows(PersonNotFoundByIdException.class, () -> {
            personService.findById(1L);
        });

        assertEquals(exception.getMessage(), "Person not found with id: 1");
    }

}