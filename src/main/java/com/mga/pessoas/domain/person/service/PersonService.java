package com.mga.pessoas.domain.person.service;

import com.mga.pessoas.domain.person.JuridicalPerson;
import com.mga.pessoas.domain.person.Person;
import com.mga.pessoas.domain.person.PhysicalPerson;
import com.mga.pessoas.domain.person.dto.PersonDTO;
import com.mga.pessoas.domain.person.dto.PersonUpdateDTO;
import com.mga.pessoas.domain.person.exception.PersonAlreadyExistsWithDocumentException;
import com.mga.pessoas.domain.person.exception.PersonNotFoundByIdException;
import com.mga.pessoas.domain.person.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class PersonService {
    final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Page<Person> findAll(Pageable pageable) {
        return personRepository.findAll(pageable);
    }

    public Person findById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundByIdException(id));
    }

    @Transactional
    public Person create(PersonDTO personDto) throws PersonAlreadyExistsWithDocumentException {
        Person foundPersonByDocument = personRepository.findByDocument(personDto.getDocument());
        if (foundPersonByDocument != null) {
            throw new PersonAlreadyExistsWithDocumentException(personDto.getDocument());
        }
        Person person = null;

        if(Objects.equals(personDto.getPersonType(), "physical")) {
            person = new PhysicalPerson(personDto);
        }
        if(Objects.equals(personDto.getPersonType(), "juridical")) {
            person = new JuridicalPerson(personDto);
        }
        return personRepository.save(person);
    }

    @Transactional
    public Person update(PersonUpdateDTO personDto, Long id) {
        Person updatedPerson = this.findById(id);
        if(Objects.equals(personDto.getPersonType(), "physical")) {
            PhysicalPerson.update((PhysicalPerson) updatedPerson, personDto);
        }
        if(Objects.equals(personDto.getPersonType(), "juridical")) {
            JuridicalPerson.update((JuridicalPerson) updatedPerson, personDto);
        }

        return personRepository.save(updatedPerson);
    }

    @Transactional
    public void delete(Long id) {
        Person person = this.findById(id);
        personRepository.delete(person);
    }

}
