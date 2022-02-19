FROM openjdk:17-alpine

WORKDIR /app

COPY target/spring-boot-webflux-*-SNAPSHOT.jar /app/spring-boot-webflux-app.jar

ENTRYPOINT ["java","-jar","spring-boot-webflux-app.jar"]