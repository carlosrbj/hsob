#FROM openjdk:8-jdk-alpine
#COPY target/hsob-0.0.1-SNAPSHOT.jar hsob-0.0.1-SNAPSHOT.jar
#ENTRYPOINT ["java","-jar","/hsob-0.0.1-SNAPSHOT.jar"]
#
#WORKDIR /hsob
#COPY . .
#ARG PORT_BUILD=6000
#EXPOSE $PORT_BUILD
#ENV PORT=$PORT_BUILD