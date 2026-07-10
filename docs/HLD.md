# High-Level Design (HLD)

# SkillBridge AI

## Tagline

**Bridge Your Skills to Your Dream Career**

---

# 1. Overview

SkillBridge AI is an AI-powered Career Intelligence Platform that helps users analyze resumes, improve ATS scores, identify skill gaps, practice AI-powered mock interviews, receive intelligent feedback, and build personalized learning roadmaps.

The application follows a **Modular Monolith Architecture** with **Clean Architecture** principles. Each module is independently designed so it can be extracted into microservices in the future with minimal changes.

---

# 2. System Architecture

```
                        +----------------------+
                        |   Next.js Frontend   |
                        +----------+-----------+
                                   |
                             HTTPS / REST API
                                   |
                        +----------v-----------+
                        | Spring Boot Backend  |
                        |      (Java 21)       |
                        +----------+-----------+
                                   |
        +--------------+-----------+-----------+-------------+
        |              |                       |             |
        |              |                       |             |
        v              v                       v             v
 PostgreSQL         Redis                 RabbitMQ      Gemini API
 (Primary DB)       Cache                  Messaging       AI
        |
        |
        v
   AWS S3 (Resume Storage)

```

---

# 3. Core Modules

The application is divided into independent business modules.

### Authentication Module

- User Registration
- Login
- JWT Authentication
- Refresh Token
- Email Verification
- Forgot Password
- RBAC

---

### User Module

- User Profile
- Skills
- Education
- Experience
- Target Role
- Social Links

---

### Resume Intelligence

- Resume Upload
- PDF Parsing
- Resume Storage
- Resume History
- AI Resume Summary
- Skill Extraction

---

### ATS Engine

- ATS Score
- Keyword Matching
- Missing Skills
- Resume Suggestions
- Resume Analytics

---

### Skill Intelligence

- Skill Gap Analysis
- Learning Roadmap
- Career Recommendation
- Progress Tracking

---

### AI Interview

- HR Interview
- Java Interview
- Spring Boot Interview
- SQL Interview
- DSA Interview
- System Design Interview

---

### AI Feedback

- Technical Evaluation
- Communication Score
- Weak Topic Detection
- Improvement Suggestions

---

### Notification Module

- Email Notifications
- Progress Reminder
- Interview Reminder
- WebSocket Notifications

---

### Dashboard

- Resume History
- ATS Analytics
- Interview Progress
- Learning Progress

---

# 4. Technology Stack

## Backend

- Java 21 LTS
- Spring Boot 3.x
- Spring Security
- Spring Data JPA
- Hibernate
- Flyway
- MapStruct
- Lombok
- Jakarta Validation
- Springdoc OpenAPI

---

## Frontend

- Next.js
- React
- TypeScript
- Tailwind CSS
- shadcn/ui

---

## Database

### PostgreSQL

Primary relational database for:

- Users
- Roles
- Refresh Tokens
- User Profiles
- Skills
- Education
- Experience
- Resume Metadata
- ATS Reports
- Interview Sessions
- Notifications

**JSONB Columns**

Semi-structured data stored using PostgreSQL JSONB:

- Parsed Resume JSON
- AI Resume Summary
- AI Feedback
- Chat History
- Prompt Logs

---

## Cache

### Redis

Used for:

- User Session Cache
- Resume Cache
- ATS Cache
- AI Response Cache

---

## Messaging

### RabbitMQ

Queues:

- Resume Processing Queue
- AI Processing Queue
- Email Queue
- Notification Queue

---

## AI

Google Gemini API

Responsibilities:

- Resume Summary
- Skill Extraction
- ATS Suggestions
- Interview Questions
- Answer Evaluation
- Learning Roadmaps

---

# 5. Request Flow

```
User

↓

Next.js Frontend

↓

Spring Security

↓

REST Controller

↓

Service Layer

↓

Repository Layer

↓

PostgreSQL / Redis

↓

Gemini API (if AI required)

↓

Response

↓

Frontend
```

---

# 6. Security Architecture

Security mechanisms include:

- JWT Authentication
- Refresh Token Rotation
- BCrypt Password Encoding
- Role-Based Access Control (RBAC)
- Input Validation
- Global Exception Handling
- Secure HTTP Headers
- CORS Configuration

---

# 7. Scalability Strategy

### Current

Modular Monolith

Advantages

- Easy deployment
- Faster development
- Lower infrastructure cost
- Simple debugging

---

### Future Migration

The following modules can be extracted into independent microservices:

- API Gateway
- Authentication Service
- User Service
- Resume Service
- ATS Service
- AI Service
- Notification Service

---

# 8. Deployment Architecture

```
User

↓

Next.js

↓

Nginx Reverse Proxy

↓

Spring Boot Application

↓

PostgreSQL

↓

Redis

↓

RabbitMQ

↓

AWS S3

↓

Gemini API
```

---

# 9. Monitoring & Observability

Monitoring stack includes:

- Spring Boot Actuator
- Micrometer
- Prometheus
- Grafana
- OpenTelemetry
- AWS CloudWatch
- Structured JSON Logging

---

# 10. Design Principles

The project follows modern software engineering practices.

### Architecture

- Clean Architecture
- Modular Monolith
- Layered Architecture

### Principles

- SOLID
- DRY
- KISS
- Separation of Concerns
- Dependency Injection
- Single Responsibility Principle

---

# 11. High-Level Goals

- Production-grade Architecture
- Scalable Design
- Secure Authentication
- AI Integration
- Cloud Ready
- Docker Ready
- CI/CD Ready
- Monitoring Ready
- Interview Ready