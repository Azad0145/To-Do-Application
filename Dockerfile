FROM maven:3.8.5-openjdk-17 AS build
COPY ..
FROM mvn clean package DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build target/To-Do-Application-0.0.1-SNAPSHOT.jar

EXPOSE 8080
# Command to run the application
CMD ["java", "-jar", "To-Do-Application.jar"]
