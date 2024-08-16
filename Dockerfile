FROM ubuntu:latest AS buid
RUN apt-get update
RUN apt-get install openjdk-21-jdk -y
COPY . /app
RUN ./mvnw bootJar --no-deamon

FROM openjdk:21-jdk-slim
EXPOSE 8080
COPY --from=build /app/target/*.jar /app/app.jar

ENTRYPOINT ["java","-jar","/app.jar"]