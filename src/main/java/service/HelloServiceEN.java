package service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("en")
public class HelloServiceEN implements HelloService{
    @Override
    public String sayHi(String name) {
        return "Hello + name";
    }
}
