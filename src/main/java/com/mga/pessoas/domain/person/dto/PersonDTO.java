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
    private List<Address> addresses;

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

    public List<Address> getAddresses() {
        return addresses;
    }
}

