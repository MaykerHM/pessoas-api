package com.mga.pessoas.domain.address;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mga.pessoas.domain.Person.Person;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

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
}
