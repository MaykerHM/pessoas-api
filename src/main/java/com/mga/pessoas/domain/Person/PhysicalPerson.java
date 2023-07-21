package com.mga.pessoas.domain.Person;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("physical")
public class PhysicalPerson extends Person {

    @NotNull
    @Column(length = 100)
    private String name;

    @NotNull
    @Column(length = 11)
    private String cpf;
}
