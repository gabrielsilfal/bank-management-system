# 🏦 Bank API

A RESTful banking backend built with **Java and Spring Boot**, designed to simulate basic banking operations such as client management and financial transactions.

The project uses **Spring Data JPA**, **Hibernate**, and **PostgreSQL** for data persistence and **Docker** for containerization and development environment setup.

## 📌 About

Bank API is a backend project currently under development.

The main goal is to build a structured REST API for managing clients and transactions while exploring backend development concepts and features provided by the Spring ecosystem.

The application currently supports:

* Client creation, retrieval, updating, and deletion
* Financial transaction creation and retrieval
* Transaction deletion
* Client balance management
* PostgreSQL persistence
* Dockerized application and database
* Layered backend architecture

## 🚀 Technologies

* **Java 26**
* **Spring Boot**
* **Spring Data JPA**
* **Hibernate**
* **PostgreSQL**
* **Lombok**
* **Gradle**
* **Docker**
* **Docker Compose**

## 🏗️ Architecture

The application follows a layered architecture:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
```

### Controller

Responsible for handling HTTP requests and returning API responses.

### Service

Contains the application's business logic and rules.

### Repository

Responsible for communication with the database using Spring Data JPA.

### Database

PostgreSQL is used for persistent data storage.

## 🔌 API Endpoints

### Clients

| Method   | Endpoint        | Description         |
| -------- |-----------------|---------------------|
| `POST`   | `/clients`      | Create a client     |
| `GET`    | `/clients`      | List all clients    |
| `GET`    | `/clients/{id}` | List a client by ID |
| `PUT`    | `/clients/{id}` | Update a client     |
| `DELETE` | `/clients/{id}` | Delete a client     |

### Transactions

| Method   | Endpoint                     | Description             |
| -------- |------------------------------|-------------------------|
| `POST`   | `/clients/transactions`      | Create a transaction    |
| `GET`    | `/clients/transactions`      | List all transactions   |
| `GET`    | `/clients/transactions/{id}` | Find a transaction by ID |
| `DELETE` | `/clients/transactions/{id}`  | Delete a transaction    |

## 📦 Example Request

### Create a Client

```http
POST /clients
Content-Type: application/json
```

Example:

```json
{
  "name": "John Doe"
}
```

### Create a Transaction

```http
POST /clients/transactions/{id}
Content-Type: application/json
```

Example:

```json
{
  "value": 100.00,
  "type": "DEPOSIT"
}
```

## 🐳 Running with Docker

The application and PostgreSQL database can be started using Docker Compose.

### Prerequisites

Make sure you have installed:

* Docker
* Docker Compose
* Git

### 1. Clone the repository

```bash
git clone <your-repository-url>
cd bank-management-system
```

### 2. Create the environment file

Create a `.env` file in the project root:

```env
POSTGRES_DB=bank
POSTGRES_USER=postgres
POSTGRES_PASSWORD=your_password
```

### 3. Build and start the application

First, generate the application JAR:

```bash
./gradlew clean bootJar
```

Then start the containers:

```bash
docker compose up --build
```

The API will be available at:

```text
http://localhost:8081
```

PostgreSQL will run inside its own Docker container.

### 4. Stop the application

To stop the containers:

```bash
docker compose down
```

To stop the containers and remove the database volume:

```bash
docker compose down -v
```

> **Warning:** `docker compose down -v` removes the PostgreSQL volume and therefore deletes the database data stored in that volume.

## 🔐 Environment Variables

The application uses environment variables for database configuration.

| Variable            | Description                    |
| ------------------- | ------------------------------ |
| `DB_URL`            | PostgreSQL JDBC connection URL |
| `DB_USERNAME`       | PostgreSQL username            |
| `DB_PASSWORD`       | PostgreSQL password            |
| `POSTGRES_DB`       | PostgreSQL database name       |
| `POSTGRES_USER`     | PostgreSQL username            |
| `POSTGRES_PASSWORD` | PostgreSQL password            |

Sensitive environment files such as `.env` are excluded from version control.

## 📁 Project Structure

```text
src/
├── main/
│   ├── java/
│   │   └── ...
│   └── resources/
│       └── application.properties
│
├── test/
│   └── ...
│
├── Dockerfile
├── docker-compose.yml
├── build.gradle
├── gradlew
├── gradlew.bat
└── README.md
```

## 🧪 Testing the API

After starting the application, you can test the API using tools such as:

* Postman
* Insomnia
* cURL

For example:

```bash
curl http://localhost:8081/clients
```

## 🎯 Project Goals

This project is being developed as a practical way to improve my knowledge of:

* Java backend development
* Spring Boot
* REST API design
* JPA and Hibernate
* PostgreSQL
* Docker and containerization
* Software architecture
* Database relationships
* Business logic implementation

## 👨‍💻 Author

Developed as a personal backend development project while learning and practicing **Java and Spring Boot**.
