# Spring JDBC Template Example

This repository contains a simple Java project that demonstrates the usage of Spring JDBC Template with a MySQL database.

## Project Structure

- **Main.java**: The main class that initializes the Spring context and demonstrates the usage of the `ProductRepository`.

- **config/ProjectConfig.java**: Configuration class that defines Spring beans, such as `DataSource` and `JdbcTemplate`. It includes the setup for DataSource using `DriverManagerDataSource` and the creation of a `JdbcTemplate` bean.

- **model/Product.java**: Represents the data model for a product.

- **repository/ProductRepository.java**: Repository class that contains methods for interacting with the database using Spring JDBC Template.

- **DataSource Configuration**: The project demonstrates the configuration of a simple implementation of the DataSource interface using DriverManagerDataSource.

- **JdbcTemplate Usage**: We explore how to use Spring's JdbcTemplate to simplify database operations without the need for manual connection handling, prepared statements, etc.

- **Bean Configuration**: The ProjectConfig class showcases the usage of Spring @Configuration and @Bean annotations to define and configure beans in the application context.

**Dependencies**
- Spring Framework
- MySQL Connector
- Spring JDBC