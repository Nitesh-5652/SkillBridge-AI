# Deployment Design

# SkillBridge AI

---

# 1. Deployment Overview

SkillBridge AI is designed to run in Docker containers and be deployed to AWS.

The deployment architecture focuses on scalability, security, and maintainability.

---

# 2. Local Development

Docker Compose will orchestrate:

- Spring Boot Backend
- Next.js Frontend
- PostgreSQL
- Redis
- RabbitMQ

---

# 3. Production Architecture

```
Users
    │
    ▼
Internet
    │
    ▼
Nginx Reverse Proxy
    │
    ▼
Spring Boot Application
    │
    ├── PostgreSQL
    ├── Redis
    ├── RabbitMQ
    ├── AWS S3
    └── Gemini API
```

---

# 4. Cloud Infrastructure

AWS Services:

- EC2
- RDS PostgreSQL
- S3
- CloudWatch

---

# 5. CI/CD

GitHub Actions Pipeline

Developer Push

↓

Build

↓

Run Tests

↓

Build Docker Image

↓

Deploy to EC2

---

# 6. Monitoring

- Spring Boot Actuator
- Micrometer
- Prometheus
- Grafana
- OpenTelemetry
- CloudWatch

---

# 7. Future Improvements

- Kubernetes
- Auto Scaling
- Load Balancer
- Blue-Green Deployment