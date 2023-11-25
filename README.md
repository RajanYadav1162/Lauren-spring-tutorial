# Spring Bean Configuration Example

This project demonstrates the configuration of Spring beans using both the `@Bean` annotation and the `@Component` stereotype. It also addresses the issue of multiple beans of the same type and provides solutions to handle such scenarios.

## Project Structure

- **beans package:**
  - `Student`: Represents a simple Student class with name and age properties.
  - `Person`: An example class annotated with `@Component` to create a bean.

- **configuration package:**
  - `ProjectConfiguration`: Configuration class annotated with `@Configuration` and `@ComponentScan` to define and scan beans using `@Bean`.

- **Main class:**
  - `Main`: Entry point for the application. It demonstrates creating a Spring context and accessing beans by type and name.

## Usage

1. **Run the Application:**
    - Import the project into your favorite IDE.
    - Run the `Main` class.

2. **Understanding the Code:**
    - `ProjectConfiguration` class: Demonstrates the use of `@Bean` for manual bean configuration and `@ComponentScan` for component-based configuration.

    - `Main` class: Illustrates creating a Spring context, accessing beans by type, and solving the `NoUniqueBeanDefinitionException` issue by accessing beans by name.

## Additional Notes

- **Handling Multiple Beans of the Same Type:**
    - The project shows two ways to handle the `NoUniqueBeanDefinitionException`:
        1. Access beans by name using `context.getBean("beanName", BeanType.class)`.
        2. Use the `@Primary` annotation to specify a default bean when there are multiple beans of the same type.

- **Annotations Used:**
    - `@Component`: Used to indicate that a class is a Spring component, and a bean should be created for it.
    - `@Configuration`: Marks a class as a configuration class containing bean definitions.
    - `@Bean`: Used at the method level to define a bean.

- **Spring Context Creation:**
    - Demonstrates creating a Spring context using `AnnotationConfigApplicationContext` and providing the `ProjectConfiguration` class.

Feel free to explore and modify the code as needed for your specific use case. For more in-depth explanations, refer to the inline comments in the source code.
