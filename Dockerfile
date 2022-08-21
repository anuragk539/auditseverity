FROM openjdk:8-jdk-alpine
ADD target/auditSeverity-0.0.1-SNAPSHOT.jar auditSeverity.jar
EXPOSE 8400
ENTRYPOINT ["java","-jar","/auditSeverity.jar"]