# Spring Qualifier and Primary Annotations Example

This repository contains a simple Java project that demonstrates the usage of `@Qualifier` and `@Primary` annotations in a Spring application with multiple implementations of an interface.

## Project Structure

- **Main.java**: The main class that initializes the Spring context and demonstrates the usage of the `Person` service.

- **config/ProjectConfig.java**: Configuration class that defines Spring beans, including multiple implementations of the `HelloService` interface.

- **service/HelloService.java**: Interface that declares a method for saying hi.

- **service/HelloServiceEN.java**: Implementation of `HelloService` for English greetings.

- **service/HelloServiceES.java**: Implementation of `HelloService` for Spanish greetings.

- **service/Person.java**: Service class that utilizes the `HelloService` interface with the `@Qualifier` annotation to choose a specific bean.

## Notes

- **@Qualifier Annotation**: Demonstrates the usage of @Qualifier to specify which bean to inject when there are multiple implementations of an interface.



- **@Primary Annotation**: Although not explicitly used in this example, the README.md acknowledges the option of using @Primary to designate a primary bean.

**Usage**
The Person class utilizes the HelloService interface with the @Autowired annotation and the @Qualifier("es") annotation to choose the Spanish implementation.

Uncommenting or changing the @Qualifier annotation in Person can showcase different implementations.

- Dependencies:
Spring Framework