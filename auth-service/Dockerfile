# Stage 1: Build the application
FROM jelastic/maven:3.9.5-openjdk-21 AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml and the source code
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/*.jar auth-service.jar

# Expose the application port (change as needed)
EXPOSE 9898

# Run the application
ENTRYPOINT ["java", "-jar", "auth-service.jar"]
