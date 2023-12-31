package com.mga.pessoas.domain.person.repository;

import com.mga.pessoas.domain.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {
    Optional<Person> findById(Long id);

    @Query(value = "SELECT * FROM person p WHERE p.document = ?1", nativeQuery = true)
    Person findByDocument(String document);
}