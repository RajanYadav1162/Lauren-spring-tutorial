package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class HelloServiceAspects {

  @Before("execution (* services.HelloService.greet(..))")
  public void before() {
    System.out.println("I'm getting called before greet method!!");
  }

  @After("execution (* services.HelloService.greet(..))")
  public void after() {
    System.out.println("I'm getting called after greet method!!");
  }

  @AfterReturning("execution (* services.HelloService.greet(..))")
  public void afterReturning() {
    System.out.println("I'm getting called when there is no exception");
  }

  @AfterThrowing("execution (* services.HelloService.greet(..))")
  public void afterThrowing() {
    System.out.println("I'm getting called when there is an exception");
  }


  //here we are modifying the behaviour of our method!!!
  @Around("execution (* services.HelloService.test(..))")
  public Object afterThrowing(ProceedingJoinPoint joinPoint) {
    try {
      joinPoint.proceed();
      joinPoint.proceed();
      joinPoint.proceed();
    } catch (Throwable e) {
      throw new RuntimeException(e);
    }
    System.out.println("I will the stop normal call of test method");
    return "I will pass my data!!!!!";
  }
}
