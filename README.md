# Spring Field Injection vs Constructor Injection Example

This project demonstrates the difference between field injection and constructor injection in a Spring application, using the `@Autowired` annotation for field injection and constructor injection for dependency injection.

## Project Structure

### beans package:

- **Student:** Represents a simple `Student` class.

### Main class:

- **Main:** Entry point for the application. It demonstrates the usage of `Student` class with both field and constructor injection.

## Understanding the Code

### `Student` Class

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

    // Field Injection (Uncomment the following lines to use field injection)
    /*
    @Autowired
    private Book book;
    */

    // Constructor Injection (Recommended)
    private final Book book;

    @Autowired
    public Student(Book book){
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    @Override
    public String toString() {
        return "Student{" +
                "book=" + book +
                '}';
    }
}
