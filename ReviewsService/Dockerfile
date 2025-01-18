FROM openjdk:22-jdk-slim

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} reviewsservice.jar

ENTRYPOINT ["java", "-jar", "/reviewsservice.jar"]

EXPOSE 8761