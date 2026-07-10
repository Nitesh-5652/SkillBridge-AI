# API Design

# SkillBridge AI

## 1. API Overview

The SkillBridge AI backend exposes RESTful APIs following REST principles.

**Base URL**

```
/api/v1
```

---

# 2. Response Format

## Success Response

```json
{
  "success": true,
  "message": "Operation successful",
  "data": {},
  "timestamp": "2026-07-10T14:30:00Z"
}
```

---

## Error Response

```json
{
  "success": false,
  "message": "Validation failed",
  "errorCode": "VALIDATION_ERROR",
  "errors": [
    {
      "field": "email",
      "message": "Invalid email"
    }
  ],
  "timestamp": "2026-07-10T14:30:00Z"
}
```

---

# 3. Authentication APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | /auth/register | Register user |
| POST | /auth/login | Login |
| POST | /auth/refresh | Refresh access token |
| POST | /auth/logout | Logout |
| POST | /auth/forgot-password | Forgot password |
| POST | /auth/reset-password | Reset password |
| GET | /auth/verify-email | Verify email |

---

# 4. User APIs

| Method | Endpoint |
|---------|----------|
| GET | /users/me |
| PUT | /users/me |
| POST | /users/photo |
| GET | /users/profile |

---

# 5. Resume APIs

| Method | Endpoint |
|---------|----------|
| POST | /resumes |
| GET | /resumes |
| GET | /resumes/{id} |
| DELETE | /resumes/{id} |

---

# 6. ATS APIs

| Method | Endpoint |
|---------|----------|
| POST | /ats/analyze |
| GET | /ats/{resumeId} |

---

# 7. Interview APIs

| Method | Endpoint |
|---------|----------|
| POST | /interviews/start |
| POST | /interviews/answer |
| POST | /interviews/end |
| GET | /interviews/history |

---

# 8. Notification APIs

| Method | Endpoint |
|---------|----------|
| GET | /notifications |
| PUT | /notifications/read |

---

# 9. HTTP Status Codes

- 200 OK
- 201 Created
- 204 No Content
- 400 Bad Request
- 401 Unauthorized
- 403 Forbidden
- 404 Not Found
- 409 Conflict
- 500 Internal Server Error

---

# 10. API Versioning

```
/api/v1
```

Future versions:

```
/api/v2
```

---

# 11. Pagination

Example:

```
GET /resumes?page=0&size=10&sort=createdAt,desc
```

---

# 12. OpenAPI

The project will use:

- Springdoc OpenAPI
- Swagger UI