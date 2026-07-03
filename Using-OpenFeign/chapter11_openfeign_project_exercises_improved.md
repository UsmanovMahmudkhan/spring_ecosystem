<div style="font-size: 18px; line-height: 1.65; font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Arial, sans-serif;">

# Chapter 11 — OpenFeign Project Exercises

**Focus:** Spring Start Here, Chapter 11, section 11.1 — consuming REST endpoints with **Spring Cloud OpenFeign**.

**Restriction:** Use **OpenFeign only**. Do **not** use `RestTemplate`. Do **not** use `WebClient`.

---

# 1. Topic Explanation Before Exercises

## What Chapter 11 is really about

Chapter 11 moves from **creating REST endpoints** to **calling REST endpoints**.

In Chapter 10, your app acts as a **server**:

```text
Client -> Your Spring App
```

In Chapter 11, your Spring app can also act as a **client**:

```text
Your Spring App -> Another Spring App
```

That means one backend service can call another backend service through HTTP.

Example:

```text
order-service -> product-service
payment-client -> payment-service
transfer-service -> wallet-service
```

This is common in backend and microservice-style systems.

---

## What OpenFeign does

OpenFeign lets you call another REST API by writing a Java interface.

You do **not** manually build HTTP requests.
You do **not** manually open connections.
You do **not** manually parse the response.

You define the remote API contract like this:

```java
@FeignClient(name = "payment-service", url = "${payments.url}")
public interface PaymentClient {
    @PostMapping("/payment")
    Payment createPayment(@RequestHeader String requestId, @RequestBody Payment payment);
}
```

Spring creates the real implementation automatically and registers it as a bean.

Then you inject it like a normal dependency:

```java
@Service
public class PaymentService {
    private final PaymentClient paymentClient;

    public PaymentService(PaymentClient paymentClient) {
        this.paymentClient = paymentClient;
    }

    public Payment create(Payment payment) {
        return paymentClient.createPayment(UUID.randomUUID().toString(), payment);
    }
}
```

---

## The key idea

OpenFeign is basically this:

```text
Java interface + Spring MVC annotations = HTTP client
```

You write what the HTTP request should look like.
Spring handles how to execute it.

---

## Why OpenFeign is useful

Without OpenFeign, service-to-service HTTP calls become more manual and messy.

With OpenFeign, you keep the HTTP client clean:

```text
Controller -> Service -> Feign Client -> Remote REST API
```

Good structure:

```text
OrderController
    -> OrderService
        -> ProductClient
            -> product-service
```

Bad structure:

```text
OrderController
    -> Feign Client directly
```

The second version works, but it becomes messy when business logic grows.

---

## What you must understand before doing the exercises

You must already know these Spring MVC basics:

| Concept | Needed for OpenFeign? | Why |
|---|---:|---|
| `@RestController` | Yes | The provider service exposes REST endpoints |
| `@GetMapping` / `@PostMapping` | Yes | Feign methods must match HTTP methods |
| `@RequestBody` | Yes | Used for JSON request bodies |
| `@RequestParam` | Yes | Used for query parameters |
| `@PathVariable` | Yes | Used for dynamic URL values |
| `@RequestHeader` | Yes | Used for headers like request IDs |
| DTO classes | Yes | Used for request and response objects |
| Dependency injection | Yes | Feign clients are injected as beans |

If these are weak, OpenFeign will feel harder than it really is.

---

## Minimum project setup

For these exercises, most tasks use two Spring Boot apps:

```text
provider-service
consumer-service
```

The provider service exposes REST endpoints.
The consumer service calls those endpoints using OpenFeign.

Example:

```text
payment-service      runs on port 8080
payment-client       runs on port 8081
```

---

## Required dependency setup

Provider service usually needs:

```text
Spring Web
```

Consumer service needs:

```text
Spring Web
Spring Cloud OpenFeign
```

---

## Required OpenFeign setup

In the consumer app main class:

```java
@EnableFeignClients
@SpringBootApplication
public class PaymentClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaymentClientApplication.class, args);
    }
}
```

In `application.properties`:

```properties
server.port=8081
payments.url=http://localhost:8080
```

Feign client example:

```java
@FeignClient(name = "payment-service", url = "${payments.url}")
public interface PaymentClient {
}
```

---

## OpenFeign annotation matching rule

The Feign method must match the remote endpoint exactly.

| Remote endpoint | Feign method must use |
|---|---|
| `GET /payment/{id}` | `@GetMapping("/payment/{id}")` + `@PathVariable` |
| `POST /payment` | `@PostMapping("/payment")` + `@RequestBody` |
| `GET /search?min=10` | `@GetMapping("/search")` + `@RequestParam` |
| Header `requestId` | `@RequestHeader String requestId` |

If the path, HTTP method, parameter name, or header name is wrong, the call fails.

---

# 2. Project Exercises

---

# Exercise 1 — Basic Payment Creation

## Goal

Build the simplest two-service OpenFeign project.

You will create:

```text
payment-service
payment-client
```

The client app calls the payment service through OpenFeign.

---

## Provider app: `payment-service`

Create a `Payment` model:

