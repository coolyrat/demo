FROM registry.cn-hangzhou.aliyuncs.com/acs/maven:3-jdk-8 as build

ENV MY_HOME=/usr/src/app
RUN mkdir -p $MY_HOME
WORKDIR $MY_HOME
ADD pom.xml $MY_HOME

# get all the downloads out of the way
RUN ["/usr/local/bin/mvn-entrypoint.sh","mvn","verify","clean","--fail-never"]

# add source
ADD . $MY_HOME

# run maven verify
RUN ["/usr/local/bin/mvn-entrypoint.sh","mvn","verify"]

FROM openjdk:8-jre-alpine

WORKDIR /app
COPY --from=build /usr/src/app/target/rancher-test.jar .
EXPOSE 8080
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom -jar rancher-test.jar
