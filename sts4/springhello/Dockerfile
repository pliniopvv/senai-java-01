#		sudo docker build -t pvv/springhello:0.0.1 .
#		sudo docker login
#		sudo docker tag springhello:latest pliniopvv/springhello:first
#		sudo docker push pliniopvv/springhello:first

#FROM maven:3.8.6-openjdk-11
FROM openjdk:21-slim-buster

#COPY . . 
#RUN mvn package spring-boot:repackage
#CMD ["java", "-jar", "target/springhello-0.0.1-SNAPSHOT.jar"]

COPY target/*.jar app.jar

ENV SERVER_PORT=8081

EXPOSE 8081

ENTRYPOINT [ "java", "-jar", "app.jar" ]
