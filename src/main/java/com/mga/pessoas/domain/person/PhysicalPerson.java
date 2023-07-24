package com.mga.pessoas.domain.person;

import com.mga.pessoas.domain.person.dto.PersonDTO;
import com.mga.pessoas.domain.person.dto.PersonUpdateDTO;
import com.mga.pessoas.domain.value_objects.Address;
import com.mga.pessoas.domain.value_objects.Cpf;
import com.mga.pessoas.domain.value_objects.Email;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Objects;

@Entity
@DiscriminatorValue("physical")
public class PhysicalPerson extends Person {

    @NotNull
    @Column(name = "name",length = 100)
    private String name;

    @NotNull
    @Column(name = "document")
    private Cpf cpf;

    public PhysicalPerson(String name, String cpf, String email, List<Address> addresses) {
        super(email, addresses);
        this.name = name;
        this.cpf = new Cpf(cpf);
    }

    public PhysicalPerson(PersonDTO personDTO) {
        List<Address> addresses = personDTO.getAddresses().stream().map(addressDTO -> Address.of(addressDTO, this)).toList();
        this.name = personDTO.getName();
        this.cpf = new Cpf(personDTO.getDocument());
        super.email = new Email(personDTO.getEmail());
        super.addresses = addresses;
    }

    public PhysicalPerson() {
        super();
    }

    public static PhysicalPerson update(PhysicalPerson person, PersonUpdateDTO personDTO) {
        if (Objects.nonNull(personDTO.getName())) {
            person.name = personDTO.getName();
        }
        if (Objects.nonNull(personDTO.getDocument())) {
            person.cpf = new Cpf(personDTO.getDocument());
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

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf.getCpf();
    }
}
