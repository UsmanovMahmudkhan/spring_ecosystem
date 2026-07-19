# Spring Boot, Data & Security Practice Lab

> A hands-on Java backend learning repository for Spring Boot, Spring Data, and Spring Security.

I use this repository to practice Spring through focused experiments, coding exercises, proof-of-concept implementations, and short projects. The goal is to understand each feature in isolation, combine related features in realistic applications, and keep a visible record of what I learn.

This is a learning workspace rather than one production application. Each example should stay small enough to explain, run, test, and improve independently.

## Contents

- [Purpose](#purpose)
- [Spring Boot](#spring-boot)
- [Spring Data](#spring-data)
- [Spring Security](#spring-security)
- [Practice formats](#practice-formats)
- [Suggested repository organization](#suggested-repository-organization)
- [Running an example](#running-an-example)
- [Learning principles](#learning-principles)
- [Official references](#official-references)

## Purpose

This repository is where I:

- practice Spring concepts with small, focused examples;
- experiment with configuration, integrations, and alternative implementations;
- solve exercises that reinforce individual framework features;
- build short projects that combine web, persistence, and security concerns;
- write tests for successful, failure, and security-sensitive behavior;
- compare imperative and reactive approaches where both are available; and
- document lessons, trade-offs, limitations, and follow-up ideas.

The inventories below are a **curriculum map**, not a claim that every technology is used in every application or already completed. Each example documents the dependencies and features it actually uses.

## Reference snapshot

The project, module, and starter names in this README were checked against the official Spring documentation on **July 19, 2026**.

| Spring portfolio | Current stable line shown by Spring | How it is organized |
| --- | --- | --- |
| Spring Boot | 4.1.0 | One top-level project with features, modules, auto-configuration, plugins, and starters |
| Spring Data | 2026.0.0 | An umbrella project containing store-specific subprojects |
| Spring Security | 7.1.0 | One framework with feature areas and separately published modules |

Versions in individual examples may differ when an exercise intentionally targets another supported line. The build file for each example is the source of truth for that example.

## Spring Boot

Spring Boot is the application foundation used throughout this repository. Its starters are convenient dependency descriptors—not separate Spring projects.

### Practice areas

- Application structure, configuration classes, auto-configuration, dependency injection, and `@SpringBootApplication`
- Externalized configuration, configuration properties, profiles, logging, SSL, JSON, AOP, scheduling, and development-time services
- Servlet applications with Spring MVC and reactive applications with WebFlux
- REST clients, HTTP service clients, validation, GraphQL, HATEOAS, WebSocket, RSocket, and web services
- SQL, NoSQL, database initialization, migrations, transactions, caching, and batch processing
- JMS, AMQP/RabbitMQ, Apache Kafka, Apache Pulsar, and Spring Integration
- Authentication, authorization, OAuth 2.0, OpenID Connect, SAML 2.0, and session support
- Unit tests, integration tests, test slices, test utilities, and Testcontainers
- Actuator endpoints, health, metrics, tracing, auditing, observability, and operational monitoring
- Executable archives, AOT processing, GraalVM native images, checkpoint/restore, Dockerfiles, buildpacks, and container images
- Maven and Gradle plugins, dependency management, deployment, Docker Compose, and the Spring Boot CLI

### Official Spring Boot starter inventory

The following names are the official starters currently documented under the `org.springframework.boot` group. They are grouped here for readability; consult the official starter table for exact dependency contents.

<details>
<summary><strong>Core, testing, and production readiness</strong></summary>

- `spring-boot-starter`
- `spring-boot-starter-classic`
- `spring-boot-starter-test`
- `spring-boot-starter-test-classic`
- `spring-boot-starter-actuator`
- `spring-boot-starter-actuator-test`
- `spring-boot-starter-web-server-test`

</details>

<details>
<summary><strong>Web, APIs, clients, and validation</strong></summary>

- `spring-boot-starter-webmvc`
- `spring-boot-starter-webmvc-test`
- `spring-boot-starter-webflux`
- `spring-boot-starter-webflux-test`
- `spring-boot-starter-restclient`
- `spring-boot-starter-restclient-test`
- `spring-boot-starter-webclient`
- `spring-boot-starter-webclient-test`
- `spring-boot-starter-websocket`
- `spring-boot-starter-websocket-test`
- `spring-boot-starter-webservices`
- `spring-boot-starter-webservices-test`
- `spring-boot-starter-graphql`
- `spring-boot-starter-graphql-test`
- `spring-boot-starter-hateoas`
- `spring-boot-starter-hateoas-test`
- `spring-boot-starter-jersey`
- `spring-boot-starter-jersey-test`
- `spring-boot-starter-rsocket`
- `spring-boot-starter-rsocket-test`
- `spring-boot-starter-validation`
- `spring-boot-starter-validation-test`

</details>

<details>
<summary><strong>Data access, databases, and migrations</strong></summary>

- `spring-boot-starter-jdbc`
- `spring-boot-starter-jdbc-test`
- `spring-boot-starter-data-jdbc`
- `spring-boot-starter-data-jdbc-test`
- `spring-boot-starter-data-jpa`
- `spring-boot-starter-data-jpa-test`
- `spring-boot-starter-jooq`
- `spring-boot-starter-jooq-test`
- `spring-boot-starter-r2dbc`
- `spring-boot-starter-r2dbc-test`
- `spring-boot-starter-data-r2dbc`
- `spring-boot-starter-data-r2dbc-test`
- `spring-boot-starter-mongodb`
- `spring-boot-starter-mongodb-test`
- `spring-boot-starter-data-mongodb`
- `spring-boot-starter-data-mongodb-test`
- `spring-boot-starter-data-mongodb-reactive`
- `spring-boot-starter-data-mongodb-reactive-test`
- `spring-boot-starter-data-redis`
- `spring-boot-starter-data-redis-test`
- `spring-boot-starter-data-redis-reactive`
- `spring-boot-starter-data-redis-reactive-test`
- `spring-boot-starter-cassandra`
- `spring-boot-starter-cassandra-test`
- `spring-boot-starter-data-cassandra`
- `spring-boot-starter-data-cassandra-test`
- `spring-boot-starter-data-cassandra-reactive`
- `spring-boot-starter-data-cassandra-reactive-test`
- `spring-boot-starter-couchbase`
- `spring-boot-starter-couchbase-test`
- `spring-boot-starter-data-couchbase`
- `spring-boot-starter-data-couchbase-test`
- `spring-boot-starter-data-couchbase-reactive`
- `spring-boot-starter-data-couchbase-reactive-test`
- `spring-boot-starter-elasticsearch`
- `spring-boot-starter-elasticsearch-test`
- `spring-boot-starter-data-elasticsearch`
- `spring-boot-starter-data-elasticsearch-test`
- `spring-boot-starter-neo4j`
- `spring-boot-starter-neo4j-test`
- `spring-boot-starter-data-neo4j`
- `spring-boot-starter-data-neo4j-test`
- `spring-boot-starter-ldap`
- `spring-boot-starter-ldap-test`
- `spring-boot-starter-data-ldap`
- `spring-boot-starter-data-ldap-test`
- `spring-boot-starter-data-rest`
- `spring-boot-starter-data-rest-test`
- `spring-boot-starter-flyway`
- `spring-boot-starter-flyway-test`
- `spring-boot-starter-liquibase`
- `spring-boot-starter-liquibase-test`
- `spring-boot-starter-hazelcast`
- `spring-boot-starter-hazelcast-test`

</details>

<details>
<summary><strong>Security and sessions</strong></summary>

- `spring-boot-starter-security`
- `spring-boot-starter-security-test`
- `spring-boot-starter-security-oauth2-client`
- `spring-boot-starter-security-oauth2-client-test`
- `spring-boot-starter-security-oauth2-resource-server`
- `spring-boot-starter-security-oauth2-resource-server-test`
- `spring-boot-starter-security-oauth2-authorization-server`
- `spring-boot-starter-security-oauth2-authorization-server-test`
- `spring-boot-starter-security-saml2`
- `spring-boot-starter-security-saml2-test`
- `spring-boot-starter-session-data-redis`
- `spring-boot-starter-session-data-redis-test`
- `spring-boot-starter-session-jdbc`
- `spring-boot-starter-session-jdbc-test`

</details>

<details>
<summary><strong>Messaging and integration</strong></summary>

- `spring-boot-starter-activemq`
- `spring-boot-starter-activemq-test`
- `spring-boot-starter-artemis`
- `spring-boot-starter-artemis-test`
- `spring-boot-starter-amqp`
- `spring-boot-starter-amqp-test`
- `spring-boot-starter-jms`
- `spring-boot-starter-jms-test`
- `spring-boot-starter-kafka`
- `spring-boot-starter-kafka-test`
- `spring-boot-starter-pulsar`
- `spring-boot-starter-pulsar-test`
- `spring-boot-starter-integration`
- `spring-boot-starter-integration-test`

</details>

<details>
<summary><strong>Batch, caching, scheduling, and AOP</strong></summary>

- `spring-boot-starter-batch`
- `spring-boot-starter-batch-test`
- `spring-boot-starter-batch-jdbc`
- `spring-boot-starter-batch-jdbc-test`
- `spring-boot-starter-batch-data-mongodb`
- `spring-boot-starter-batch-data-mongodb-test`
- `spring-boot-starter-cache`
- `spring-boot-starter-cache-test`
- `spring-boot-starter-quartz`
- `spring-boot-starter-quartz-test`
- `spring-boot-starter-aspectj`
- `spring-boot-starter-aspectj-test`

</details>

<details>
<summary><strong>Serialization, templates, and email</strong></summary>

- `spring-boot-starter-jackson`
- `spring-boot-starter-jackson-test`
- `spring-boot-starter-gson`
- `spring-boot-starter-gson-test`
- `spring-boot-starter-json`
- `spring-boot-starter-jsonb`
- `spring-boot-starter-jsonb-test`
- `spring-boot-starter-kotlinx-serialization-json`
- `spring-boot-starter-kotlinx-serialization-json-test`
- `spring-boot-starter-thymeleaf`
- `spring-boot-starter-thymeleaf-test`
- `spring-boot-starter-freemarker`
- `spring-boot-starter-freemarker-test`
- `spring-boot-starter-groovy-templates`
- `spring-boot-starter-groovy-templates-test`
- `spring-boot-starter-mustache`
- `spring-boot-starter-mustache-test`
- `spring-boot-starter-mail`
- `spring-boot-starter-mail-test`
- `spring-boot-starter-sendgrid`
- `spring-boot-starter-sendgrid-test`

</details>

<details>
<summary><strong>Servers, infrastructure, observability, and other integrations</strong></summary>

- `spring-boot-starter-tomcat`
- `spring-boot-starter-jetty`
- `spring-boot-starter-reactor-netty`
- `spring-boot-starter-cloudfoundry`
- `spring-boot-starter-cloudfoundry-test`
- `spring-boot-starter-grpc-client`
- `spring-boot-starter-grpc-client-test`
- `spring-boot-starter-grpc-server`
- `spring-boot-starter-grpc-server-test`
- `spring-boot-starter-micrometer-metrics`
- `spring-boot-starter-micrometer-metrics-test`
- `spring-boot-starter-opentelemetry`
- `spring-boot-starter-opentelemetry-test`
- `spring-boot-starter-zipkin`
- `spring-boot-starter-zipkin-test`

</details>

<details>
<summary><strong>Technical starters</strong></summary>

- `spring-boot-starter-jetty-runtime`
- `spring-boot-starter-tomcat-runtime`
- `spring-boot-starter-log4j2`
- `spring-boot-starter-logback`
- `spring-boot-starter-logging`
- `spring-boot-starter-restdocs`

</details>

<details>
<summary><strong>Deprecated compatibility names</strong></summary>

These names still appear in the current starter table but have preferred replacements. New exercises use the replacement shown.

| Deprecated starter | Preferred replacement |
| --- | --- |
| `spring-boot-starter-web` | `spring-boot-starter-webmvc` |
| `spring-boot-starter-web-services` | `spring-boot-starter-webservices` |
| `spring-boot-starter-oauth2-client` | `spring-boot-starter-security-oauth2-client` |
| `spring-boot-starter-oauth2-resource-server` | `spring-boot-starter-security-oauth2-resource-server` |
| `spring-boot-starter-oauth2-authorization-server` | `spring-boot-starter-security-oauth2-authorization-server` |

</details>

## Spring Data

Spring Data is an umbrella project. Its subprojects share repository and mapping concepts while preserving the capabilities of each underlying data store.

### Main modules

| Module | Practice focus |
| --- | --- |
| **Spring Data Commons** | Repository abstractions, query derivation, pagination, sorting, auditing, mapping foundations, and shared infrastructure |
| **Spring Data JDBC** | Aggregate-oriented relational persistence with JDBC and without a full ORM |
| **Spring Data R2DBC** | Reactive relational database access and non-blocking repositories |
| **Spring Data JPA** | JPA repositories, entity relationships, projections, specifications, locking, auditing, and transactions |
| **Spring Data KeyValue** | Map-based repositories and infrastructure for key-value store modules |
| **Spring Data LDAP** | Repository support for directory data through Spring LDAP |
| **Spring Data MongoDB** | Document mapping, repositories, aggregation, indexes, transactions, and reactive access |
| **Spring Data Redis** | Redis templates, repositories, serialization, caching, pub/sub, streams, and reactive access |
| **Spring Data REST** | Hypermedia-driven REST resources exported from Spring Data repositories |
| **Spring Data for Apache Cassandra** | Cassandra mapping, repositories, query operations, and reactive access |

### Community modules

Community modules extend the Spring Data programming model to additional stores. Their maintainers, release schedules, compatibility, and support policies may differ from the main modules.

- **Spring Data Aerospike**
- **Spring Data ArangoDB**
- **Spring Data Couchbase**
- **Spring Data Azure Cosmos DB**
- **Spring Data Cloud Datastore**
- **Spring Data Cloud Spanner**
- **Spring Data DynamoDB**
- **Spring Data Elasticsearch**
- **Spring Data Hazelcast**
- **Spring Data Neo4j**
- **Oracle NoSQL Database SDK for Spring Data**
- **Spring Data Reindexer**
- **Spring Data Vault**
- **Spring Data Valkey**

### Archived modules

These are listed separately by Spring and are not active curriculum targets unless an exercise explicitly studies a legacy system:

- **Spring Data for Apache Geode**
- **Spring Data for GemFire**

## Spring Security

Spring Security provides authentication, authorization, and protection against common attacks for imperative and reactive applications.

### Published framework modules

| Module | Practice focus |
| --- | --- |
| `spring-security-core` | Core authentication, authorization, access control, password handling, and method security |
| `spring-security-remoting` | Integration with Spring Remoting |
| `spring-security-web` | Servlet filters, web authentication, sessions, and URL-based authorization |
| `spring-security-config` | Java and namespace configuration infrastructure |
| `spring-security-ldap` | LDAP authentication and user provisioning |
| `spring-security-oauth2-core` | Shared OAuth 2.0 and OpenID Connect types and contracts |
| `spring-security-oauth2-client` | OAuth 2.0 Client and OpenID Connect Login |
| `spring-security-oauth2-jose` | JWT, JWS, JWE, and JWK support |
| `spring-security-oauth2-resource-server` | Bearer-token API protection using JWT or opaque tokens |
| `spring-security-acl` | Domain-object instance authorization with access-control lists |
| `spring-security-cas` | CAS single sign-on client integration |
| `spring-security-test` | Security test utilities and mock authentication support |
| `spring-security-taglibs` | JSP security tags |

### Security practice areas

- Authentication with form login, HTTP Basic, database-backed users, LDAP, passkeys, one-time tokens, and custom providers
- Authorization for HTTP requests, methods, messages, and domain objects
- Password encoding, session management, remember-me, logout, and concurrent-session control
- CSRF, CORS, security headers, request matching, firewalling, and protection against common exploits
- OAuth 2.0 Client, OAuth 2.0 Login, OpenID Connect, Resource Server, and Authorization Server
- JWT and opaque bearer tokens, JOSE operations, authorities, claims, and key management
- SAML 2.0 login and logout
- Servlet, WebFlux, WebSocket, and RSocket security
- Method security with annotations and authorization managers
- Unit, MVC, WebFlux, method-security, and integration testing

### Related Spring Security projects

| Project | Relationship to this repository |
| --- | --- |
| **Spring Authorization Server** | OAuth 2.1 and OpenID Connect 1.0 authorization-server support. The standalone 1.5.x generation is the last standalone line; new development moved into Spring Security 7.0. |
| **Spring LDAP** | LDAP access and integration used by LDAP-based authentication exercises |
| **Spring Security Kerberos** | Kerberos extension for Spring Security |
| **Spring Session** | External and clustered HTTP session management, including JDBC and Redis-backed sessions |
| **Spring Vault** | Access to HashiCorp Vault for secrets and security-sensitive configuration |

## Practice formats

Examples in this repository may take one of four forms:

| Format | Purpose |
| --- | --- |
| **Experiment** | Test one API, configuration option, lifecycle behavior, or integration |
| **Exercise** | Solve a focused problem with acceptance criteria and tests |
| **Mini-project** | Combine several related features in a small runnable application |
| **Comparison** | Implement the same requirement with different stores, clients, or programming models |

Possible short projects include:

- a validated CRUD REST API with JPA, migrations, pagination, and integration tests;
- a secure task API with users, roles, method security, and JWT resource-server support;
- a Redis-backed cache and session experiment;
- a reactive WebFlux and R2DBC service;
- a MongoDB document API with indexes and aggregation;
- an OAuth 2.0 client and OpenID Connect login example;
- an authorization server plus protected resource server;
- an event-driven service using Kafka, RabbitMQ, or Pulsar; and
- an observable service with Actuator, metrics, tracing, health checks, and containers.

## Suggested repository organization

```text
.
├── boot/
│   ├── experiments/
│   ├── exercises/
│   └── mini-projects/
├── data/
│   ├── relational/
│   ├── nosql/
│   └── reactive/
├── security/
│   ├── authentication/
│   ├── authorization/
│   ├── oauth2-oidc/
│   └── testing/
├── integrated-projects/
└── README.md
```

Each runnable example should include a short local README that explains:

- the learning objective;
- the Spring features and dependencies used;
- prerequisites and required infrastructure;
- how to run the application and its tests;
- sample requests or expected behavior; and
- lessons learned and possible improvements.

## Running an example

Requirements vary by project. Check the example's build file and local README first. A typical Maven-based example can be run with:

```bash
./mvnw spring-boot:run
```

Run its tests with:

```bash
./mvnw test
```

For a Gradle-based example, use:

```bash
./gradlew bootRun
./gradlew test
```

Some examples may also require Docker or Docker Compose for databases, brokers, identity providers, or observability services.

## Learning principles

- Keep each example focused on a clear learning objective.
- Prefer working code and automated tests over configuration-only samples.
- Never commit real credentials, tokens, certificates, or personal data.
- Use supported password encoders and safe defaults in security examples.
- Document intentional shortcuts; do not present learning shortcuts as production guidance.
- Pin or manage compatible dependency versions through Spring Boot and Spring Data BOMs.
- Revisit examples as Spring APIs and recommended practices evolve.

## Official references

- [Spring Boot reference documentation](https://docs.spring.io/spring-boot/reference/)
- [Spring Boot official starter list](https://docs.spring.io/spring-boot/reference/using/build-systems.html#using.build-systems.starters)
- [Spring Data project and module list](https://spring.io/projects/spring-data)
- [Spring Security reference documentation](https://docs.spring.io/spring-security/reference/)
- [Spring Security modules](https://docs.spring.io/spring-security/reference/modules.html)
- [Spring Security features](https://docs.spring.io/spring-security/reference/features/index.html)
- [Spring Authorization Server](https://spring.io/projects/spring-authorization-server)
- [Spring Security Kerberos](https://spring.io/projects/spring-security-kerberos)

---

This repository is for education, experimentation, and portfolio development. Review security, licensing, operational, and support requirements before adapting an example for production use.
