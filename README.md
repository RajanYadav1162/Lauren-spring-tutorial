# Spring Application with Repository and Service Stereotypes

This project showcases a more real-world application context using Spring's `@Repository` and `@Service` stereotypes. It
introduces the concept of autowiring, where Spring automatically injects dependencies.

## Project Structure

- **configuration package:**
    - `ProjectConfig`: Configuration class annotated with `@Configuration` and `@ComponentScan` to define and scan beans
      in the "repositories" and "services" packages.

- **repositories package:**
    - `TodoRepository`: Repository class annotated with `@Repository`. It simulates handling database-related tasks.

- **services package:**
    - `TodoService`: Service class annotated with `@Service`. It demonstrates business logic and uses autowiring to
      inject the `TodoRepository` bean.

- **Main class:**
    - `Main`: Entry point for the application. Creates a Spring context and demonstrates the use of the `TodoService`
      bean.

## Usage

1. **Run the Application:**
    - Import the project into your favorite IDE.
    - Run the `Main` class.

2. **Understanding the Code:**
    - `ProjectConfig` class: Uses `@ComponentScan` to specify packages to scan for beans.

    - `TodoRepository` class: Annotated with `@Repository`, indicating a class that handles database-related tasks.

    - `TodoService` class: Annotated with `@Service`, representing a class that performs business logic. It uses
      autowiring to inject the `TodoRepository` bean.

    - `Main` class: Illustrates creating a Spring context and using the `TodoService` bean.

## Commit Details

- **Commit Message:** More real-world related Application context used with the concept of Autowiring, Repository, and
  Service stereotypes.

Feel free to explore and modify the code as needed for your specific use case. For more in-depth explanations, refer to
the inline comments in the source code.
