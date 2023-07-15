docker kill medtech-api
docker rm medtech-api

mvn clean install -DskipTests
docker build -t medtech-java .
docker run -p 8080:8080 --name medtech-api medtech-java
