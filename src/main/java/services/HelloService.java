package services;

import org.springframework.stereotype.Service;

@Service
public class HelloService {


  //this is advantage of have aspects here, method looks clean, but we has a complete
  //decoupled code in HelloServiceAspects file which is so cool!!!
  public void greet(String name) {
    System.out.println("Hello " + name + " !");
  }

  public String test() {
    System.out.println("this is test");
    return "test is returning";
  }
}
