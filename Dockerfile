# # Use Java 21 (matches your local JDK)
# FROM eclipse-temurin:21-jdk
#
# # Set working directory
# WORKDIR /app
#
# # Copy jar file
# COPY target/*.jar app.jar
#
# # Expose port (Spring Boot default)
# EXPOSE 8080
#
# # Run the app
# ENTRYPOINT ["java", "-jar", "app.jar"]



# -------- BUILD STAGE --------
FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests


# -------- RUN STAGE --------
FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
