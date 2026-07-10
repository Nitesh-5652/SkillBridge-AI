# Database Design

# SkillBridge AI

---

# 1. Database Overview

SkillBridge AI uses **PostgreSQL** as the primary relational database.

PostgreSQL is selected because it provides:

- ACID Transactions
- Excellent indexing
- JSONB support
- Full Text Search
- High performance
- Enterprise reliability

---

# 2. Database Strategy

The application stores two types of data.

## Structured Data

- Users
- Roles
- Profiles
- Skills
- Education
- Experience
- Resume Metadata
- ATS Reports
- Interview Sessions

---

## Semi-Structured Data (JSONB)

Stored using PostgreSQL JSONB.

- Parsed Resume
- AI Resume Summary
- AI Feedback
- Prompt Logs
- Chat History

---

# 3. Naming Convention

Tables

snake_case

Columns

snake_case

Primary Keys

UUID

Foreign Keys

UUID

---

# 4. Audit Columns

Every table contains:

- id
- created_at
- updated_at
- created_by
- updated_by