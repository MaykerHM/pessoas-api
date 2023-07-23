package com.mga.pessoas.domain.person.exception;

public class PersonAlreadyExistsWithDocumentException extends Throwable {
    public PersonAlreadyExistsWithDocumentException(String document) {
        super("Person already exists with document: " + document);
    }
}
