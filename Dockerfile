FROM maven:3.9.8-openjdk-21 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21-slim
COPY --from=build /target/project-1.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","project.jar"]