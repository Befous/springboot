# Tahap 1: Build
FROM ubuntu:latest AS build

# Update package list dan install OpenJDK 21
RUN apt-get update && apt-get install openjdk-21-jdk -y

# Salin semua file dari direktori kerja lokal ke dalam container
COPY . /app

# Set working directory di dalam container
WORKDIR /app

# Jalankan Maven untuk membuild project
RUN ./mvnw clean package -DskipTests

# Tahap 2: Run
FROM openjdk:21-jdk-slim

# Set port yang akan di-expose
EXPOSE 8080

# Salin file .jar hasil build dari tahap 1 ke tahap run
COPY --from=build /app/target/*.jar /app/app.jar

# Jalankan aplikasi
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
