# Security Design

# SkillBridge AI

## 1. Security Goals

The application is designed with a security-first approach to protect user accounts, resumes, and AI-generated data.

Primary goals:

- Secure authentication
- Secure authorization
- Data privacy
- Protection against common web attacks
- Secure API communication

---

# 2. Authentication

The application uses:

- Spring Security
- JWT Access Token
- Refresh Token Rotation
- BCrypt Password Hashing

Authentication Flow

User

↓

Login

↓

JWT Generated

↓

Client stores Access Token

↓

Access Token sent in Authorization Header

↓

Backend validates JWT

↓

Request Authorized

---

# 3. Authorization

Role-Based Access Control (RBAC)

Roles:

- USER
- ADMIN

Permissions:

USER

- Manage profile
- Upload resume
- Start interview
- View dashboard

ADMIN

- Manage users
- View analytics
- Manage system configuration

---

# 4. Password Policy

- Minimum 8 characters
- At least one uppercase letter
- At least one lowercase letter
- At least one digit
- At least one special character

Passwords are stored using BCrypt.

---

# 5. API Security

- HTTPS only
- JWT Authentication
- Input Validation
- Global Exception Handling
- CORS Configuration

---

# 6. Data Security

Sensitive Data

- Passwords (BCrypt)
- Refresh Tokens
- Email Verification Tokens

Resume files will be stored securely in AWS S3.

---

# 7. Security Headers

The application will configure:

- Content Security Policy
- X-Content-Type-Options
- X-Frame-Options
- Referrer Policy

---

# 8. Audit Logging

Security events logged:

- Login
- Logout
- Password Reset
- Resume Upload
- Failed Authentication
- Admin Actions

---

# 9. Future Improvements

- OAuth2 (Google Login)
- Multi-Factor Authentication (MFA)
- Rate Limiting
- IP-based Login Detection
- Device Management