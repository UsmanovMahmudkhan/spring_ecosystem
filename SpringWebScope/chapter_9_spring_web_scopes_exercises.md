<div style="font-size: 1.15em; line-height: 1.7;">

# Chapter 9 Exercises: Spring Web Scopes

<span style="font-size: 1.25em;"><strong>Topic:</strong> Request scope, session scope, and application scope in Spring MVC / Spring Boot</span>

<span style="font-size: 1.25em;"><strong>Source basis:</strong> Chapter 9 of <em>Spring Start Here</em>, which covers Spring web scopes.</span>

---

## Core Rule You Must Understand

<div style="font-size: 1.25em;">

| Data lifetime | Correct scope |
|---|---|
| Exists only during one HTTP request | `@RequestScope` |
| Belongs to one browser/user session | `@SessionScope` |
| Shared by the whole running app | `@ApplicationScope` |

</div>

If you choose the wrong scope, your app may leak data between users, forget data too early, or share private state globally. That is not a small mistake. It is a real design bug.

---

# Exercise 1 — Request Scope: Search Filter Cleaner

## Goal

Use `@RequestScope` for data that should exist only during one HTTP request.

Build a small product search page.

## Endpoint

```text
GET /search
```

## Request Parameters

```text
keyword
minPrice
maxPrice
category
```

Example:

```text
/search?keyword=phone&minPrice=100&maxPrice=700&category=electronics
```

## Required Bean

Create a request-scoped bean:

```java
SearchRequestData
```

It should store the values for the current search request only.

## Requirements

For each request:

1. Read request parameters.
2. Store them inside the request-scoped bean.
3. Normalize the data:
   - trim spaces
   - convert category to lowercase
   - if `minPrice > maxPrice`, show an error message
4. Return a page showing the cleaned filter values.

## Manual Test

Open two browser tabs:

```text
/search?keyword= laptop &minPrice=500&maxPrice=1000&category=ELECTRONICS
/search?keyword=book&minPrice=10&maxPrice=50&category=Education
```

## Expected Result

The values must not mix.

If they mix, your scope choice or bean design is wrong.

---

# Exercise 2 — Request Scope: Form Validation Result

## Goal

Understand why request scope is good for temporary form-processing data.

Build a contact form.

## Endpoints

```text
GET /contact
POST /contact
```

## Form Fields

```text
name
email
message
```

## Required Bean

Create a request-scoped bean:

```java
ContactFormProcessor
```

It should store:

```text
name
email
message
valid
errors
```

## Validation Rules

- `name` must not be empty.
- `email` must contain `@`.
- `message` must be at least 10 characters.

## Expected Behavior

After `POST /contact`:

- if valid, show: `Message accepted`
- if invalid, show all validation errors

## Important Restriction

Do not store validation errors in a singleton bean.

That would be a bad bug because errors from one request could leak into another request.

---

# Exercise 3 — Session Scope: Shopping Cart Without Database

## Goal

Use `@SessionScope` for data that belongs to one user across multiple requests.

Build a simple cart system.

## Endpoints

```text
GET /products
POST /cart/add
GET /cart
POST /cart/remove
POST /cart/clear
```

## Required Bean

Create a session-scoped bean:

```java
ShoppingCart
```

It stores:

```text
List<CartItem> items
```

Each item has:

```text
productName
quantity
price
```

## Expected Behavior

- User A adds `Keyboard`.
- User B adds `Mouse`.
- User A must not see User B’s cart.
- Refreshing User A’s page should still show User A’s cart.
- Closing the session or clearing the cart should remove the data.

## Manual Test

Use:

- normal browser window for User A
- incognito/private window for User B

## Failure Condition

If both users see the same cart, your implementation is broken.

---

# Exercise 4 — Session Scope: Theme and Language Preference

## Goal

Store user preference during a browsing session.

Build a settings page.

## Endpoints

```text
GET /settings
POST /settings
GET /home
```

## Required Bean

Create a session-scoped bean:

```java
UserPreferences
```

It stores:

```text
theme
language
```

## Possible Values

```text
theme: light, dark
language: en, ko, uz
```

## Expected Behavior

1. User opens `/settings`.
2. User chooses `dark` and `ko`.
3. User opens `/home`.
4. `/home` displays:

```text
Current theme: dark
Current language: ko
```

Another user should still have default preferences.

## Extra Challenge

Add this endpoint:

```text
POST /settings/reset
```

It should reset the session preferences.

---

# Exercise 5 — Application Scope: Global Visitor Counter

## Goal

Use `@ApplicationScope` for data shared by the whole app.

Build a global visitor counter.

## Endpoint

```text
GET /home
```

## Required Bean

Create an application-scoped bean:

```java
VisitCounter
```

It stores:

```text
int totalVisits
```

Every time any user opens `/home`, increase the counter.

## Expected Behavior

- User A opens `/home`: total visits = `1`
- User B opens `/home`: total visits = `2`
- User A refreshes: total visits = `3`

## Warning

This value is shared by all users.

Do not store user-specific data here. Application scope is global.

---

