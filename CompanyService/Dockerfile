FROM openjdk:22-jdk-slim

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} companyservice.jar

ENTRYPOINT ["java", "-jar", "/companyservice.jar"]

EXPOSE 8761