# Low-Level Design (LLD)

# SkillBridge AI

## 1. Introduction

This document describes the internal architecture of SkillBridge AI.

The project follows:

- Modular Monolith
- Clean Architecture
- SOLID Principles
- Layered Design

Each business module is isolated and can later be extracted as an independent microservice.

---

# 2. Backend Package Structure

```
com.skillbridge

├── auth
├── user
├── resume
├── ats
├── interview
├── notification
├── dashboard
├── ai

├── common
├── config
├── security
├── exception
└── util
```

---

# 3. Module Structure

Each module follows the same layout.

```
auth

controller

service

service/impl

repository

entity

dto

mapper

validator

event

config
```

---

# 4. Layer Responsibilities

## Controller

- Handle HTTP Requests
- Validate Input
- Return Response DTO

---

## Service

Contains business logic.

Examples

- Register User
- Calculate ATS
- Generate Resume Summary

---

## Repository

Responsible for database operations using Spring Data JPA.

---

## Entity

Maps database tables.

---

## DTO

Transfers data between layers.

Never expose entities directly.

---

## Mapper

MapStruct converts

Entity ⇄ DTO

---

## Validator

Custom validations.

Examples

- Password Policy
- Resume Validation
- Email Validation

---

# 5. Authentication Flow

Client

↓

Auth Controller

↓

Authentication Service

↓

User Repository

↓

JWT Generator

↓

Response

---

# 6. Resume Processing Flow

User Upload

↓

Resume Controller

↓

Resume Service

↓

PostgreSQL

↓

RabbitMQ Queue

↓

AI Service

↓

Gemini API

↓

Store Result

↓

Response

---

# 7. ATS Flow

Resume

↓

ATS Controller

↓

ATS Service

↓

Keyword Analyzer

↓

ATS Score Engine

↓

Suggestions

↓

Response

---

# 8. AI Interview Flow

Start Interview

↓

Generate Question

↓

Store Question

↓

Receive Answer

↓

Gemini Evaluation

↓

Store Feedback

↓

Next Question

---

# 9. Common Components

Global Exception Handler

API Response Wrapper

Validation Framework

Audit Logging

Utility Classes

Constants

Enums

---

# 10. Design Patterns

Repository Pattern

DTO Pattern

Factory Pattern

Strategy Pattern

Builder Pattern

Singleton

Dependency Injection

---

# 11. Error Handling

Global Exception Handler

Validation Errors

Authentication Errors

Business Exceptions

Resource Not Found

Internal Server Error

---

# 12. Logging

Structured JSON Logging

Request Logging

Error Logging

Audit Logging

---

# 13. Future Improvements

Microservices

API Gateway

Kafka

ElasticSearch

Kubernetes

Distributed Tracing