FROM openjdk:8-jre-alpine

LABEL maintainer="luis.chan@gzand-c.com"

ENV JAR_FILE=@project.build.finalName@.@project.packaging@

WORKDIR /app

ADD $JAR_FILE .

EXPOSE 8080

ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom -jar $JAR_FILE