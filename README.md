## Spring Transactions Project Readme

### Overview

This project demonstrates the implementation of transactions in a Spring application using the following dependencies:

- spring-context: Spring core functionality.
- spring-tx: Transaction and order-related features.
- spring-jdbc: JDBC support for database operations.
- mysql-connector-java: MySQL database connector.

The primary focus is on achieving the atomicity of transactions and handling exceptions to maintain a consistent state.

### Dependencies

- spring-context: Spring core functionality.
- spring-tx: Transaction and order-related features.
- spring-jdbc: JDBC support for database operations.
- mysql-connector-java: MySQL database connector.

### Context Configuration

In the project configuration (`ProjectConfig` class), essential beans and transaction management settings are defined. Refer to [ProjectConfig](src/main/java/config/ProjectConfig.java).

### Repository

The `ProductRepository` class handles database operations related to the `Product` entity. Refer to [ProductRepository](src/main/java/repositories/ProductRepository.java).

### Service

The `ProductService` class contains business logic, and transactions are managed using the `@Transactional` annotation. Refer to [ProductService](src/main/java/services/ProductService.java).

### Main Application

The `App` class demonstrates the usage of the configured Spring context and the `ProductService`. Refer to [App](src/main/java/App.java).

### Transaction Management

- **Atomicity**: Ensured by the transaction manager, preventing inconsistent states in case of exceptions during the transaction.

- **Exception Handling**: Use of `@Transactional` ensures that the transaction is rolled back for runtime exceptions. Be cautious with different rules, such as rollback not occurring for checked exceptions.

- **Propagation**: Ensure that exceptions propagate outside the method, allowing the Spring aspect to detect and initiate a rollback.