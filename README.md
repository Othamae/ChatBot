# ChatBot Project

This is a Spring Boot project for creating a chatbot. The chatbot is designed to interact using various technologies, including Spring Data JPA, Neo4j, GraphQL, and more. Below is an overview of the project structure and dependencies.

## Project Structure

The project structure follows Maven conventions and is organized as follows:

```
chatbot/
│
├── src/
│   ├── main/
│   │   ├── java/  # Java source files
│   │   └── resources/  # Configuration files and resources
│   │
│   └── test/
│       ├── java/  # Test source files
│       └── resources/  # Test configuration files and resources
│
├── pom.xml  # Maven Project Object Model file
└── README.md  # Project documentation
```

## Project Details

### Maven Configuration

The project uses Maven as a build tool and is configured with the following details in the `pom.xml` file:

- **Spring Boot Version**: 3.1.5
- **Java Version**: 17

### Dependencies

The project includes the following dependencies:

- Spring Boot Starter Data JPA
- Spring Boot Starter Data Neo4j
- Spring Boot Starter GraphQL
- Spring Boot Starter Web
- Spring Boot DevTools
- Lombok
- Spring WebMVC (Version: 6.0.13)
- Java Telegram Bot API (Version: 6.9.1)
- Stanford CoreNLP (Version: 4.5.5)
- Lingua (Version: 1.2.2)
- Spring Boot Starter Test
- Apache Solr SolrJ (Version: 9.4.0)
- Jsoup (Version: 1.16.2)
- Hibernate Core (Version: 6.3.1.Final)
- PostgreSQL (Version: 42.6.0)
- Spring WebFlux (for testing)
- Spring GraphQL Test (for testing)

### Build Configuration

The Maven build is configured with the Spring Boot Maven Plugin, excluding Lombok from the generated JAR file.

## How to Build

To build the project, ensure you have Maven installed, and run the following command in the project root directory:

```bash
mvn clean install
```

## How to Run

The project can be run as a Spring Boot application. Use the following command:

```bash
mvn spring-boot:run
```

This will start the application, and you can access it at [http://localhost:8080](http://localhost:8080).

## Notes

- Ensure that you have Java 17 installed.
- Update application-specific configurations in the `application.properties` or `application.yml` files as needed.

