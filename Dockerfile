# Use the following as base image
# FROM eclipse-temurin:25-jdk-jammy
FROM bellsoft/liberica-openjdk-alpine:25

# Set a working directory
WORKDIR /app

# Copy project files
COPY --chmod=0755 ./mvnw ./mvnw
COPY .mvn/ .mvn/
COPY pom.xml .

# Pre-download Maven dependencies to improve build caching
RUN ./mvnw dependency:resolve

COPY src/ src/

# Expose port `8080`
EXPOSE 8080

# Run the application
CMD ["./mvnw", "spring-boot:run"]
