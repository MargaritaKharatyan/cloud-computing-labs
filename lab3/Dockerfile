# Этап 1: Сборка проекта через Gradle
FROM gradle:8.5-jdk17 AS builder
WORKDIR /app
COPY . .
RUN gradle buildFatJar --no-daemon

# Этап 2: Запуск готового jar-файла в легком контейнере Java
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=builder /app/build/libs/*-all.jar app.jar
EXPOSE 5000
ENTRYPOINT ["java", "-jar", "app.jar"]
