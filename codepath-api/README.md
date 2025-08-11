# CodePath API

A Duolingo-inspired web application for programming interview preparation, initially focused on Java fundamentals. The app features gamified, bite-sized lessons with progress tracking to make technical interview prep more engaging and structured.

## Project Overview

**Tech Stack:**
- Frontend: React (web-first, mobile later)
- Backend: Spring Boot with Java 21
- Database: H2 for development, PostgreSQL/MySQL for production
- Architecture: REST API with standard MVC pattern

**Current Phase:** MVP development

**Core Features:** 
- Interactive Java questions (multiple choice, fill-in-blank, code comprehension)
- User progress tracking
- Lesson progression with gamification elements

## Data Model

### Entity Overview

**User** - The learner using the platform. Stores auth info (username, email, password) plus gamification data (XP, streaks, activity tracking).

**Lesson** - A learning module/chapter (e.g., "Java Variables"). Contains title, description, difficulty level, and defines the order in the curriculum with prerequisites.

**Question** - Individual quiz items within lessons. Supports 3 types: multiple choice, fill-in-blank, and code comprehension. Stores the question content, correct answer, and explanation.

**Answer** - User's response to a specific question. Tracks what they answered, whether it was correct, attempt number, time spent, and points earned.

**UserProgress** - Tracks user's advancement through each lesson. Records completion status, score, accuracy stats, and time spent per lesson.

**Enums:**
- `QuestionType` - The 3 question formats supported
- `DifficultyLevel` - Beginner/Intermediate/Advanced lesson classification  
- `ProgressStatus` - Not started/In progress/Completed/Mastered lesson states

**Flow:** Users progress through ordered Lessons, answer Questions, store Answers, and track overall UserProgress with gamification elements.

## Getting Started

### Prerequisites
- Java 21
- Maven 3.6+

### Running the Application

```bash
# Run the application
./mvnw spring-boot:run

# Build the project
./mvnw clean package

# Run tests
./mvnw test
```

### Database Access
- H2 Console: http://localhost:8080/h2-console
- JDBC URL: `jdbc:h2:mem:testdb`
- Username: `sa`
- Password: `password`

## MVP Scope

Straightforward questions only, no complex code execution or AI integration initially. Focus on core learning mechanics and user experience validation.

## Development Notes

* The original package name 'com.roberteftene.codepath.codepath-api' is invalid and this project uses 'com.roberteftene.codepath.codepath_api' instead.