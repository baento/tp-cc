FROM maven:latest AS build
LABEL MAINTAINER="Antoine BALIEU"

WORKDIR /usr/src/app
COPY . /usr/src/app/

RUN mvn clean install spring-boot:repackage

FROM adoptopenjdk/openjdk11:alpine-jre

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

WORKDIR /opt/app

ARG JAR_FILE=/usr/src/app/target/*.jar
COPY --from=build ${JAR_FILE} app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]