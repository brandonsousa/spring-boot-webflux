# spring-boot-webflux
Reactive application with springboot webflux

## To run
This application can be run via docker-compose.
```bash
    docker-compose up -d
```


## Swagger
```bash
    http://localhost:8080/webjars/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config
```

### Dependencies and tools
This project uses the following dependencies and tools:
 - [Spring Boot 2.6.3](https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.6.3&packaging=jar&jvmVersion=17&groupId=io.github.brandonsousa&artifactId=spring-boot-webflux&name=spring-boot-webflux&description=Reactive%20application%20with%20springboot%20webflux&packageName=io.github.brandonsousa.spring-boot-webflux&dependencies=webflux,data-mongodb-reactive,lombok)
 - [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
 - [Maven 3.8.4](https://maven.apache.org/download.cgi#:~:text=Apache%20Maven%203.8.4%20is,recommended%20version%20for%20all%20users.)
 - [Lombok](https://projectlombok.org/setup/maven)
 - [ReactiveMongo](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-mongodb-reactive)
 - [Springboot webflux](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-webflux)
 - [Reactor test](https://projectreactor.io/docs/core/release/reference/)
 - [Docker](https://www.docker.com/products/docker-desktop)
 - [Jaxb API 2.3.1](https://mvnrepository.com/artifact/javax.xml.bind/jaxb-api/2.3.1)
 - [Javax Servlet 2.5](https://mvnrepository.com/artifact/javax.servlet/servlet-api/2.5)
