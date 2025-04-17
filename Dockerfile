# Start with a lightweight base image with Java
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Add the app jar (change name accordingly)
COPY target/spring.start-0.0.1-SNAPSHOT.jar app.jar

# Expose app port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
