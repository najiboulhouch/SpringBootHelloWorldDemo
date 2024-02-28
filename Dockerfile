FROM openjdk:17
WORKDIR /app
COPY target/*.jar jenkins-integration.jar
ENTRYPOINT ["java", "-jar", "jenkins-integration.jar"]
