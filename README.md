## 💻 Project

What happens when communication between your REST APIs fails?

There is a pattern called Circuit Breaker that helps with these issues.
This small project implements this pattern with the Resilience4j library in a Spring Boot project.

## ✨ Technologies

- [Resilience4j](https://resilience4j.readme.io/docs/circuitbreaker): comes with an in-memory CircuitBreakerRegistry
  based on a ConcurrentHashMap which provides thread safety and atomicity guarantees.
- [Spring boot](https://spring.io/projects/spring-boot): Makes it easy to create stand-alone, production-grade Spring
  based Applications that you can "just run".

## 🚀 How to execute

```shell
# Runing product
cd product
mvn spring-boot:run

# Runing review
cd review
mvn spring-boot:run
```

## ✨ How to use

### Product endpoints

- get all:

```shell
curl --location --request GET 'http://localhost:8801/products'
```

- get by id:

```shell
curl --location --request GET 'http://localhost:8801/products/1'
```

### Review endpoints

- get by product id:

```shell
curl --location --request GET 'http://localhost:8802/reviews/1'
```
