package config;


import beans.Book;
import beans.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = ("beans"))
public class ProjectConfig {
}
