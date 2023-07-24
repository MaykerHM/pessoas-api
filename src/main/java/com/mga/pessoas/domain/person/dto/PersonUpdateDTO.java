package com.mga.pessoas.domain.person.dto;

import jakarta.validation.constraints.Size;

import java.util.List;

public class PersonUpdateDTO {
    @Size(max = 100)
    private String name;

    @Size(max = 14, min = 11)
    private String document;

    @Size(max = 100)
    private String email;

    @Size(max = 20)
    private String personType;

    private List<AddressDTO> addresses;

    public static PersonUpdateDTO of(String name, String document, String email, String personType, List<AddressDTO> addresses) {
        PersonUpdateDTO dto = new PersonUpdateDTO();
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

