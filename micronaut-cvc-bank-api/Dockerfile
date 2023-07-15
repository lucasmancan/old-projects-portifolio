FROM adoptopenjdk/openjdk11-openj9:alpine-slim
ARG JAR_FILE=target/cvc-bank-api-0.1.jar
COPY ${JAR_FILE} application.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","-Xms512m","-Xmx2048m","-XX:+UseG1GC",  "-Xss512k","-XX:+UnlockExperimentalVMOptions", "/application.jar"]
