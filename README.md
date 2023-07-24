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

Example URI:
```
http://localhost:8080/api/v1/persons
```

---

#### GET /persons/{id}

Example URI:
```
http://localhost:8080/api/v1/persons/1
```

---

#### POST /persons

Example URI:
```
http://localhost:8080/api/v1/persons
```
Example request body:
```json
{
    "name": "Paulo",
    "document": "39678653044",
    "birthdate": "2003-04-18",
    "contacts": [
        {
            "name": "Mae",
            "phoneNumber": "99999955656",
            "email": "mae@email.com"
        }
    ]
}
```

---

#### PUT /persons/{id}
Example URI:
```
http://localhost:8080/api/v1/persons/1
```
Example request body:
```json
{
    "id": "808d9973-747b-40c3-ab62-4e8c9297da9c",
    "name": "Paulo",
    "document": "234.120.030-34",
    "birthdate": "2000-10-23"
}
```

---

#### DELETE /persons/{id}

Example URI:
```
http://localhost:8080/api/v1/persons/1
```

---
