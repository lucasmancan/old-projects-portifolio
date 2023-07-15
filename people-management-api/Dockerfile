FROM openjdk:11-jre-slim
MAINTAINER lucasmancan
VOLUME /tmp
EXPOSE 8080
ADD target/digisystem-api-1.0.0.jar digisystem-api.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/digisystem-api.jar"]