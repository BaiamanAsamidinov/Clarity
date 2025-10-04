🔍 Clarity: A Foundational Spring Boot Project
Project Overview
Clarity is the foundational project for Phase 1 of the Coursera-style curriculum, focusing on establishing a robust development environment. This project demonstrates core Java/Spring principles, including layered architecture, version control (Git), and initial data persistence using JPA and the H2 in-memory database.

Phase 1: Foundation & Setup
This repository specifically encapsulates the work for Week 2: Version Control, Project Structure, and Initial Database Integration.

Component	Status	Description
Version Control	✅ Configured	Managed via Git, linked to a remote repository, with a functional .gitignore.
Project Structure	✅ Layered	Utilizes the standard controller, service, repository, and model packages.
Database	✅ H2 Configured	Uses the H2 in-memory database for ephemeral development data.
Data Persistence	✅ JPA Entity	Includes the base User entity and its corresponding UserRepository.

Eksportuj do Arkuszy
⚙️ Setup and Prerequisites
To run this project, you'll need the following installed on your system:

Java Development Kit (JDK) 17+

Apache Maven (or Gradle, depending on the build tool used)

Git

1. Cloning the Repository
Clone this project to your local machine:

Bash

git clone <your-remote-repo-url>
cd Clarity
2. Building the Project
Use Maven to clean and build the project. This command downloads dependencies and compiles the source code:

Bash

# Using Maven
mvn clean install
3. Running the Application
Execute the main Spring Boot application class.

Bash

# Option 1: Using the maven spring-boot plugin
mvn spring-boot:run

# Option 2: Running the compiled JAR file (after mvn clean install)
java -jar target/clarity-0.0.1-SNAPSHOT.jar # Adjust version as needed
The application will typically start on port 8080.

🚀 Usage and Development
Accessing the H2 Database Console
Since Clarity is configured with the H2 in-memory database and the console is enabled, you can inspect the database state during development.

Start the application (see Running the Application above).

Open your web browser and navigate to:

http://localhost:8080/h2-console
Connection Settings:

JDBC URL: jdbc:h2:mem:testdb

User Name: sa

Password: password

Click Connect. You will see the tables created by JPA (e.g., the USER table).

Key Architectural Components
The following files and directories are critical to this phase's deliverables:

Location	Component	Role
src/main/resources/application.properties	H2 Config	Defines the database URL and enables the H2 console.
com.clarity.model.User	JPA Entity	Defines the foundational data structure (id, username, passwordHash).
com.clarity.repository.UserRepository	Data Repository	Extends JpaRepository to provide CRUD operations for the User entity.
.gitignore	Version Control	Ensures build artifacts (/target/) and sensitive files are untracked.
