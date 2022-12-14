FROM docker.io/library/eclipse-temurin:17.0.5_8-jre-jammy
COPY target/aws-sample-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]