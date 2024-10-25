# Stage 1: Build the application
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM openjdk:17.0.1-jdk-slim
WORKDIR /app
COPY --from=build /app/target/To-Do-Application-0.0.1-SNAPSHOT.jar To-Do-Application.jar

EXPOSE 8080
CMD ["java", "-jar", "To-Do-Application.jar"]
