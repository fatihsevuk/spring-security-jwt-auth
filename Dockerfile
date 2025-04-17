# Step 1: Use Amazon Corretto 17 JDK for building the application
FROM amazoncorretto:17-alpine AS builder
WORKDIR /app

# Copy Maven wrapper and project files
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Download dependencies (layer caching for faster rebuilds)
RUN ./mvnw clean install -DskipTests

# Copy the source code
COPY src src

# Build the application (skipping tests to save time)
RUN ./mvnw clean package -DskipTests

# Step 2: Use Amazon Corretto 17 JRE for the final image
FROM amazoncorretto:17-alpine
WORKDIR /app

# Copy the packaged application from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]