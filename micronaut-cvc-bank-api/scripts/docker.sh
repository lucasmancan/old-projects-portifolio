docker kill cvc-micronaut
docker rm cvc-micronaut

mvn clean install -DskipTests
docker build -t cvc-micronaut .
docker run -p 8080:8080 --name cvc-micronaut cvc-micronaut