# Bank API

A RESTful banking application I'm building with **Java and Spring Boot**, using **Spring Data JPA** and **PostgreeSQL** for data persistence.

## About

This project is a backend application currently in development to simulate basic banking operations and explore different **Spring Boot features**.
The main goal is to build a REST API for managing clients and transactions.

## Technologies
- Java
- SpringBoot
- Spring Data JPA
- Hibernate
- PostGreeSQL
- Lombok

## Architeture
```
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
```

## API Endpoints
| Method | Endpoint | Description |
|--------|----------|-----------|
| POST   | /clients | Create a Client |
| GET    | /clients | List Clients |
| PUT    | /clients/{id} | Update a Client |
| DELETE | /clients/{id} | Delete a Client |
|--------|----------|-----------|
| POST   | /clients/transactions | Create a Transaction |
| GET    | /clients/transactions | List Transactions |
| DELETE | /clients/transactions/{clientId} | Delete a Transaction |
