A simple Spring Boot REST API for managing students. This project demonstrates clean architecture, DTO usage, Mapper pattern, JPA, and global exception handling — built with interview best practices in mind.

Features
-Create, Read, Update, Delete (CRUD) Students
-Request & Response DTOs
-Mapper layer (Entity ↔ DTO)
-Spring Data JPA
-Validation using Jakarta Validation
-Global Exception Handling
-Proper HTTP Status Codes

Tech Stack
-Java 17+
-Spring Boot
-Spring Data JPA
-Hibernate
-H2 / MySQL (configurable)
-Maven

Project Structure
controller → Handles HTTP requests
service → Business logic
repository → Database access (JPA)
dto → Request & Response DTOs
mapper → Entity ↔ DTO conversion
entity → JPA entities
exception → Custom & global exceptions

How To Run It
mvn spring-boot:run

Api available
http://localhost:8080



