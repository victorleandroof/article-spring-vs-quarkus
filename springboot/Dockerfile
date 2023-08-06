FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY target/demo-*.jar app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=dev", "-jar", "/app.jar"]