# Exercise 6 — Application Scope: Simple Poll Statistics

## Goal

Practice shared app-level state.

Build a poll.

## Poll Question

```text
Which backend framework do you prefer?
1. Spring
2. Django
3. Express
```

## Endpoints

```text
GET /poll
POST /poll/vote
GET /poll/results
```

## Required Bean

Create an application-scoped bean:

```java
PollStats
```

It stores:

```text
springVotes
djangoVotes
expressVotes
```

## Expected Behavior

Votes from all users contribute to the same result.

Example:

- User A votes Spring.
- User B votes Django.
- User C votes Spring.

Results:

```text
Spring: 2
Django: 1
Express: 0
```

## Extra Challenge

Prevent the same session from voting twice.

Use:

| Bean purpose | Scope |
|---|---|
| Total poll results | `@ApplicationScope` |
| Whether the current user already voted | `@SessionScope` |

This is the correct design. Application scope alone cannot know whether one specific user already voted.

---

# Exercise 7 — Mixed Scopes: Mini Bookstore

## Goal

Combine request, session, and application scope in one app.

Build a mini bookstore.

## Pages

```text
GET /books
POST /books/filter
POST /cart/add
GET /cart
GET /stats
```

## Required Scopes

| Bean | Scope | Purpose |
|---|---|---|
| `BookFilter` | Request scope | Stores current filter only |
| `BookCart` | Session scope | Stores current user’s selected books |
| `StoreStats` | Application scope | Stores total number of carts created / total books added globally |

## Expected Behavior

- Filtering books should not affect another request.
- Cart should stay for the same user.
- Global stats should be shared across all users.

## What This Tests

This is the real Chapter 9 understanding. Not syntax. Design.

You must know which data belongs to which lifetime:

```text
one request only       -> request scope
one user session       -> session scope
whole running app      -> application scope
```

---

# Exercise 8 — Debugging Scope Mistake

## Goal

Identify wrong scope choices.

You are given this design:

```text
CurrentSearchKeyword -> @ApplicationScope
ShoppingCart         -> @ApplicationScope
TotalWebsiteVisits   -> @RequestScope
ThemePreference      -> @RequestScope
```

## Task

Explain why every choice is wrong, then correct it.

## Expected Correction

| Data | Correct scope | Why |
|---|---|---|
| Current search keyword | Request | It belongs only to one search request |
| Shopping cart | Session | It belongs to one user across multiple requests |
| Total website visits | Application | It is shared globally |
| Theme preference | Session | It belongs to one user during browsing |

This exercise is boring but important. Exams and interviews often test this exact thinking.

---

# Exercise 9 — Scope Prediction Questions

## Goal

Answer without coding.

## Question 1

A user submits a feedback form. The app stores the submitted text in a request-scoped bean. The user refreshes the page with a new GET request.

Will the old feedback text still exist?

## Question 2

A user adds a laptop to a session-scoped cart. Then the same user opens `/cart` in another tab of the same browser.

Should the laptop appear?

## Question 3

Two users open the app. The app stores `currentUsername` in an application-scoped bean.

What is the bug?

## Question 4

An application-scoped bean stores `int counter`. Many users access the app at the same time.

What risk appears?

## Question 5

A request-scoped bean is injected into a singleton service.

Why can this be tricky?

---

# Exercise 10 — Hard Exercise: Support Ticket System

## Goal

Build something realistic using all Chapter 9 scopes.

Create a support ticket web app.

## Endpoints

```text
GET /ticket/new
POST /ticket/preview
POST /ticket/submit
GET /ticket/my
GET /admin/stats
```

## Required Beans

## 1. `TicketDraft`

Scope:

```text
Request scope
```

Stores current submitted form data:

```text
title
description
priority
validationErrors
```

Used only during preview/submission request.

## 2. `UserTicketSession`

Scope:

```text
Session scope
```

Stores tickets submitted by the current browser session:

```text
List<Ticket> myTickets
```

## 3. `TicketStats`

Scope:

```text
Application scope
```

Stores global app statistics:

```text
totalSubmittedTickets
highPriorityTickets
normalPriorityTickets
lowPriorityTickets
```

## Expected Behavior

- Invalid ticket data should not survive after the request.
- User A should only see User A’s submitted tickets.
- Admin stats should count all submitted tickets from all users.
- Opening the app in incognito should create a different session.

---

# Best Order to Solve

```text
1 -> 2 -> 3 -> 5 -> 6 -> 7 -> 10
```

Skip Exercise 4 if you already understand session scope.

Do Exercises 8 and 9 before an exam or interview.

---

# Final Self-Check

Before saying you understand Chapter 9, you should be able to answer these without hesitation:

| Question | Correct idea |
|---|---|
| Should search filters be session-scoped? | Usually no. They usually belong to one request. |
| Should a cart be request-scoped? | No. It would disappear after every request. |
| Should a username be application-scoped? | No. That leaks user-specific data globally. |
| Should global stats be session-scoped? | No. Each user would have separate stats. |
| Can application-scoped mutable state have concurrency problems? | Yes. Multiple users can modify it at the same time. |

</div>
