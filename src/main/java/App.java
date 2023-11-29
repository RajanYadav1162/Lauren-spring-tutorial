import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.HelloService;

public class App {

  public static void main(String[] args) {
    try (var context = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
      var helloService = context.getBean(HelloService.class);
      // helloService.greet("Rajan Yadav");

      //we can see aspect is completely stopping the calls and modify it, we need to joinPoint to proceed mannually.
      var res = helloService.test();
      System.out.println(res);
    }
  }
}
