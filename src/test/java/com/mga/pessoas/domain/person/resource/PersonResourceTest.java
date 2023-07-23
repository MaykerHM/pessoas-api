package com.mga.pessoas.domain.person.resource;

import com.mga.pessoas.domain.person.JuridicalPerson;
import com.mga.pessoas.domain.person.Person;
import com.mga.pessoas.domain.person.service.PersonService;
import com.mga.pessoas.resource.PersonResource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = PersonResource.class)
public class PersonResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    private final String VALID_CNPJ = "92501222000106";

    private final String COMPANY_NAME = "fake company name";

    private final String VALID_EMAIL = "fake.valid@email.com";

    Person juridicalPerson = new JuridicalPerson(COMPANY_NAME, VALID_CNPJ, VALID_EMAIL, null);

    @Test
    public void getById_whenOk_shouldReturn200() throws Exception {
        when(personService.findById(any(Long.class))).thenReturn(juridicalPerson);
        mockMvc.perform(get("/api/v1/persons/{id}", 1L)
                        .contentType("application/json"))
                .andExpect(status().isOk());
    }
}