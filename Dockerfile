# Base Alpine Linux based image with OpenJDK JRE only
FROM gradle:8.1.0-jdk17
EXPOSE 8081
COPY build/libs/ms-integration-0.0.1-SNAPSHOT.jar /ms-integration.jar
# specify default command
CMD ["java", "-jar", "-Dspring.profiles.active=test", "/ms-integration.jar"]
