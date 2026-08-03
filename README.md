# Spring Ecosystem Practice Repository

A portfolio of independent Java and Spring projects covering core container concepts, web development, persistence, caching, and service-to-service communication.

## Projects

| Focus | Projects |
| --- | --- |
| Spring fundamentals | `spring-ecosystem` — bean configuration, relationships, scopes, and AOP examples |
| MVC and views | `SpringWebScope`, `Mini-Task-Tracker-project` — web scopes, Thymeleaf, and task management |
| Relational persistence | `JDBC`, `Book-Purchase-JDBC`, `Hibernate`, `Spring-Data-JPA`, `Spring-Data-Transaction`, `Spring-Data-Flyway` |
| REST API design | `MapStruct-mapping`, `Online-Store-Inventory-API`, `Bicycle-Repair-Tracker` |
| Redis | `Connecting-Redis-to-Spring`, `Redis-Repository`, `spring-redis-lab` |
| HTTP clients | `Using-OpenFeign`, `Payment-Client-Service` |

## Technology

Java 21 · Spring Boot 4.1 · Spring Framework 7 · Maven · Spring MVC · Thymeleaf · Spring Data JPA · JDBC · Hibernate · MySQL · H2 · Redis · Flyway · MapStruct · Lombok · OpenFeign · Actuator

## Run a project

Each directory is a standalone project. For example:

```bash
cd Spring-Data-JPA
./mvnw spring-boot:run
```

Run its tests with:

```bash
./mvnw test
```

## Prerequisites

JPA and Flyway projects use MySQL; Redis examples require a reachable Redis server. Review the relevant `application.properties` or `application.yaml` before starting a project.

---

Maintained by [Mahmudkhon Usmanov](https://github.com/UsmanovMahmudkhan).
