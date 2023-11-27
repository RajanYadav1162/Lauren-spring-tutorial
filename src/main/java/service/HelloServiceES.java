package service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("es")
public class HelloServiceES implements HelloService{

    @Override
    public String sayHi(String name) {
        return "Hola "+ name;
    }
}
