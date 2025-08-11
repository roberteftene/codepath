# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Spring Boot 3.5.4 REST API application called "codepath-api" - a Duolingo-inspired app for programming language fundamentals and interview preparation. The project uses Java 21, Maven for build management, and follows standard Spring Boot conventions.

## Architecture

- **Framework**: Spring Boot 3.5.4 with Spring Web, Spring Data JPA, and Spring Security
- **Database**: H2 (in-memory) for development, PostgreSQL support configured via Flyway migrations
- **Package Structure**: `com.roberteftene.codepath.codepath_api`
- **Security**: Spring Security integration (configuration pending)
- **Database Migrations**: Flyway for schema versioning (migration files in `src/main/resources/db/migration/`)

## Common Development Commands

### Build and Run
```bash
# Clean and compile
./mvnw clean compile

# Run the application
./mvnw spring-boot:run

# Build package
./mvnw clean package

# Run tests
./mvnw test

# Run specific test class
./mvnw test -Dtest=CodepathApiApplicationTests
```

### Development Database
- H2 Console available at: http://localhost:8080/h2-console
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: `password`

## Key Configuration

- **Main Application**: `CodepathApiApplication.java` (standard Spring Boot entry point)
- **Properties**: `application.properties` configured for H2 development database
- **Dependencies**: JPA, Security, Web, Flyway, Lombok, DevTools
- **Java Version**: 21
- **Lombok**: Enabled with annotation processing configured

## Development Notes

- The project uses Maven wrapper (`mvnw`), so always use `./mvnw` instead of `mvn`
- Lombok is configured for reducing boilerplate code
- Spring Boot DevTools enabled for hot reloading during development
- JPA is set to `create-drop` mode for H2, showing SQL queries in logs
- Controller package exists but is currently empty - controllers should be added here
- Migration directory exists but no migrations present yet