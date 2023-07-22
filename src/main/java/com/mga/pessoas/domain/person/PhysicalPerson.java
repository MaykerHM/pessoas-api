package com.mga.pessoas.domain.person;

import com.mga.pessoas.domain.value_objects.Address;
import com.mga.pessoas.domain.value_objects.Cpf;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@DiscriminatorValue("physical")
public class PhysicalPerson extends Person {

    @NotNull
    @Column(length = 100)
    private String name;

    @NotNull
    private Cpf cpf;

    public PhysicalPerson(String name, String cpf, String email, List<Address> addresses) {
        super(email, addresses);
        this.name = name;
        this.cpf = new Cpf(cpf);
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf.getCpf();
    }
}
