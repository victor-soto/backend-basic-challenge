FROM adoptopenjdk/openjdk11:jdk-11.0.9.1_1-centos-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]