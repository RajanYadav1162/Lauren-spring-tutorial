package config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"services", "repositories"})
public class ProjectConfig {

  @Bean
  public DataSource dataSource(){
    var datasouce = new DriverManagerDataSource();
    datasouce.setUrl("jdbc:mysql://localhost/temp");
    datasouce.setUsername("root");
    datasouce.setPassword("root");
    return datasouce;
  }

  @Bean
  public JdbcTemplate jdbcTemplate(DataSource dataSource){
    return new JdbcTemplate(dataSource);
  }

  @Bean
  public PlatformTransactionManager platformTransactionManager(DataSource dataSource){
    return new DataSourceTransactionManager(dataSource);
  }
}
