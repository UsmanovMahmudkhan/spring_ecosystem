<div style="font-size: 1.18rem; line-height: 1.75;">

# Chapter 12 Master Project: Purchase Ledger

## Brutal Purpose

This project is small, but it is not shallow.

You are not building a “cool app.” You are building a database-backed Spring app that forces you to understand Chapter 12 properly:

- what a data source is
- why Spring Boot can auto-configure a data source
- where `JdbcTemplate` comes from
- how repository classes use `JdbcTemplate`
- how SQL parameters are passed safely
- when to use `update`
- when to use `query`
- how to configure the database connection
- how to replace Spring Boot’s default data source with your own custom data source
- why JDBC is different from Spring Data and JPA

No JPA.  
No Spring Data repositories.  
No Hibernate.  
No copied tutorial project.  
No “it works somehow” garbage.

You will build a small backend that manages purchases using plain SQL through Spring’s `JdbcTemplate`.

---

# Project Name

## Purchase Ledger

A simple REST backend for recording purchases, searching them, updating them, deleting them, and calculating spending summaries.

The app should feel like a tiny expense tracker, but the real purpose is database access practice.

---

# What You Need To Build

Build a Spring Boot application with one database table named `purchase`.

Each purchase represents something a user bought.

A purchase must store:

- id
- name
- category
- price
- created date
- payment method
- status

Example categories:

- FOOD
- TRANSPORT
- STUDY
- TECH
- CLOTHES
- OTHER

Example payment methods:

- CASH
- CARD
- BANK_TRANSFER

Example statuses:

- ACTIVE
- CANCELLED

---

# Core Rule

## All database work must go through `JdbcTemplate`.

Your controller is not allowed to talk directly to `JdbcTemplate`.

Your service is not allowed to contain raw SQL.

Your repository is the only layer allowed to contain SQL.

If you break this rule, you did not learn Chapter 12. You only made a mess that happens to run.

---

# Required Layers

Use this structure:

## Controller Layer

Responsible for HTTP endpoints only.

It receives requests, calls the service, and returns responses.

It must not know how the database works.

## Service Layer

Responsible for business rules.

It decides whether a purchase is valid, whether a purchase can be cancelled, and what should happen when data is invalid.

It must not contain SQL.

## Repository Layer

Responsible for database access.

It uses `JdbcTemplate`.

It contains all SQL.

It maps database rows into Java objects.

## Model / DTO Layer

Responsible for representing data.

Use separate request and response objects where needed.

Do not blindly expose every internal model if it creates ugly API design.

---

# Functional Requirements

## 1. Add Purchase

Create a new purchase.

The user sends:

- name
- category
- price
- payment method

The server stores the purchase with:

- generated id
- current created date
- status set to ACTIVE

Practice target:

- SQL INSERT
- auto-generated id
- `JdbcTemplate.update`
- request body handling
- basic validation before database insertion

---

## 2. Get All Purchases

Return every purchase ordered by newest first.

Practice target:

- SQL SELECT
- `JdbcTemplate.query`
- row mapping
- returning lists
- ordering results from SQL, not Java

---

## 3. Find Purchase By ID

Return one purchase by id.

If the id does not exist, return a clear error response.

Practice target:

- SELECT with WHERE
- handling empty results
- deciding whether repository returns null, optional result, or throws an exception
- clean controller response

---

## 4. Search Purchases By Price Range

Return purchases where price is between minimum and maximum values.

The endpoint should accept request parameters.

Practice target:

- query parameters
- SELECT with multiple parameters
- SQL parameter binding
- BigDecimal handling
- avoiding string concatenation in SQL

---

## 5. Search Purchases By Category

Return purchases for one category.

Practice target:

- enum/string conversion
- SELECT with WHERE
- repository method naming
- separating business meaning from SQL details

---

## 6. Update Purchase Price

Change the price of an existing purchase.

Rules:

- price must be positive
- cancelled purchases cannot be updated
- if the purchase does not exist, return a clear error

Practice target:

- SELECT before UPDATE
- SQL UPDATE
- affected row count
- service-layer business rules
- not trusting the client blindly

---

## 7. Cancel Purchase

Do not delete the row.

Change status from ACTIVE to CANCELLED.

Rules:

- an already cancelled purchase should not be cancelled again
- cancelled purchases should still be visible in history

Practice target:

- UPDATE instead of DELETE
- business state changes
- repository update method
- service-layer protection

---

## 8. Delete Purchase Permanently

