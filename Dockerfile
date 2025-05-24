FROM ubuntu:latest
LABEL authors="tanma"

ENTRYPOINT ["top", "-b"]

# Use an official Java runtime as a parent image
FROM openjdk:21

# Set the working directory
WORKDIR /app

# Copy the jar file to the container
COPY target/*.jar webServer-0.0.1-SNAPSHOT.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "webServer-0.0.1-SNAPSHOT.jar"]