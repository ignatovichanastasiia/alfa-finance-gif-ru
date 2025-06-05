# Alfa Currency API

**A RESTful microservice that integrates with external APIs to analyze currency exchange rates and provide dynamic GIF reactions based on the rate changes.**

> This project demonstrates integration with external APIs, RESTful service design, Feign client usage, Spring Boot architecture, configuration management, and Gradle build system.

---

## 🔧 Tech Stack

* Java 17
* Spring Boot 2.3
* Spring Cloud OpenFeign
* REST API
* Gradle
* Feign Clients
* External APIs:

  * [OpenExchangeRates.org](https://openexchangerates.org/) (currency rates)
  * [GIPHY](https://developers.giphy.com/) (GIF reactions)

---

## 💡 Project Description

The service receives HTTP GET requests with a currency code, retrieves both current and previous day exchange rates relative to USD, compares them, and returns an appropriate GIF reaction based on the change:

* If the currency rate increased or stayed the same → returns a **"rich"** GIF
* If the currency rate decreased → returns a **"broke"** GIF

---

## 🔗 Sample Endpoints

* `GET /course/test` — test endpoint to verify service is running.
* `GET /course/gif/{currencyCode}` — redirect to appropriate GIF (rich/broke).
* `GET /course/gif/ref/{currencyCode}` — return direct GIF link.
* `GET /course/gif/data/{currencyCode}` — return full GIF JSON response.

Example:

```
GET http://localhost:8080/course/gif/EUR
```

---

## 🚀 Key Features

* RESTful API design
* External API integrations via OpenFeign
* Clean code architecture (Service / Outserve layers)
* Full external configuration (application.properties)
* Gradle-based build system
* Exception handling & input validation
* Easily extendable for additional currencies or APIs

---

## ⚙️ Build & Run

### Build

```bash
gradlew clean build
```

### Run

```bash
gradlew bootRun
```

> Java 17 is required. External API keys are configured in `application.properties`.

---

## 📂 Project Structure

```
src/main/java
  └ com.ignatovichanat.alfa
      ├── controller
      ├── service
      ├── outserve
      ├── feignutill
      └── model
```

---

## ✅ Why this project is relevant

> This project was developed as part of my backend Java learning path, with a focus on **real-world integrations**, **clean microservice architecture**, and **external service communication**. It showcases my ability to work with modern Java backend technologies, 3rd-party APIs, and microservice patterns.

---

💡 **Recruiter’s Note:**

This repository demonstrates core backend developer skills:
✅ Java + Spring Boot
✅ External APIs
✅ Feign Client
✅ REST Design
✅ Clean Architecture
✅ Build automation (Gradle)

---

# 🔗 Author

**Anat Ignatovich — Junior Java Developer**
[LinkedIn Profile](https://www.linkedin.com/in/anat-ignatovich-38b59824b/)

---

