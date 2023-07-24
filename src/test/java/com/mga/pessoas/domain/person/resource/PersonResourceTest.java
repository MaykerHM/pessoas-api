package com.mga.pessoas.domain.person.resource;

import com.mga.pessoas.domain.person.JuridicalPerson;
import com.mga.pessoas.domain.person.Person;
import com.mga.pessoas.domain.person.dto.PersonDTO;
import com.mga.pessoas.domain.person.dto.PersonUpdateDTO;
import com.mga.pessoas.domain.person.exception.PersonAlreadyExistsWithDocumentException;
import com.mga.pessoas.domain.person.service.PersonService;
import com.mga.pessoas.resource.PersonResource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
        mockMvc.perform(get("/v1/persons/{id}", 1L)
                        .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    public void createPerson_whenOk_shouldReturn201() throws Exception, PersonAlreadyExistsWithDocumentException {
        when(personService.create(any(PersonDTO.class))).thenReturn(juridicalPerson);
        mockMvc.perform(post("/v1/persons")
                        .contentType("application/json")
                        .content("""
                                {
                                    "name": "Fulano",
                                    "document": "79498440000",
                                    "email": "fulano@email.com",
                                    "personType": "juridical",
                                    "addresses": [
                                        {
                                            "street": "Rua Rui Barbosa",
                                            "number": "754",
                                            "complement": "Casa",
                                            "city": "Maringá",
                                            "state": "PR",
                                            "postalCode": "87020090"
                                        }
                                    ]
                                }"""))
                .andExpect(status().isCreated());
    }

    @Test
    public void updatePerson_whenOk_shouldReturn200() throws Exception {
        when(personService.update(any(PersonUpdateDTO.class), any(Long.class))).thenReturn(juridicalPerson);
        mockMvc.perform(put("/v1/persons/{id}", 1L)
                        .contentType("application/json")
                        .content("""
                                {
                                    "name": "Fulano",
                                    "document": "79498440000",
                                    "email": "fulano@email.com",
                                    "personType": "juridical",
                                    "addresses": [
                                        {
                                            "street": "Rua Rui Barbosa",
                                            "number": "754",
                                            "complement": "Casa",
                                            "city": "Maringá",
                                            "state": "PR",
                                            "postalCode": "87020090"
                                        }
                                    ]
                                }"""))
                .andExpect(status().isOk());
    }
}
