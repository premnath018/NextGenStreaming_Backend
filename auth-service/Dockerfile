# Stage 1: Build the native binary with GraalVM
FROM vegardit/graalvm-maven:21.0.2 AS builder

# Invalidate cache with a dummy argument
ARG CACHEBUST=1

# Set working directory
WORKDIR /app

# Copy only the pom.xml and download dependencies first to cache Maven dependencies
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline -B

# Now copy the rest of the project files
COPY . .

# Build the native image
RUN mvn package -Pnative native:compile -DskipTests

# Stage 2: Create a minimal runtime image with Alpine Linux
FROM alpine:3.18

# Install GCC and necessary libraries for running the binary
RUN apk add --no-cache libc-dev gcompat

WORKDIR /app

# Copy the native binary from the builder stage
COPY --from=builder /app/target/auth_service /app/auth_service

# Expose the service port
EXPOSE 9898

# Run the native binary
ENTRYPOINT ["/app/auth_service"]
