package configuration;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


//same as we learn, @configuration tells spring these classes beans need to put in context, by default spring doesn't scan for different stereotypes, so we are using @ComponenetScan
@Configuration
@ComponentScan(basePackages = {"repositories", "services"})
public class ProjectConfig {
}
