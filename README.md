# Spring Bean Configuration Example

This project demonstrates how to link two beans in a Spring application using the `@Bean` annotation. It showcases two methods: one using a direct `@Bean` method and another using method injection.

## Project Structure

### beans package:

- **Student:** Represents a simple `Student` class.
- **Book:** Represents a simple `Book` class with a name property.

### configuration package:

- **ProjectConfig:** Configuration class annotated with `@Configuration`. It defines two beans - `Student` and `Book` - and demonstrates how to link them.

## Understanding the Code

### `ProjectConfig` Class

```java
@Configuration
public class ProjectConfig {

    // Method 1: Direct @Bean method
    // Uncomment the following lines to use this method
    /*
    @Bean
    public Student student(){
        Student student = new Student();
        // Spring recognizes that there is already one bean of type Book, so it will inject that.
        student.setBook(book());
        return student;
    }
    */

    // Method 2: @Bean method with method injection
    @Bean
    public Student student(Book book){
        // This method is annotated with @Bean, and Spring will automatically inject the Book bean.
        Student student = new Student();
        student.setBook(book);
        return student;
    }

    @Bean
    public Book book(){
        // This method creates a Book bean with the name "Algorithms."
        Book book = new Book();
        book.setName("Algorithms");
        return book;
    }
}
