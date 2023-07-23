package com.mga.pessoas.resource;

import com.mga.pessoas.domain.person.exception.PersonNotFoundByIdException;
import com.mga.pessoas.domain.person.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/persons")
public class PersonResource {
    final PersonService personService;

    public PersonResource(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personService.findById(id));
        } catch (PersonNotFoundByIdException err) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err.getMessage());
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err.getMessage());
        }
    }

}

