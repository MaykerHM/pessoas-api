# pessoas-api

____

### Getting Started

Copie o projeto para o seu ambiente local:
```
git clone https://github.com/MaykerHM/pessoas-api.git
```

E inicie os contêineres:
```
docker-compose up
```
A aplicação ficará disponível no localhost na porta "8080":
```
http://localhost:8080/api/v1
```

Poderá se conectar ao banco de dados Postgres:
```
url: jdbc:postgresql://localhost:5432/postgres
username: postgres
senha: postgres
```
____
### Tecnologias

Postgres

Maven 3.8.5

Java jdk-17

Spring boot 3.1.0

Liquibase

OpenAPI 3 Swagger

Docker

____

### Documentação

Open API Swagger: http://localhost:8080/api/swagger-ui/index.html

Open API 3 api-docs: http://localhost:8080/api/api-docs
____

### Endpoints:

#### GET /persons?page=1

Exemplo URI:
```
http://localhost:8080/api/v1/persons
```

---

#### GET /persons/{id}

Exemplo URI:
```
http://localhost:8080/api/v1/persons/1
```

---

#### POST /persons

Exemplo URI:
```
http://localhost:8080/api/v1/persons
```
Exemplo request body:
```json
{
  "name": "Paulo",
  "document": "39678653044",
  "email": "paulo@email.com",
  "personType": "physical",
  "addresses": [
    {
      "street": "Rua Rui Barbosa",
      "number": "754",
      "complement": "Casa",
      "city": "Maringá",
      "state": "PR",
      "postalCode": "87020090"
    }
  ]
}
```
* pensonType deverá possuir o valor "physical" ou "juridical"
* document deverá ser CPF ou CNPJ válido
* email deverá ser válido
---

#### PUT /persons/{id}
Exemplo URI:
```
http://localhost:8080/api/v1/persons/1
```
Exemplo request body:
```json
{
  "name": "Paulo",
  "document": "39678653044",
  "email": "paulo@email.com",
  "personType": "physical",
  "addresses": [
    {
      "street": "Rua Rui Barbosa",
      "number": "754",
      "complement": "Casa",
      "city": "Maringá",
      "state": "PR",
      "postalCode": "87020090"
    }
  ]
}
```

---

#### DELETE /persons/{id}

Exemplo URI:
```
http://localhost:8080/api/v1/persons/1
```

---
