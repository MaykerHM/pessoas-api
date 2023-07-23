package com.mga.pessoas.domain.person.service;

import com.mga.pessoas.domain.person.Person;
import com.mga.pessoas.domain.person.exception.PersonNotFoundByIdException;
import com.mga.pessoas.domain.person.repository.PersonRepository;
import org.springframework.stereotype.Service;


@Service
public class PersonService {
    final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person findById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundByIdException(id));
    }
}
