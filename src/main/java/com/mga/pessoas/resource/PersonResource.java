package com.mga.pessoas.resource;

import com.mga.pessoas.domain.person.dto.PersonDTO;
import com.mga.pessoas.domain.person.dto.PersonUpdateDTO;
import com.mga.pessoas.domain.person.exception.PersonAlreadyExistsWithDocumentException;
import com.mga.pessoas.domain.person.exception.PersonNotFoundByIdException;
import com.mga.pessoas.domain.person.service.PersonService;
import com.mga.pessoas.domain.value_objects.exception.InvalidCnpjException;
import com.mga.pessoas.domain.value_objects.exception.InvalidCpfException;
import com.mga.pessoas.domain.value_objects.exception.InvalidEmailException;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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

    @GetMapping
    @Operation(summary = "Busca paginada de todas as pessoas físicas e jurídicas")
    public ResponseEntity<Object> getAllPersons(
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personService.findAll(pageable));
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err.getMessage());
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca pessoas física ou jurídica pelo id")
    public ResponseEntity<Object> getById(@PathVariable(value = "id") Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personService.findById(id));
        } catch (PersonNotFoundByIdException err) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err.getMessage());
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err.getMessage());
        }
    }

    @PostMapping
    @Operation(summary = "Cria uma pessoa física ou jurídica")
    public ResponseEntity<Object> createPerson(@RequestBody @Valid PersonDTO personDTO) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(personService.create(personDTO));
        } catch (IllegalArgumentException err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getMessage());
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err.getMessage());
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uma pessoa física ou jurídica")
    public ResponseEntity<Object> updatePerson(@PathVariable(value = "id") Long id, @RequestBody @Valid PersonUpdateDTO personUpdateDTO) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personService.update(personUpdateDTO, id));
        } catch (IllegalArgumentException err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getMessage());
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Exclui um registro de pessoa física ou jurídica")
    public ResponseEntity<Object> deletePerson(@PathVariable(value = "id") Long id) {
        try {
            personService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Person deleted successfully!");
        } catch (PersonNotFoundByIdException err) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err.getMessage());
        } catch (Exception err) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err.getMessage());
        }
    }

}

