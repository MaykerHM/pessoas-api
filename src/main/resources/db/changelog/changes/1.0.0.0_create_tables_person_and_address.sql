--liquibase formatted sql

--changeset pessoas:create-tables:1
CREATE TABLE IF NOT EXISTS person (
    id bigint NOT NULL,
    email varchar(100) NOT NULL,
    name varchar(100) NOT NULL,
    document varchar(14) NOT NULL,
    person_type varchar(20) NOT NULL,
    CONSTRAINT pk_person PRIMARY KEY(id)
);

--changeset pessoas:create-tables:2
CREATE TABLE IF NOT EXISTS address (
    id uuid NOT NULL,
    street varchar(50) NOT NULL,
    number varchar(10) NOT NULL,
    complement varchar(100),
    city varchar(50) NOT NULL,
    state varchar(2) NOT NULL,
    postal_code varchar(8) NOT NULL,
    person_id bigint NOT NULL,
    CONSTRAINT pk_address PRIMARY KEY(id),
    CONSTRAINT fk_person
        FOREIGN KEY(person_id)
            REFERENCES person(id)
);
