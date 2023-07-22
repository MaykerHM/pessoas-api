package com.mga.pessoas.domain.value_objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mga.pessoas.domain.person.Person;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity(name="address")
public class Address {

    @NotNull
    @Column(length = 50)
    private final String street;

    @NotNull
    @Column(length = 10)
    private final String number;

    @Column(length = 100)
    private final String complement;

    @NotNull
    @Column(length = 50)
    private final String city;

    @NotNull
    @Column(length = 2)
    private final String state;

    @NotNull
    @Column(length = 8)
    private final String postalCode;

    @NotNull
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private final Person person;

    public Address(String street, String number, String complement, String city, String state, String postalCode, Person person) {
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.person = person;
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
