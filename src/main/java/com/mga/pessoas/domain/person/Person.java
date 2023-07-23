package com.mga.pessoas.domain.person;

import com.mga.pessoas.domain.value_objects.Address;
import com.mga.pessoas.domain.value_objects.Email;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity(name="person")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "person_type")
public abstract class Person {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(length = 100)
    private Email email;

    @OneToMany(mappedBy="person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Address> addresses;

    public Person(String email, List<Address> addresses) {
        this.email = new Email(email);
        this.addresses = addresses;
    }

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email.getEmail();
    }

    public List<Address> getAddresses() {
        return addresses;
    }
}
