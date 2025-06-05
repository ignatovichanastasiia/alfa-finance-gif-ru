# Alfa Currency Comparison Service

## Project Description

This project implements a backend microservice for currency exchange rate comparison, based on Spring Boot. The service receives a GET request with currency code, compares today's and yesterday's exchange rates against USD, and responds with a GIF reaction using GIPHY API ("rich" if currency strengthened, "broke" if weakened).

## Key Features

- RESTful HTTP endpoints
- Currency rate data retrieved from OpenExchangeRates API
- GIF reactions fetched from GIPHY API
- Configuration fully externalized via application.properties
- Multiple output formats: redirect, direct link, full GIF object

## Technologies Used

- Java 17
- Spring Boot 2.x
- REST API (GET endpoints)
- Feign (external API integration)
- Gradle (build and dependency management)

## Example Endpoints

- `/course/test` — health check
- `/course/gif/{currency}` — redirect to GIF
- `/course/gif/ref/{currency}` — return GIF link
- `/course/gif/data/{currency}` — return full GIF object

## Build & Run

- Build: `./gradlew build`
- Run: `./gradlew bootRun`
- Java 17 required

## Author

Anat (Anastasiia) Ignatovich
