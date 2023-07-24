--liquibase formatted sql

--changeset pessoas:create-person-seq:1
SELECT setval(pg_get_serial_sequence('person', 'id'), coalesce(max(id), 0)+1 , false) FROM person;
