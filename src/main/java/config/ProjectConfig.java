package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "repository")
public class ProjectConfig {

    //step 1
    //we are using simple implementation of Datasource interface, DriverManagerDataSource, this bean will
    //help in creating bean of Datasource type and put that in context.
    @Bean
    public DataSource dataSource(){
        var manager = new DriverManagerDataSource();
        manager.setUrl("jdbc:mysql://localhost/temp");
        manager.setUsername("root");
        manager.setPassword("root");
        return manager;
    }

    //for using spring-jdbc template
    //as we already know We can pass datasource as parameter or calling the bean method
    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }
}
