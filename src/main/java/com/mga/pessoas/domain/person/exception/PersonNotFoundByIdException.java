package com.mga.pessoas.domain.person.exception;

public class PersonNotFoundByIdException extends IllegalArgumentException {
    public PersonNotFoundByIdException(Long id) {
        super("Person not found with id: " + id);
    }
}
