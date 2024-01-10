# Reference Data API

## Introduction

The Reference Data API is a Spring Boot application designed to facilitate the retrieval of reference data from the PMM
database.
Providing a specialized endpoint `/mdh/pmm/v1/api/referencedata/retrieveinfo` for retrieving filtered data based on
reference categories.

Base Path - `/mdh/pmm/v1/api/referencedata`

Name of the JAR file - reference-0.0.1-SNAPSHOT.jar

## Prerequisites

To successfully set up and run the Reference Data API, ensure the following prerequisites are met:

- [JDK 17](https://adoptopenjdk.net/)
- [Maven 3.2+](https://maven.apache.org/)
- [PostgreSQL Database](https://www.postgresql.org/)

## Dependencies

The API relies on the following dependencies:

| Dependency                                                                                                         | Version                              |
|--------------------------------------------------------------------------------------------------------------------|--------------------------------------|
| [Spring Boot Data JPA](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa)   | 3.2.0                                |
| [Spring Boot Data REST](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-rest) | 3.2.0                                |
| [Spring Boot Web](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web)             | 3.2.0                                |
| [Spring Boot DevTools](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-devtools)           | 3.2.0                                |
| [H2 Database](https://mvnrepository.com/artifact/com.h2database/h2)                                                | 2.2.220                              |
| [PostgreSQL JDBC Driver](https://mvnrepository.com/artifact/org.postgresql/postgresql)                             | (No specific version, runtime scope) |
| [Spring Boot Test](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test)           | 3.2.0 (test scope)                   |
| [Lombok](https://projectlombok.org/)                                                                               | 1.18.30 (optional)                   |
| [Springdoc OpenAPI UI](https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui)       | 2.0.3                                |

Note: The version for `PostgreSQL ` is not specified, as it is marked with runtime scope. This means the version will be
provided at runtime based on the environment.

## Setup and Installation

Follow these steps to set up and install the Reference Data API:

1. Clone the repository.
2. Navigate to the project directory.
3. Configure the PostgreSQL database:
    - Ensure PostgreSQL is installed and running.
    - Connect with the PMM database.
    - Update the `application-pmmref.yml` file with your database credentials and URL.
4. Build the project using Maven: `mvn clean install`
5. To run the application: **Run the ReferencesApplication**
    - The mock profile will be running as it is set as active by default.
    - To run the PMM ref profile, change the active profile in `application.yml`
      to `pmmref` (`spring:profiles:active:pmmref`).

**Profiles**

This project supports two profiles: mock and pmmref. To run the application with a specific profile using terminal, use
the following
commands:

```shell
# Run with mock profile (Mock Reference Data API)
mvn spring-boot:run -Dspring-boot.run.profiles=mock

# Run with pmmref profile
mvn spring-boot:run -Dspring-boot.run.profiles=pmmref
```

## Request and Response

* **URL**: `/mdh/pmm/v1/api/referencedata/retrieveinfo`
* **Method**: `GET`
* **URL Params**:
    * Required: `category=[String]`
* **Success Response**:
    * **Code**: `200 OK`
    * **Content**: JSON array of reference data
* **Error Response**:
    * **Code**: `404`
    * **Content**: `No data found`
    * **Code**: `500`
    * **Content**: `Server Error Occurred`

## Testing the API

After running the application with the Mock profile, navigate to the following URLs to explore the Mock API:

- [Mock API Swagger UI](http://localhost:8091/v1/swagger-ui/index.html#/) - View Open API specifications UI.
- [Mock API JSON](http://localhost:8091/v1/openapi-docs) - Access the JSON representation.