package com.mga.pessoas.domain.person;

import com.mga.pessoas.domain.value_objects.Cnpj;
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
    private Cnpj cnpj;

    public JuridicalPerson(String companyName, Cnpj cnpj) {
        this.companyName = companyName;
        this.cnpj = cnpj;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCnpj() {
        return cnpj.getCnpj();
    }
}
