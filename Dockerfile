FROM maven:3.8.8-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml .

# Download all dependencies
RUN mvn dependency:go-offline -B  

COPY src ./src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY --from=build /app/target/Samir_wep_App-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]

