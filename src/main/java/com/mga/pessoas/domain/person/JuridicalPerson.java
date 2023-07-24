package com.mga.pessoas.domain.person;

import com.mga.pessoas.domain.person.dto.PersonDTO;
import com.mga.pessoas.domain.person.dto.PersonUpdateDTO;
import com.mga.pessoas.domain.value_objects.Address;
import com.mga.pessoas.domain.value_objects.Cnpj;
import com.mga.pessoas.domain.value_objects.Cpf;
import com.mga.pessoas.domain.value_objects.Email;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Objects;

@Entity
@DiscriminatorValue("juridical")
public class JuridicalPerson extends Person {

    @NotNull
    @Column(name = "name",length = 100)
    private String companyName;

    @NotNull
    @Column(name = "document")
    private Cnpj cnpj;

    public JuridicalPerson(String companyName, String cnpj, String email, List<Address> addresses) {
        super(email, addresses);
        this.companyName = companyName;
        this.cnpj = new Cnpj(cnpj);
    }

    public JuridicalPerson(PersonDTO personDTO) {
        List<Address> addresses = personDTO.getAddresses().stream().map(addressDTO -> Address.of(addressDTO, this)).toList();
        this.companyName = personDTO.getName();
        this.cnpj = new Cnpj(personDTO.getDocument());
        super.email = new Email(personDTO.getEmail());
        super.addresses = addresses;
    }

    public JuridicalPerson() {
    }

    public static JuridicalPerson update(JuridicalPerson person, PersonUpdateDTO personDTO) {
        if (Objects.nonNull(personDTO.getName())) {
            person.companyName = personDTO.getName();
        }
        if (Objects.nonNull(personDTO.getDocument())) {
            person.cnpj = new Cnpj(personDTO.getDocument());
        }
        if (Objects.nonNull(personDTO.getEmail())) {
            person.email = new Email(personDTO.getEmail());
        }
        if (Objects.nonNull(personDTO.getAddresses())) {
            List<Address> addresses = personDTO.getAddresses().stream().map(addressDTO -> Address.of(addressDTO, person)).toList();
            person.addresses.clear();
            person.addresses = addresses;
        }

        return person;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCnpj() {
        return cnpj.getCnpj();
    }
}