Add one endpoint that really deletes a row.

This is intentionally separate from cancellation.

Practice target:

- SQL DELETE
- affected row count
- understanding the difference between soft delete and hard delete

---

## 9. Spending Summary

Create an endpoint that returns:

- total amount spent
- total active purchases
- total cancelled purchases
- average purchase price
- highest purchase price
- lowest purchase price

Only ACTIVE purchases count for total amount, average, highest, and lowest.

Practice target:

- aggregate SQL
- COUNT
- SUM
- AVG
- MIN
- MAX
- mapping one summary row into a response object

---

# Database Requirements

## First Version: H2 Database

Start with H2.

Use Spring Boot’s default auto-configuration first.

You must understand this clearly:

Spring Boot sees the H2 dependency and creates a data source automatically.

Spring Boot also creates a `JdbcTemplate` automatically.

That is why you can inject `JdbcTemplate` into your repository.

If you cannot explain this in your own words, you did not understand the chapter.

---

## Second Version: Custom DataSource Bean

After the basic app works, create a custom `DataSource` bean manually.

The app must still work.

This forces you to understand that Spring Boot’s auto-configuration is not magic. It is conditional.

When you provide your own `DataSource`, Spring uses yours instead of creating the default one.

Practice target:

- custom Spring bean
- replacing auto-configuration
- understanding dependency injection
- understanding what `JdbcTemplate` depends on

---

## Third Version: External Database Configuration

Move database settings into application properties.

The app should read database URL, username, and password from configuration.

Practice target:

- datasource configuration
- separation between code and environment
- understanding why production apps do not hard-code connection details

---

# Endpoints You Must Have

## Purchase Commands

| Method | Path | Purpose |
|---|---|---|
| POST | `/purchases` | Add purchase |
| PATCH | `/purchases/{id}/price` | Update purchase price |
| PATCH | `/purchases/{id}/cancel` | Cancel purchase |
| DELETE | `/purchases/{id}` | Delete purchase permanently |

## Purchase Queries

| Method | Path | Purpose |
|---|---|---|
| GET | `/purchases` | Get all purchases |
| GET | `/purchases/{id}` | Find purchase by id |
| GET | `/purchases/search/price` | Search by price range |
| GET | `/purchases/search/category` | Search by category |
| GET | `/purchases/summary` | Get spending summary |

---

# Concepts You Must Practice

## DataSource

You must be able to answer:

- What is a data source?
- Why does the app need it?
- Why is opening a new database connection manually every time a bad idea?
- What does the JDBC driver do?
- Why does the data source depend on the JDBC driver?
- What does Spring Boot configure automatically?

## JdbcTemplate

You must be able to answer:

- What problem does `JdbcTemplate` solve?
- Why is it better than raw JDBC?
- What does `update` do?
- What does `query` do?
- Why do we use placeholders for SQL parameters?
- Why should we avoid building SQL using string concatenation?

## Repository Design

You must be able to answer:

- Why is SQL inside the repository?
- Why should the controller not contain SQL?
- Why should the service not contain SQL?
- What does row mapping mean?
- What should happen when a SELECT returns no rows?

## Configuration

You must be able to answer:

- What happens if you define your own `DataSource` bean?
- Why should database settings be outside Java classes?
- What is the difference between default auto-configuration and custom configuration?

---

# Restrictions

## Forbidden

You are not allowed to use:

- Spring Data JDBC
- Spring Data JPA
- Hibernate
- JPA annotations
- repositories generated by Spring Data
- copied code from the book
- copied code from tutorials
- SQL built by string concatenation
- controller methods that directly access the database
- service methods that contain SQL

## Allowed

You are allowed to use:

- Spring Boot
- Spring Web
- H2
- JDBC driver
- `JdbcTemplate`
- `DataSource`
- `BigDecimal`
- Postman or curl for testing
- simple HTML page only if you really want, but REST endpoints are enough

---

# Build Order

## Phase 1: Database Table

Create the `purchase` table.

Decide the correct SQL types.

Do not be lazy with price. Use a decimal type, not floating point.

Your table must support generated ids.

Checkpoint:

- app starts
- database table exists
- no Java database code yet

---

## Phase 2: Repository Insert

Create the repository.

Inject `JdbcTemplate`.

Add the database operation for inserting a purchase.

Checkpoint:

- you can add one purchase through the app
- the row appears in the database

---

## Phase 3: Repository Select

Add methods for:

- finding all purchases
- finding by id
- finding by category
- finding by price range

