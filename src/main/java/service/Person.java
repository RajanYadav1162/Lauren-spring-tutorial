package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import service.HelloService;

@Component

public class Person {

    @Autowired
    @Qualifier("es")
    private HelloService helloService;

    public String greet(String name){
        return helloService.sayHi(name);
    }
}
