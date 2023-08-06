
# Aritcle About Quarkus vs Springboot

## Pre req
* java 17.X.X
* k6 
* docker and docker-compose

## Install Deps


```bash
  cd ./quarkus && mvn clean install
  cd ./springboot && mvn clean install
```

## Build docker image


```bash
  make build-image
```

## Run on docker


```bash
  make run-with-docker
```
    
## Run k6 test

```bash
  k6 run k6-test.js
```

[Article: Quarkus vs. Spring Boot: A Batalha dos Frameworks Java](https://victorleandro.com.br/posts/springboot_vs_quarkus/)