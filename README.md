# Spring Boot R2DBC

This project aims to give an idea on how to work with the R2DBC and Spring Data R2DBC.

## Getting Started

`./mvnw spring-boot:run`, the application now runs localhost:8080.

## Getting Started Redis

`docker pull redis:6.2.1-alpine3.13`

`docker run --name redis -p 6379:6379 -d redis:6.2.1-alpine3.13 redis-server --appendonly yes`

## API

`http://localhost:8080/products`

`http://localhost:8080/products/1`