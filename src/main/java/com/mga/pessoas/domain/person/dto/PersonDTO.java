package com.mga.pessoas.domain.person.dto;

import com.mga.pessoas.domain.value_objects.Address;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public class PersonDTO {

    @NotNull
    private String name;

    @NotNull
    private String document;

    @NotNull
    private String email;

    @NotNull
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

