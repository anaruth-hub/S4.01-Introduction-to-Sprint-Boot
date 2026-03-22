# 🚀 S4.01 - Introduction to Spring Boot

<p align="center">
  <strong>REST API for User Management</strong><br>
  Built with Spring Boot · Java 21 · Maven
</p>

---

## 📌 Description

This project is part of the IT Academy Backend Java Bootcamp.  
It consists of building a REST API using **Spring Boot**, applying best practices in backend development.

The application allows managing users with basic CRUD operations, filtering, validation, and testing.

---

## 🧠 Learning Objectives

- Understand Spring Boot architecture
- Build REST APIs
- Apply layered architecture (Controller, Service, Repository)
- Implement unit and integration tests
- Handle errors and validations
- Use Maven for build lifecycle
- Generate executable `.jar`

---

## 🧩 Project Structure
src
┣ main
┃ ┣ java/cat/itacademy/s04/t01/userapi
┃ ┃ ┣ controllers
┃ ┃ ┣ services
┃ ┃ ┣ repositories
┃ ┃ ┣ models
┃ ┃ ┣ dto
┃ ┃ ┗ exceptions
┃ ┗ resources
┃ ┗ application.properties
┗ test
┗ java/cat/itacademy/s04/t01/userapi

---

## ⚙️ Technologies

- ☕ Java 21
- 🌱 Spring Boot 3
- 📦 Maven
- 🧪 JUnit & MockMvc
- 📬 Postman (manual testing)

---

## ▶️ How to Run the Project

### 1. Compile and package

```bash
mvn clean package
2. Run the application
java -jar target/userapi-0.0.1-SNAPSHOT.jar
3. Server
http://localhost:9000
🔍 API Endpoints
✅ Health Check
GET /health

Response:

{
  "status": "OK"
}
👤 Get all users
GET /users
➕ Create user
POST /users

Body:

{
  "name": "Ada Lovelace",
  "email": "ada@example.com"
}
🔎 Get user by ID
GET /users/{id}
🔍 Filter users by name
GET /users?name=ada
❌ Duplicate email

Returns:

409 Conflict
🧪 Testing

Tests implemented using:

Unit tests (Service layer)
Integration tests (Controller with MockMvc)

Run tests:

mvn test
📬 Postman Testing

Manual tests were executed using Postman:

GET /health
GET /users
POST /users
GET /users/{id}
GET /users?name=...
Duplicate email validation
📦 Build Result

Executable file generated:

target/userapi-0.0.1-SNAPSHOT.jar
🧱 Architecture

Layered architecture:

Controller → Handles HTTP requests
Service → Business logic
Repository → Data storage (in-memory)
DTO → Data transfer
Exception handling → Custom errors
💡 Highlights
Clean and structured code
RESTful API design
Input validation
Error handling
Test coverage
Executable application
👩‍💻 Author
<p align="center"> <strong>Ana Ruth</strong><br> Java Backend Developer in progress 💛 </p>
🌟 Final Note
This project represents a key step in my journey as a backend developer, combining discipline, consistency, and continuous learning.