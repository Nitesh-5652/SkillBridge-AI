Database Design
1. Database Overview
SkillBridge AI uses PostgreSQL as the primary relational database.
PostgreSQL is selected because it provides ACID transactions, excellent indexing, JSONB support, full text search, high performance, and enterprise reliability.

2. Database Strategy
The application stores two types of data.

Structured Data
Users

Roles

Profiles

Skills

Education

Experience

Resume Metadata

ATS Reports

Interview Sessions

Semi-Structured Data (JSONB)
Stored using PostgreSQL JSONB.

Parsed Resume

AI Resume Summary

AI Feedback

Prompt Logs

Chat History

3. Naming Convention
Tables: snake_case

Columns: snake_case

Primary Keys: UUID

Foreign Keys: UUID

4. Audit Columns
Every table contains:

id

created_at

updated_at

created_by

updated_by

5. Core Tables
Authentication
users

roles

user_roles

refresh_tokens

email_verification_tokens

password_reset_tokens

User Profile
user_profiles

education

experience

skills

social_links

Resume
resumes

resume_content (JSONB)

ATS
ats_reports

AI Interview
interview_sessions

interview_questions

interview_answers

ai_feedback (JSONB)

Notifications
notifications

6. Storage Strategy
Data	Storage
User Data	PostgreSQL
Resume Metadata	PostgreSQL
Resume Parsed JSON	PostgreSQL (JSONB)
ATS Report	PostgreSQL
AI Feedback	PostgreSQL (JSONB)
Chat History	PostgreSQL (JSONB)
7. Indexing Strategy
Indexes will be created on:

email

username

role_name

resume_id

user_id

interview_session_id

created_at

GIN indexes will be used for JSONB columns where appropriate.

8. Future Improvements
Full-Text Search

Table Partitioning

Read Replicas

Database Backup Strategy

Archival Policies

