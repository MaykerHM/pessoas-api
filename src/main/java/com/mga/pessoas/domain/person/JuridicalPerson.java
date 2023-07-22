package com.mga.pessoas.domain.person;

import com.mga.pessoas.domain.value_objects.Address;
import com.mga.pessoas.domain.value_objects.Cnpj;
import com.mga.pessoas.domain.value_objects.converters.CnpjAttributeConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@DiscriminatorValue("juridical")
public class JuridicalPerson extends Person {

    @NotNull
    @Column(name = "name",length = 100)
    private String companyName;

    @NotNull
    @Column(name = "document")
    @Convert(converter = CnpjAttributeConverter.class)
    private Cnpj cnpj;

    public JuridicalPerson(String companyName, String cnpj, String email, List<Address> addresses) {
        super(email, addresses);
        this.companyName = companyName;
        this.cnpj = new Cnpj(cnpj);
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCnpj() {
        return cnpj.getCnpj();
    }
}
