FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

CMD ["java", "-jar", "-Dserver.port=8080", "employee-app-jar-with-dependencies.jar"]

EXPOSE 8080