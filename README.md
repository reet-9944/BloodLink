# BloodLink – Smart Blood Availability & Emergency Donor Matching System

## Project Overview

**BloodLink** is a Java-based application designed to manage blood donor information and efficiently match available donors during emergency blood requests.
The system enables hospitals or administrators to quickly locate suitable donors based on blood group and availability, helping reduce response time during critical medical situations.

The project demonstrates practical implementation of **database connectivity, structured application design, and efficient query handling using Java and MySQL.**

---

## Key Features

* Donor registration and record management
* Emergency blood request processing
* Fast donor search based on blood group
* MySQL database integration for data storage
* Structured DAO architecture for database operations
* Input validation and exception handling
* Optimized SQL queries for quick donor identification

---

## Tech Stack

| Technology     | Purpose                     |
| -------------- | --------------------------- |
| Java           | Core application logic      |
| MySQL          | Database management         |
| SQL            | Data querying and filtering |
| IntelliJ IDEA  | Development environment     |
| CLI (Terminal) | Application execution       |

---

## System Architecture

The application follows a simple layered architecture:

```
BloodLink
│
├── src
│   └── main
│       └── java
│           └── com.bloodlink
│               ├── app
│               │   └── Main.java
│               │
│               ├── dao
│               │   ├── BloodBankDAO.java
│               │   ├── DonorDAO.java
│               │   ├── RequestDAO.java
│               │   └── StockDAO.java
│               │   
│               ├── model
│               │   ├── BloodBank.java
│               │   ├── BloodRequest.java
│               │   └── Donor.java
│               │ 
│               ├── service
│               │   └── MatchingService.java
│               │ 
│               └── utils
│                   └── DBConnection.java
│
├── out
└── README.md
```

---

## How the System Works

1. Donor details are stored and managed within a MySQL database.
2. When an emergency request is created, the system searches for matching donors.
3. SQL queries filter donors based on blood group and availability.
4. Matching donors are returned quickly for immediate contact.

---

## Installation and Setup

### 1. Clone the Repository

```
git clone https://github.com/reet-9944/BloodLink.git
```

### 2. Navigate to Project Directory

```
cd BloodLink
```

### 3. Configure Database

1. Install MySQL Server.
2. Create a new database for the project.
3. Update database credentials in `DBConnection.java`.

Example:

```
String url = "jdbc:mysql://localhost:3306/bloodlink";
String username = "YOUR_DB_USERNAME";
String password = "YOUR_DB_PASSWORD";
```

### 4. Run the Application

Open the project in **IntelliJ IDEA** and run:

```
Main.java
```

---

## Future Enhancements

* Web-based dashboard for hospitals
* Real-time donor notification system
* Integration with hospital blood bank databases
* Mobile application for donor registration
* Location-based donor matching

---

## Learning Outcomes

This project helped strengthen understanding of:

* Java application development
* JDBC database connectivity
* DAO design pattern
* SQL query optimization
* Structured backend project architecture

---

##  Developer

**Reetu Rani**

Computer Science Student

Passionate about building systems that solve real-world problems using software.

---
