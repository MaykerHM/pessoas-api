package com.mga.pessoas.domain.Person;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("juridical")
public class JuridicalPerson extends Person {

    @NotNull
    @Column(length = 100)
    private String companyName;

    @NotNull
    @Column(length = 14)
    private String cnpj;
}
