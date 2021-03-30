# Kotlin Spring Boot R2DBC H2 + Redis

ตัวอย่าง Kotlin Spring Reactive, Spring Data R2DBC, R2DBC H2, Redis Reactive

## Getting Started

`./mvnw spring-boot:run`, the application now runs localhost:8080.

## Getting Started Redis not working

`docker run -d \
-p 6379:6379 \
--name redis-server \
--restart=always \
redis:6.2.1-alpine3.13 \
--requirepass flau1gith-MOOB3grud`

`redis-cli -h 127.0.0.1 -p 6379 -a flau1gith-MOOB3grud`


## Docs
https://docs.spring.io/spring-data/data-redis/docs/current/reference/html/#redis:reactive

https://redis.io/commands