FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk17-jdk -y
COPY . .

RUN apt-get install maven ý
RUN mvn clean install

FROM openjdk:17-jdk-slim

EXPOSE 8080

COPY --from=build /target/cyberwatch-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]