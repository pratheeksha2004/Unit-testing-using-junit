# Spring Boot JUnit Demo

A simple Spring Boot project demonstrating JUnit 5 testing of a data access layer using Spring Data JPA and PostgreSQL.

## Table of Contents

*   [Description](#description)
*   [Technologies Used](#technologies-used)
*   [Prerequisites](#prerequisites)
*   [Setup and Installation](#setup-and-installation)
*   [Running the Application](#running-the-application)
*   [Running the JUnit Tests](#running-the-junit-tests)
*   [Project Structure](#project-structure)
*   [Configuration](#configuration)
*   [Key Concepts Demonstrated](#key-concepts-demonstrated)
*   [License](#license) <!-- Add if you have a license file -->

## Description

This project provides a basic example of how to write JUnit 5 tests for a Spring Data JPA repository. It demonstrates how to test the data access layer of a Spring Boot application that uses PostgreSQL as the database.

The project includes:

*   An `Item` entity representing a database table.
*   An `ItemRepository` interface for performing CRUD operations on `Item` entities.
*   A `JUnit` test class (`ItemRepositoryTest`) that tests the `ItemRepository` methods.
*   Configured test slice and beans for database use.

## Technologies Used

*   Java 17 (or your Java version)
*   Spring Boot 3.1.5 (or your Spring Boot version)
*   Spring Data JPA
*   PostgreSQL
*   JUnit 5
*   Maven or Gradle (Specify which one you're using)

## Prerequisites

*   Java Development Kit (JDK) 17 or higher
*   Maven or Gradle (depending on your build system)
*   A running PostgreSQL database instance

## Setup and Installation

1.  **Clone the repository:**

    ```bash
    git clone https://github.com/pratheeksha2004/Unit-testing-using-junit.git
    ```

2.  **Navigate to the project directory:**

    ```bash
    cd Unit-testing-using-junit
    ```

3.  **Configure the database connection:**

    *   Update the `src/main/resources/application.properties` file with the connection details for your PostgreSQL database:

        ```properties
        spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
        spring.datasource.username=your_username
        spring.datasource.password=your_password
        spring.jpa.hibernate.ddl-auto=update  # Use with CAUTION in production!
        spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
        ```

        *   Replace `your_database_name`, `your_username`, and `your_password` with your actual database credentials.

4.  **Build the project:**

    *   **Maven:**

        ```bash
        mvn clean install
        ```

    *   **Gradle:**

        ```bash
        gradle clean build
        ```

## Running the Application

To run the Spring Boot application:

*   **Maven:**

    ```bash
    mvn spring-boot:run
    ```

*   **Gradle:**

    ```bash
    gradle bootRun
    ```

## Running the JUnit Tests

To run the JUnit tests:

*   **Maven:**

    ```bash
    mvn test
    ```

*   **Gradle:**

    ```bash
    gradle test
    ```


## Configuration

The project uses the following configuration properties:

*   `spring.datasource.url`: The JDBC URL for the PostgreSQL database.
*   `spring.datasource.username`: The username for the PostgreSQL database.
*   `spring.datasource.password`: The password for the PostgreSQL database.
*   `spring.jpa.hibernate.ddl-auto`: The Hibernate DDL auto strategy.  (Use `validate` or a migration tool in production).

## Key Concepts Demonstrated

*   JUnit 5 testing with Spring Boot
*   Spring Data JPA repositories
*   Testing the data access layer
*   Dependency injection
*   PostgreSQL integration
