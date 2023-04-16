FROM eclipse-temurin:17-jdk-focal
 
WORKDIR /app

EXPOSE 80/tcp
 
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
 
COPY src ./src
 
CMD ["./mvnw", "spring-boot:run"]