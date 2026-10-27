# Use the following as base image
# FROM eclipse-temurin:25-jdk-jammy
FROM bellsoft/liberica-openjdk-alpine:25

# Set a working directory
WORKDIR /app

# Copy project files
COPY --chmod=0755 ./mvnw ./mvnw
COPY .mvn/ .mvn/
COPY pom.xml .
COPY src/ src/

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose port `8080`
EXPOSE 8080

# ENV ARTIFACT_ID=spring-boot-docker-mysql
# ENV VERSION=0.0.1-SNAPSHOT

# Run the application
# CMD ["sh", "-c", "java", "-jar", "target/${ARTIFACT_ID}-${VERSION}.jar"]
CMD ["java", "-jar", "target/spring-boot-docker-mysql-0.0.1-SNAPSHOT.jar"]
