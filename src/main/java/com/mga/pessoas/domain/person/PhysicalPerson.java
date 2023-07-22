package com.mga.pessoas.domain.person;

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
    private String cpf;

    public PhysicalPerson(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }
}
