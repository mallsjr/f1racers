# Use an official OpenJDK image as a base image
FROM openjdk:21-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the build files to the container
COPY build/libs/f1racers-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 to the outside world
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
