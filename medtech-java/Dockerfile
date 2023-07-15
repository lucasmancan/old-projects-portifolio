FROM adoptopenjdk/openjdk11:alpine-jre

ARG JAR_FILE=target/medtech-backoffice-1.0.0.jar
COPY ${JAR_FILE} app.jar

ARG JDBC_DATABASE_PASSWORD=073210b4f2c1185bf9870573183d806274177100a2877e5e04ff2578feb8ff75
ARG JDBC_DATABASE_URL=jdbc:postgresql://ec2-54-146-4-66.compute-1.amazonaws.com:5432/dad41j1d8vfm7o
ARG JDBC_DATABASE_USERNAME=qrtzenblkevlsl
ARG PORT=8080
#assign the $RAILS_ENV arg to the RAILS_ENV ENV so that it can be accessed
#by the subsequent RUN call within the container
ENV JDBC_DATABASE_PASSWORD $JDBC_DATABASE_PASSWORD
ENV JDBC_DATABASE_URL $JDBC_DATABASE_URL
ENV JDBC_DATABASE_USERNAME $JDBC_DATABASE_USERNAME
ENV PORT $PORT


EXPOSE $PORT
ENTRYPOINT ["java","-jar", "-Xss512k", "/app.jar", " -Dspring.profiles.active=dev"]
