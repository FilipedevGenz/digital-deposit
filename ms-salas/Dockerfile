FROM maven:3.8.4-eclipse-temurin-21 AS build
COPY src /app/src
COPY pom.xml /app

WORKDIR /app
RUN mvn clean install

COPY --from=buil /app/target/spring