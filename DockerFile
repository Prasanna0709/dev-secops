FROM eclipse-temurin:17-jdk-alpine

COPY target/swagger-docs-0.0.1-SNAPSHOT.jar swagger.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","swagger.jar"]