package configuration;

import beans.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration

//by default spring doesn't scan for @Component annotation, so we are telling to scan it, and put the bean if required.
@ComponentScan(basePackages = "beans")
public class ProjectConfiguration {

    //@Bean annotation is simply put the beans in the context so that we can use it directly.
    //we can also give bean name, by default it takes the method name, but can specify custom name
    // by @Bean("helloBean"), here helloBean is the name.
    @Bean("rajan")
    public Student student(){
        Student student = new Student();
        student.setName("Rajan Yadav");
        student.setAge(23);
        return student;
    }


    //we will get .NoUniqueBeanDefinitionException if we try to use get bean by type.
    @Bean("lauren")
//    @Primary
    public Student studentDuplicate(){
        Student student = new Student();
        student.setName("Lauren Spilca");
        student.setAge(0);
        return student;
    }

}
