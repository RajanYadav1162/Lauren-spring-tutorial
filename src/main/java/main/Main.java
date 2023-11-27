package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.Person;

import java.lang.reflect.AnnotatedArrayType;


public class Main {
    public static void main(String[] args) {
        try(var context= new AnnotationConfigApplicationContext(ProjectConfig.class)){
            var person = context.getBean(Person.class);

            //here in person greet method, it take HelloService interface and call its greet method,
            //but we have to classes that implement this interface, spring will get confused here
            //so one way is to use @Primary with one of the impl or use Qualifier to tell spring which bean you actually want.
            System.out.println(person.greet("Rajan"));

        }
    }
}
