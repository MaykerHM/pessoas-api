FROM maven:3.8.5-eclipse-temurin-17-alpine AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17
WORKDIR /app
COPY --from=build /target/pessoas.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]