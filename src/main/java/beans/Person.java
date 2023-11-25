package beans;

//this class is similar to Student, but instead of @Bean we use @Component stereotype to create bean

import org.springframework.stereotype.Component;

//we are telling spring to create bean of this class into context,
@Component
public class Person {

    private String name;

    //since we can easily initialized beans in @Bean way, but here we have to use @PostConstruct to this same
//
//    @PostConstruct
//    private void init(){
//        this.name = "test123";
//    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
