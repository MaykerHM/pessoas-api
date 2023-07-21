package com.mga.pessoas.domain.Person;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mga.pessoas.domain.address.Address;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "personType")
public abstract class Person {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    @Column(length = 100)
    private String email;

    @OneToMany(mappedBy="person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Address> addresses;
}
