# JWT Authentication Demo with Spring Boot

A basic demonstration of how to implement **JWT Bearer Token Authentication** using **Spring Security** and **Java**. This project serves as a solid foundation for building secure RESTful APIs in a Spring Boot environment, complete with JPA, Thymeleaf, Actuator, and more.

## 🔧 Tech Stack & Key Dependencies

| Dependency           | Version     |
|----------------------|-------------|
| Java                 | 17          |
| Spring Boot          | 3.4.4       |
| Spring Security      | 3.4.4 (via starter) |
| Lombok               | Latest via Gradle |
| MySQL Connector/J    | 8.0.33      |
| JJWT (JWT Library)   | 0.12.5      |
| ModelMapper          | 3.2.0       |
| Apache Commons Text  | 1.11.0      |
| Guava                | 19.0        |
| JSON (org.json)      | 20240303    |

## 🚀 Getting Started

### Prerequisites

- Java 17
- Gradle
- Docker & Docker Compose

### Clone the Repository

```bash
git clone https://github.com/your-username/jwt-auth-spring-boot-demo.git
cd jwt-auth-spring-boot-demo

```

Running the App Locally
You can run the application using the Spring Boot Gradle plugin:

```bash

./gradlew bootRun

```

Or build it and run the JAR:

```bash

./gradlew build
java -jar build/libs/jwt-auth-spring-boot-demo-0.0.1-SNAPSHOT.jar


```

Docker Compose Setup
To spin up the project with Docker Compose, including external services like MySQL:

```bash
docker compose --profile dev up
```

⚙️ The --profile dev flag enables the dev profile for environment-specific configuration (e.g., dev database containers).

To shut everything down:

```bash
docker compose down
```

🔐 JWT Authentication Overview

* Login endpoint returns a signed JWT upon successful authentication.
* Subsequent requests must include the token in the Authorization: Bearer <token> header.
* Custom UserDetailsService and token validation filters included.
* Stateless authentication—no sessions.

🧪 Running Tests

```bash
./gradlew test

```

🛠️ Useful Gradle Tasks

```bash
./gradlew build #Builds the project

./gradlew test #Runs all tests

./gradlew bootRun #Runs the Spring Boot app

```

📬 Contact

Made with ❤️ by Fatih Sevük
Feel free to reach out for collaboration or feedback.
