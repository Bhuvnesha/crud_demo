# Student Management System (Core Java CRUD)

A simple **Student Management System** built using **Core Java, JSP, Servlets, JDBC, Maven, MySQL, and Apache Tomcat**. This project demonstrates the complete CRUD (Create, Read, Update, Delete) operations following the MVC (Model-View-Controller) architecture.

---

# Project Overview

This application allows users to:

- Add a new student
- View all students
- Update student information
- Delete a student

The project was created to understand how Java web applications work internally before learning Spring Boot.

---

# Technologies Used

| Technology | Version |
|------------|---------|
| Java | 25 LTS |
| Maven | 3.9.x |
| JSP | Jakarta JSP |
| Servlet | Jakarta Servlet 6 |
| JDBC | MySQL Connector/J |
| MySQL | 8.x |
| Apache Tomcat | 10.1.x |
| IntelliJ IDEA | Ultimate |
| Build Tool | Maven |

---

# Project Architecture

```
Browser
    │
    ▼
JSP (View)
    │
    ▼
Servlet (Controller)
    │
    ▼
StudentDAO
    │
    ▼
JDBC
    │
    ▼
MySQL Database
```

The application follows the MVC (Model-View-Controller) pattern.

- **Model**
    - Student.java

- **View**
    - add.jsp
    - list.jsp
    - edit.jsp

- **Controller**
    - StudentServlet
    - EditServlet
    - DeleteServlet

- **DAO**
    - StudentDAO

- **Utility**
    - DBConnection

---

# Project Structure

```
crud_demo
│
├── src
│   └── main
│       ├── java
│       │
│       ├── com.student.model
│       │      Student.java
│       │
│       ├── com.student.dao
│       │      StudentDAO.java
│       │
│       ├── com.student.servlet
│       │      StudentServlet.java
│       │      EditServlet.java
│       │      DeleteServlet.java
│       │
│       └── com.student.util
│              DBConnection.java
│
├── webapp
│      add.jsp
│      list.jsp
│      edit.jsp
│      index.jsp
│
├── pom.xml
│
└── target
       crud_demo.war
```

---

# Database Schema

Database

```sql
CREATE DATABASE studentdb;
```

Table

```sql
CREATE TABLE students
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100),
    course VARCHAR(100)
);
```

---

# Maven Dependencies

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.4.0</version>
</dependency>

<dependency>
    <groupId>jakarta.servlet</groupId>
    <artifactId>jakarta.servlet-api</artifactId>
    <version>6.0.0</version>
    <scope>provided</scope>
</dependency>
```

---

# Features

## Create Student

- User opens `add.jsp`
- Fills student details
- Form submits to `StudentServlet`
- `StudentDAO.insertStudent()` inserts the record into MySQL
- User is redirected to the student list

---

## Read Students

- Browser requests `/student`
- `StudentServlet.doGet()` is executed
- `StudentDAO.getAllStudents()` fetches records
- Records are forwarded to `list.jsp`
- JSP displays all students in an HTML table

---

## Update Student

- User clicks **Edit**
- Browser sends:

```
GET /edit?id=1
```

- `EditServlet.doGet()` fetches the selected student
- Student data is displayed in `edit.jsp`
- User updates information
- Form submits to:

```
POST /edit
```

- `StudentDAO.updateStudent()` updates the record
- User is redirected to the student list

---

## Delete Student

- User clicks **Delete**
- Browser sends

```
GET /delete?id=1
```

- `DeleteServlet`
- `StudentDAO.deleteStudent()`
- Record deleted
- Redirects back to the student list

---

# Request Flow

## Add Student

```
Browser

↓

add.jsp

↓

StudentServlet

↓

StudentDAO

↓

MySQL

↓

Redirect

↓

Student List
```

---

## Display Students

```
Browser

↓

StudentServlet

↓

StudentDAO

↓

Database

↓

list.jsp

↓

Browser
```

---

## Update Student

```
Browser

↓

EditServlet

↓

StudentDAO

↓

Database

↓

edit.jsp

↓

Browser

↓

Submit

↓

EditServlet

↓

StudentDAO.updateStudent()

↓

Database

↓

Student List
```

---

## Delete Student

```
Browser

↓

DeleteServlet

↓

StudentDAO.deleteStudent()

↓

Database

↓

Student List
```

---

# Build the Project

Compile the project

```bash
mvn clean compile
```

Create WAR

```bash
mvn clean package
```

Generated file

```
target/crud_demo.war
```

---

# Run using IntelliJ + Tomcat

1. Open the project in IntelliJ IDEA.
2. Configure Apache Tomcat.
3. Deploy the `crud_demo:war exploded` artifact.
4. Start Tomcat.
5. Open:

```
http://localhost:8080/crud_demo_war_exploded/student
```

or

```
http://localhost:8080/crud_demo/student
```

depending on the configured application context.

---

# Run using Standalone Tomcat

Copy the WAR

```bash
cp target/crud_demo.war ~/Downloads/apache-tomcat-10.1.57/webapps/
```

Start Tomcat

```bash
cd ~/Downloads/apache-tomcat-10.1.57/bin

./startup.sh
```

Application URL

```
http://localhost:8080/crud_demo/student
```

---

# Useful Maven Commands

Compile

```bash
mvn compile
```

Clean

```bash
mvn clean
```

Package

```bash
mvn package
```

Compile + Package

```bash
mvn clean package
```

Skip Tests

```bash
mvn clean package -DskipTests
```

---

# Screens

- Add Student
- Student List
- Edit Student
- Delete Confirmation

(Add screenshots here)

---

# Learning Outcomes

This project helped in understanding:

- Core Java
- Object-Oriented Programming (OOP)
- JDBC
- MySQL Integration
- Maven
- JSP
- Servlets
- Apache Tomcat
- MVC Architecture
- HTTP Request/Response Lifecycle
- GET and POST Requests
- Request Forward vs Redirect
- Form Handling
- PreparedStatement
- ResultSet
- CRUD Operations
- Java Web Application Deployment

---

# Future Improvements

- Login Authentication
- Session Management
- Search Students
- Pagination
- Input Validation
- Bootstrap UI
- JSTL and Expression Language (EL)
- Exception Handling
- Logging Framework (SLF4J + Logback)
- Connection Pooling
- Spring Boot Migration
- REST APIs
- Hibernate/JPA Integration

---

# Author

**Bhuvanesh**

Senior PHP Developer learning Java Full Stack Development.

---

# License

This project is created for learning purposes and can be freely used, modified, and extended.