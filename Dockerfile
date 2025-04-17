# Step 1: Use Amazon Corretto 17 JDK for building the application
FROM amazoncorretto:17-alpine AS builder
WORKDIR /app

# Copy Gradle wrapper and config files
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

# Download dependencies (uses caching to avoid re-downloading on each build)
RUN ./gradlew build -x test || return 0

# Copy the rest of the application code
COPY src src

# Build the application (skipping tests to save time)
RUN ./gradlew bootJar -x test

# Step 2: Use Amazon Corretto 17 JRE for the final image
FROM amazoncorretto:17-alpine
WORKDIR /app

# Copy the JAR from the build stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Expose application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