Checkpoint:

- every SELECT maps database rows correctly
- no controller contains SQL
- no service contains SQL

---

## Phase 4: Update and Delete

Add methods for:

- updating price
- cancelling purchase
- deleting purchase

Checkpoint:

- you understand affected row count
- you handle missing ids properly
- cancelled rows remain in history

---

## Phase 5: Summary Query

Add the spending summary endpoint.

Checkpoint:

- summary values come from SQL aggregates
- you are not calculating everything manually in Java
- only ACTIVE purchases count for spending totals

---

## Phase 6: Custom DataSource

Replace Spring Boot’s default data source with your own `DataSource` bean.

Checkpoint:

- app still works
- you can explain why your bean is now used
- you understand that `JdbcTemplate` needs a `DataSource`

---

## Phase 7: Configuration Cleanup

Move database connection values into application properties.

Checkpoint:

- no hard-coded database URL in business classes
- app still starts
- database operations still work

---

# Testing Checklist

Use Postman or curl and manually verify:

## Add Valid Data

Add at least 10 purchases with different categories and prices.

## Add Invalid Data

Try:

- empty name
- negative price
- zero price
- invalid category
- invalid payment method

The app should reject bad data.

## Query Data

Verify:

- all purchases return newest first
- search by category works
- search by price range works
- finding by id works
- missing id returns a clear error

## Update Data

Verify:

- price updates correctly
- negative price is rejected
- cancelled purchase cannot be updated
- missing id is handled correctly

## Cancel Data

Verify:

- active purchase becomes cancelled
- cancelling twice is rejected
- cancelled purchase remains visible

## Delete Data

Verify:

- deleted purchase disappears permanently
- deleting missing id returns a clear result

## Summary

Verify summary manually using database data.

Do not trust your endpoint blindly.

---

# What You Should Write In Your README

Your README must answer these questions:

## 1. What does the app do?

Explain the project in 5–8 sentences.

## 2. What Chapter 12 concepts does it practice?

Mention:

- data source
- JDBC driver
- `JdbcTemplate`
- repository layer
- SQL mutation
- SQL selection
- custom data source
- external configuration

## 3. What are the endpoints?

List every endpoint and its purpose.

## 4. What database table did you create?

Describe the table columns and why each exists.

Do not paste code.

## 5. What mistakes did you make?

Be honest.

Write at least 5 mistakes you made while building it.

Examples:

- wrong SQL placeholders
- wrong BigDecimal handling
- forgot to inject `JdbcTemplate`
- used wrong HTTP method
- mixed service and repository logic
- forgot that cancelled purchases should not be updated

## 6. What did you finally understand?

Write this in your own words:

- how Spring Boot creates the data source
- how `JdbcTemplate` gets created
- how repository methods send SQL to the database
- how `query` differs from `update`
- how custom data source configuration changes the app

---

# Final Self-Test

Before saying you finished, answer these without looking:

## DataSource

1. What is a data source?
2. Why does the app need a JDBC driver?
3. What does Spring Boot auto-configure when H2 is present?
4. What changes when you define your own `DataSource` bean?

## JdbcTemplate

1. Why does `JdbcTemplate` need a data source?
2. When do you use `update`?
3. When do you use `query`?
4. Why do placeholders matter?

## Architecture

1. Why should SQL stay in the repository?
2. Why should validation stay in the service?
3. Why should the controller stay thin?
4. What is row mapping?

## SQL

1. How do you insert a row with a generated id?
2. How do you update only one row?
3. How do you delete only one row?
4. How do you calculate total spending using SQL?

If you cannot answer these, the project is not finished.

---

# Definition Of Done

You are done only when all of these are true:

- app starts successfully
- table is created
- at least 10 purchases can be added
- all GET endpoints work
- update price works
- cancel works
- delete works
- summary works
- invalid input is rejected
- SQL exists only in repository
- `JdbcTemplate` is used for all database access
- custom `DataSource` version works
- application properties version works
- README explains the Chapter 12 concepts in your own words

---

# Why This Project Works

This project is small enough to finish.

But it forces the real Chapter 12 ideas:

- you must write SQL
- you must pass parameters
- you must map rows
- you must configure a database
- you must use `JdbcTemplate`
- you must understand `DataSource`
- you must separate controller, service, and repository
- you must see what Spring Boot gives you automatically
- you must replace that automatic behavior once manually

That is exactly what you need.

A bigger project would distract you.

A smaller project would be too weak.

</div>
