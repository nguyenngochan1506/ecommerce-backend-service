FROM openjdk:17

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} ecommerce-backend-service.jar

ENTRYPOINT ["java","-jar","/ecommerce-backend-service.jar"]

EXPOSE 8080