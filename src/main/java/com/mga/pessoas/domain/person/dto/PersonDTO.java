package com.mga.pessoas.domain.person.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class PersonDTO {

    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Size(max = 14, min = 11)
    private String document;

    @NotNull
    @Size(max = 100)
    private String email;

    @NotNull
    @Size(max = 20)
    private String personType;

    @NotEmpty
    private List<AddressDTO> addresses;

    public static PersonDTO of(String name, String document, String email, String personType, List<AddressDTO> addresses) {
        PersonDTO dto = new PersonDTO();
        dto.name = name;
        dto.document = document;
        dto.email = email;
        dto.personType = personType;
        dto.addresses = addresses;
        return dto;
    }

    public String getName() {
        return name;
    }

    public String getDocument() {
        return document;
    }

    public String getEmail() {
        return email;
    }

    public String getPersonType() {
        return personType;
    }

    public List<AddressDTO> getAddresses() {
        return addresses;
    }
}