| Field | Type |
|---|---|
| `id` | `String` |
| `amount` | `double` |

Create this REST endpoint:

```text
POST /payment
```

The endpoint must:

- receive a request header named `requestId`
- receive a JSON request body containing `amount`
- generate a random payment `id`
- return the `Payment` object
- return the same `requestId` as a response header

Example request body:

```json
{
  "amount": 100.0
}
```

Example response body:

```json
{
  "id": "generated-id",
  "amount": 100.0
}
```

---

## Consumer app: `payment-client`

Create a Feign client interface:

```java
@FeignClient(name = "payment-service", url = "${payments.url}")
public interface PaymentClient {
    @PostMapping("/payment")
    Payment createPayment(@RequestHeader String requestId, @RequestBody Payment payment);
}
```

Create this endpoint in the client app:

```text
POST /client/payment
```

The client controller should:

1. receive a payment request
2. call `payment-service` using OpenFeign
3. return the payment response

---

## What this checks

- You can define a Feign interface.
- You can send a request body.
- You can send a request header.
- You understand that Spring creates the Feign implementation automatically.

---

# Exercise 2 — Get Payment by ID

## Goal

Practice OpenFeign with `@PathVariable`.

---

## Provider app: `payment-service`

Add this endpoint:

```text
GET /payment/{id}
```

Return a fake payment using the given ID.

Example response:

```json
{
  "id": "p-100",
  "amount": 250.0
}
```

---

## Consumer app: `payment-client`

Add this Feign method:

```java
@GetMapping("/payment/{id}")
Payment findPaymentById(@PathVariable String id);
```

Create this endpoint:

```text
GET /client/payment/{id}
```

Expected request:

```text
GET http://localhost:8081/client/payment/p-100
```

Expected response:

```json
{
  "id": "p-100",
  "amount": 250.0
}
```

---

## What this checks

- You can use `@PathVariable` in a Feign client.
- You understand that the client endpoint and provider endpoint can have different paths.
- You can pass data from one app to another app.

---

# Exercise 3 — Search Payments by Amount Range

## Goal

Practice OpenFeign with `@RequestParam`.

---

## Provider app: `payment-service`

Add this endpoint:

```text
GET /payments/search?minAmount=100&maxAmount=500
```

Return fake payments inside the amount range.

Example response:

```json
[
  {
    "id": "p-1",
    "amount": 120.0
  },
  {
    "id": "p-2",
    "amount": 300.0
  }
]
```

---

## Consumer app: `payment-client`

Add this Feign method:

```java
@GetMapping("/payments/search")
List<Payment> searchPayments(@RequestParam double minAmount, @RequestParam double maxAmount);
```

Create this endpoint:

```text
GET /client/payments/search?minAmount=100&maxAmount=500
```

---

## What this checks

- You can use `@RequestParam` with OpenFeign.
- You can return a list from a Feign method.
- You understand that Feign method signatures must match the remote endpoint contract.

---

# Exercise 4 — Payment Approval Flow

## Goal

Make the OpenFeign project more realistic by adding business logic around the remote call.

---

## Provider app: `payment-service`

Create this endpoint:

```text
POST /payment/approve
```

Request body:

```json
{
  "paymentId": "p-100",
  "amount": 700.0
}
```

Response body:

```json
{
  "paymentId": "p-100",
  "approved": true,
  "message": "Payment approved"
}
```

Rules:

| Condition | Result |
|---|---|
| `amount <= 1000` | approved |
| `amount > 1000` | rejected |

---

## Consumer app: `payment-client`

Create a Feign method for:

```text
POST /payment/approve
```

Create this client endpoint:

```text
POST /client/payment/approve
```

The client app must:

1. receive the approval request
2. call the provider using OpenFeign
3. return the approval response

---

## What this checks

- You can send one DTO and receive another DTO.
- You understand that OpenFeign handles HTTP communication.
- You avoid putting business rules inside the Feign interface.

---

# Exercise 5 — Product Lookup from Order Service

## Goal

Use OpenFeign in a different business domain.

You will create:

```text
product-service
order-service
```

The order service calls the product service using OpenFeign.

---

## Provider app: `product-service`

Create a `Product` model:

| Field | Type |
|---|---|
| `id` | `String` |
| `name` | `String` |
| `price` | `double` |
| `available` | `boolean` |

Create this endpoint:

```text
GET /products/{id}
```

Return fake product data.

Example response:

```json
{
  "id": "book-1",
  "name": "Spring Book",
  "price": 40.0,
  "available": true
}
```

---

## Consumer app: `order-service`

Create this endpoint:

```text
POST /orders
```

Request body:

```json
{
  "productId": "book-1",
  "quantity": 2
}
```

The order service must:

1. call `product-service` using OpenFeign
2. check if the product is available
3. calculate total price
4. return an order response

Example response:

```json
{
  "productId": "book-1",
  "productName": "Spring Book",
  "quantity": 2,
  "totalPrice": 80.0,
  "status": "CREATED"
}
```

---

## What this checks

- You understand why backend services call other backend services.
- You can use OpenFeign outside a toy payment example.
- You can combine a Feign call with simple business logic.

