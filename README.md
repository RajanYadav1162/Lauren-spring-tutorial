Spring AOP Project

## Overview

- This project serves as a demonstration of Aspect-Oriented Programming (AOP) within the Spring
  framework. AOP facilitates the separation of cross-cutting concerns, such as logging, security,
  and transaction management, from the core business logic. The project includes a simple
  HelloService with aspects that exemplify various AOP features.

### Getting Started

-To run the project, ensure that Maven is installed and execute the following command:

- mvn clean install
  This command will build the project and run any associated tests.

### Project Structure

Aspect classes define cross-cutting concerns.

- Key points about aspect classes:

- Aspect classes must be annotated with @Aspect.
- At least one instance of an aspect class must be present in the Spring context.
- Aspects can be instantiated using @Bean or other stereotype annotations like @Component or
  @Service.
- Enable AspectJ auto-proxy with @EnableAspectJAutoProxy.

### Example Aspect Class (HelloServiceAspects):

```@Aspect
@Component
public class HelloServiceAspects {
// ... (see code for various aspect methods)
}
```

### Aspect Annotations

## Different annotations specify when aspects should be applied. Key annotations include:

- @Before: Intercepted before method calls.
- @After: Executed after method calls.
- @AfterThrowing: Intercepted when a method throws an exception.
- @AfterReturning: Executed when a method does not throw an exception.
- @Around: Most powerful; allows complete control over method execution.

#### Code examples are available in project.

```
@Before("execution (* services.HelloService.greet(..))")
public void before() {
// ... (see code for aspect behavior)
}
```

Project Configuration

The ProjectConfig class configures the Spring context and enables **_AspectJ auto-proxy_**.

Example (ProjectConfig):

```
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"services", "aspects"})
public class ProjectConfig {
// ... (see code for configuration details)
}
```

### HelloService

The HelloService class contains the core business logic. Aspects are applied to this service to
achieve a separation of concerns.

```@Service
public class HelloService {
// ... (see code for business logic)
}
```

### Aspect Annotations Summary

- @Before: Intercepts before method calls.
- @After: Executes after method calls.
- @AfterThrowing: Intercepts when a method throws an exception.
- @AfterReturning: Executes when a method does not throw an exception.
- @Around: Provides complete control over method execution.

- ### Best Practices

1. Aspects should be used as decorators to enhance functionality, not to replace it entirely.
2. Use aspects for cross-cutting concerns like logging, security, and transaction management.
3. Maintain a clean separation of concerns by keeping business logic in dedicated classes.
