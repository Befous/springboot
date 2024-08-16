FROM openjdk:21
WORKDIR /app
RUN mvn clean package
COPY ./target/project-1.jar /app
EXPOSE 8080
CMD ["java", "-jar", "project-1.jar"]