---

# Exercise 6 — Handle Product Not Found

## Goal

Learn what happens when the remote service returns an error.

---

## Provider app: `product-service`

Update this endpoint:

```text
GET /products/{id}
```

If the product does not exist, return:

```text
404 Not Found
```

---

## Consumer app: `order-service`

When `product-service` returns `404`, the order service should return:

```json
{
  "message": "Product not found"
}
```

---

## What this checks

- You understand that OpenFeign calls can fail.
- You know that remote service errors must be handled.
- You do not blindly assume every HTTP call succeeds.

---

# Exercise 7 — Move Feign URL to Configuration

## Goal

Stop hardcoding service URLs.

---

## Bad version

```java
@FeignClient(name = "product-service", url = "http://localhost:8080")
public interface ProductClient {
}
```

## Better version

```java
@FeignClient(name = "product-service", url = "${products.url}")
public interface ProductClient {
}
```

In `application.properties`:

```properties
products.url=http://localhost:8080
```

---

## Task

Update all Feign clients so service URLs come from `application.properties`.

---

## What this checks

- You understand basic externalized configuration.
- You avoid hardcoding URLs inside Java code.
- You prepare your app for different environments.

---

# Exercise 8 — Mini Final Project: Wallet Transfer Checker

## Goal

Build a small two-service system using OpenFeign only.

You will create:

```text
wallet-service
transfer-service
```

---

## Provider app: `wallet-service`

Create a `Wallet` model:

| Field | Type |
|---|---|
| `userId` | `String` |
| `balance` | `double` |

Expose this endpoint:

```text
GET /wallets/{userId}
```

Example response:

```json
{
  "userId": "u1",
  "balance": 500.0
}
```

---

## Consumer app: `transfer-service`

Create a Feign client for `wallet-service`.

Expose this endpoint:

```text
POST /transfers/check
```

Request body:

```json
{
  "userId": "u1",
  "amount": 200.0
}
```

The transfer service must:

1. call wallet service using OpenFeign
2. compare wallet balance with requested transfer amount
3. return whether the transfer is allowed

Successful response:

```json
{
  "userId": "u1",
  "allowed": true,
  "message": "Transfer allowed"
}
```

Failed response:

```json
{
  "userId": "u1",
  "allowed": false,
  "message": "Insufficient balance"
}
```

---

## What this checks

- You can build a small service-to-service flow.
- You can use OpenFeign with path variables and request bodies.
- You can keep business logic in the service layer instead of the Feign interface.

---

# 3. Required Checklist for Every Exercise

Before you consider an exercise complete, verify this:

- Provider service runs on one port.
- Consumer service runs on another port.
- Consumer app has `@EnableFeignClients`.
- Feign interface has `@FeignClient`.
- Feign method path matches the provider endpoint path.
- HTTP method is correct.
- Headers are mapped correctly.
- Path variables are mapped correctly.
- Request parameters are mapped correctly.
- Request bodies are mapped correctly.
- Controller calls a service class.
- Service class calls the Feign client.
- You tested the consumer endpoint, not only the provider endpoint.

---

# 4. Common Mistakes to Avoid

## Mistake 1 — Forgetting `@EnableFeignClients`

If you forget it, Spring will not scan and create your Feign client bean.

---

## Mistake 2 — Wrong port

If both apps run on `8080`, one app will fail to start.

Use something like this:

```text
provider-service: 8080
consumer-service: 8081
```

---

## Mistake 3 — Path mismatch

If the provider exposes:

```text
POST /payment
```

but the Feign client calls:

```text
POST /payments
```

it fails. The path must match exactly.

---

## Mistake 4 — Wrong annotation

This is wrong:

```java
@GetMapping("/payment/{id}")
Payment findPaymentById(@RequestParam String id);
```

This is correct:

```java
@GetMapping("/payment/{id}")
Payment findPaymentById(@PathVariable String id);
```

Use the annotation that matches the remote endpoint.

---

## Mistake 5 — Business logic inside Feign interface

Bad idea:

```text
Feign interface calculates price, validates balance, decides order status
```

Correct idea:

```text
Service class handles business logic
Feign interface only describes HTTP calls
```

---

# 5. Recommended Completion Order

| Order | Exercise | Why |
|---:|---|---|
| 1 | Exercise 1 | Basic OpenFeign call with body and header |
| 2 | Exercise 2 | Path variable |
| 3 | Exercise 3 | Request parameters |
| 4 | Exercise 7 | Configuration cleanup |
| 5 | Exercise 4 | DTO-to-DTO flow |
| 6 | Exercise 5 | Realistic service-to-service call |
| 7 | Exercise 6 | Error handling |
| 8 | Exercise 8 | Mini final project |

---

# 6. Brutal Skill Diagnosis

If Exercise 1 is hard, your problem is probably not OpenFeign. Your REST controller, DTO, and HTTP basics are still weak.

If Exercise 2 and 3 are hard, you do not properly understand the difference between:

```text
path variable
request parameter
request body
request header
```

If Exercise 5 is hard, your service-layer design is weak. You are probably mixing controller logic, business logic, and client-calling logic.

</div>
