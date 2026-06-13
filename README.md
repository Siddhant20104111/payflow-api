# PayFlow API

## Overview

PayFlow is a REST API built using Spring Boot, Spring Data JPA, and H2 Database. It simulates a simplified digital payment system where users can register, maintain wallet balances, and record money transfers between users.

The application exposes REST endpoints that can be consumed by any frontend application or tested directly using HTTP requests.

---

## Tech Stack

* Java
* Spring Boot
* Spring Web
* Spring Data JPA
* H2 Database
* Maven

---

## Project Structure

```text
com.payflow
│
├── controller
│   ├── UserController
│   └── TransactionController
│
├── service
│   ├── UserService
│   └── TransactionService
│
├── repository
│   ├── UserRepository
│   └── TransactionRepository
│
├── entity
│   ├── User
│   └── Transaction
│
└── PayflowApiApplication
```

---

## Layer Responsibilities

### Controller Layer

Handles HTTP requests and responses.

Examples:

* POST /users
* GET /users
* POST /transactions

---

### Service Layer

Contains business logic.

Examples:

* Register user
* Retrieve users
* Record transactions

---

### Repository Layer

Communicates with the database using Spring Data JPA.

Examples:

* save()
* findAll()
* findById()
* findByUpiId()

---

### Entity Layer

Represents database tables.

Examples:

* User
* Transaction

---

## Spring Boot Features Used

### 1. Embedded Server

Spring Boot automatically starts an embedded Tomcat server.

Example:

```text
Tomcat started on port 8080
```

No external application server installation is required.

---

### 2. Auto Configuration

Spring Boot automatically configures:

* H2 Database
* JPA
* Hibernate
* Dispatcher Servlet

based on dependencies present in pom.xml.

---

### 3. Production Ready Defaults

Spring Boot provides sensible defaults such as:

* Component scanning
* Error handling
* Logging
* Dependency management

without requiring manual configuration.

---

## Running the Application

Clone the repository:

```bash
git clone https://github.com/Siddhant20104111/payflow-api.git
```

Move into project:

```bash
cd payflow-api
```

Run:

```bash
mvn spring-boot:run
```

Application starts on:

```text
http://localhost:8080
```

---

## H2 Database Console

Open:

```text
http://localhost:8080/h2-console
```

Connection Details:

```text
JDBC URL: jdbc:h2:mem:payflowdb
Username: sa
Password:
```

---

## REST Endpoints

### Create User

POST /users

### Get All Users

GET /users

### Get User By ID

GET /users/{id}

### Find User By UPI

GET /users/upi/{upiId}

### Send Money

POST /transactions

---

## JPA Derived Query

Repository Method:

```java
User findByUpiId(String upiId);
```

Generated SQL:

```sql
select u1_0.id,u1_0.balance,u1_0.name,u1_0.phone_number,u1_0.upi_id from users u1_0 where u1_0.upi_id=?
```

Explanation:

* Spring Data JPA derives the query from the method name.
* "findBy" indicates retrieval.
* "UpiId" maps to the upiId field.
* ? is a parameter placeholder that is replaced by the method argument at runtime.

---

## JPQL Query Example

```java
@Query("SELECT u FROM User u WHERE u.balance > :amount")
List<User> findUsersWithBalanceGreaterThan(@Param("amount") Double amount);
```

---

## Query Approaches Comparison

### Derived Query Methods

Example:

```java
findByUpiId()
```

Advantages:

* Easy to write
* Type-safe
* No SQL required

---

### JPQL (@Query)

Advantages:

* More flexible
* Entity-oriented
* Database independent

---

### Native SQL

Advantages:

* Full SQL control

Disadvantages:

* Database specific
* Harder to maintain
* Less portable

Therefore native SQL is generally the least preferred approach.
