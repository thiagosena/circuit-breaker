## 💻 Project

What happens when communication between your REST APIs fails?

There is a pattern called Circuit Breaker that helps with these issues.
This small project implements this pattern with the Resilience4j library in a Spring Boot project.

## ✨ Technologies

- [Resilience4j](https://resilience4j.readme.io/docs/circuitbreaker): comes with an in-memory CircuitBreakerRegistry
  based on a ConcurrentHashMap which provides thread safety and atomicity guarantees.
- [Spring boot](https://spring.io/projects/spring-boot): Makes it easy to create stand-alone, production-grade Spring
  based Applications that you can "just run".
- [Prometheus](https://prometheus.io/docs/introduction/overview/): Prometheus is an open-source systems monitoring and
  alerting toolkit originally built at SoundCloud.
- [Grafana](https://grafana.com/docs/): Grafana is the open source analytics & monitoring solution for every database.

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

## 📊 Metrics Dashboard

- Import grafana dashboards:
    - 4701 (JVM Micrometer metrics)
    - 14430 (spring boot metrics)
    - [Resilience4j Dashboard](https://resilience4j.readme.io/docs/grafana-1)
