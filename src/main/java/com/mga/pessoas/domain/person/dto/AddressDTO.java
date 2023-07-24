package com.mga.pessoas.domain.person.dto;


import jakarta.validation.constraints.Size;

public class AddressDTO {

    @Size(max = 50)
    private String street;

    @Size(max = 10)
    private String number;

    @Size(max = 100)
    private String complement;

    @Size(max = 50)
    private String city;

    @Size(max = 2)
    private String state;

    @Size(max = 8)
    private String postalCode;

    public static AddressDTO of(String street, String number, String complement, String city, String state, String postalCode) {
        AddressDTO dto = new AddressDTO();
        dto.street = street;
        dto.number = number;
        dto.complement = complement;
        dto.city = city;
        dto.state = state;
        dto.postalCode = postalCode;
        return dto;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getComplement() {
        return complement;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostalCode() {
        return postalCode;
    }

}
