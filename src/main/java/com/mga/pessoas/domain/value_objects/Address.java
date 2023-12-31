package com.mga.pessoas.domain.value_objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mga.pessoas.domain.person.Person;
import com.mga.pessoas.domain.person.dto.AddressDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Entity(name="address")
public class Address {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    @Column(length = 50)
    private String street;

    @NotNull
    @Column(length = 10)
    private String number;

    @Column(length = 100)
    private String complement;

    @NotNull
    @Column(length = 50)
    private String city;

    @NotNull
    @Column(length = 2)
    private String state;

    @NotNull
    @Column(length = 8)
    private String postalCode;

    @NotNull
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    public Address(String street, String number, String complement, String city, String state, String postalCode, Person person) {
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.person = person;
    }
    public Address() {
    }

    public static Address of(AddressDTO dto, Person person) {
        return new Address(dto.getStreet(), dto.getNumber(), dto.getComplement(), dto.getCity(), dto.getState(), dto.getPostalCode(), person);
    }

    public UUID getId() {
        return id;
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

    public Person getPerson() {
        return person;
    }
}
