# Football Manager App

## Project Overview 📝
Welcome to the Football Manager App!  
This application is designed to manage football teams, players, and transfers. Users can view team details, player statistics, and manage player transfers between teams.

## Technologies Used 🧑🏻‍💻

- **Spring Boot** - Backend framework for building the core application. Version - 3.3.5
- **Spring Data JPA** - For database interaction and ORM. Version - 3.3.5
- **H2 Database** - In-memory database for development and testing purposes. Version - 2.1.214
- **Swagger** - API documentation and testing. Version - 2.1.0
- **MapStruct** - Object mapping for DTOs and entities. Version - 1.5.5.Final

## Key Functionalities 🔑

### 📌 User Features

- **Team Management**: Users can view a list of football teams with details such as team name, and account balance and so on.
- **Player Management**: Users can view player details, including name, age, and team.
- **Transfer Management**: Users can transfer players between teams, considering the transfer cost and team budgets.

## Structure of DB 📁

### ER-diagram of database tables
`football_manager_db`

### Relations between entities
- **Player - Team**: ManyToOne

## How to Run the Project 🚀

### Prerequisites
- Java 17 or higher
- Maven for dependency management

### Steps to Launch Application

1. **Clone the repository**

    ```bash
    git clone git@github.com:your-username/football-manager-app.git
    cd football-manager-app
    ```

2. **Run the application**

    Use the following command to start the application:

    ```bash
    mvn spring-boot:run
    ```

3. **Access the application**

    The application will be accessible at `http://localhost:8080/`.

