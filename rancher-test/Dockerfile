FROM openjdk:8-jre-alpine

WORKDIR /app
COPY ./target/rancher-test.jar /usr/src/app/target/rancher-test.jar .
EXPOSE 8080
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom -jar rancher-test.jar
