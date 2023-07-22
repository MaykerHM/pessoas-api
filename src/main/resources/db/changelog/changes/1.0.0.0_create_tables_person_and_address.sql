--liquibase formatted sql

--changeset pessoas:create-tables:1
CREATE TABLE IF NOT EXISTS person (
    id uuid NOT NULL,
    email varchar(100) NOT NULL,
    name varchar(100) NOT NULL,
    document varchar(14) NOT NULL,
    personType varchar(20) NOT NULL,
    CONSTRAINT pk_person PRIMARY KEY(id)
);

--changeset pessoas:create-tables:2
CREATE TABLE IF NOT EXISTS address (
    id uuid NOT NULL,
    street varchar(50) NOT NULL,
    number bigint NOT NULL,
    complement varchar(100),
    city varchar(50) NOT NULL,
    state varchar(2) NOT NULL,
    postalCode varchar(8) NOT NULL,
    person_id uuid NOT NULL,
    CONSTRAINT pk_address PRIMARY KEY(id),
    CONSTRAINT fk_person
        FOREIGN KEY(person_id)
            REFERENCES person(id)
);
